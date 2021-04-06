import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class Conversion {

    public static void conversion(HashMap<String, State> nfaStates, ArrayList<String> alphabets) {

        String temp;
        State newState;
        State trap = new State();
        ArrayList<String> tempArray = new ArrayList<String>();

        trap.setCurrentState("trap");
        tempArray.add(trap.getCurrentState());


        //Conversion of NFA with ε to NFA
        LambdaClosure.lambadaClosure(nfaStates);
        alphabets.remove("?");


        //Conversion of NFA to DFA
        for (String s : alphabets) {
            trap.getTransitions().put(s, tempArray);
        }
        HashMap<String, State> dfaState = new HashMap<String, State>(nfaStates);

        for (State eachState : dfaState.values()) {
            for (String letter : alphabets) {


                if (eachState.getTransitions().containsKey(letter)) {
                    Collections.sort(eachState.getTransitions().get(letter));
                    temp = eachState.getTransitions().get(letter).toString().substring(1,eachState.getTransitions().get(letter).toString().length()-1);

                    if (!nfaStates.containsKey(temp)) {
                        newState = new State();
                        newState.setCurrentState(temp);
                        for (String s : eachState.getTransitions().get(letter)) {
                            newState.addName(s);
                        }
                        nfaStates.put(temp, newState);


                        for (State neighbor : nfaStates.values()) {
                            if (newState != neighbor && newState.getStateNames().contains(neighbor.getCurrentState())) {

                                newState.mergeTransitions(neighbor.getTransitions());
                            }
                        }
                    }
                } else {

                    nfaStates.put(trap.getCurrentState(), trap);
                    eachState.getTransitions().put(letter, tempArray);

                }
            }
        }
    }

}


