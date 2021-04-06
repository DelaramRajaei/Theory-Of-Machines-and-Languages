import java.util.ArrayList;
import java.util.HashMap;

public class PrintStates {

    public static void print(HashMap<String, State> nfaStates, ArrayList<String> alphabets) {

        for (State eachState : nfaStates.values()) {

            for (String eachLetter : alphabets) {

                System.out.println("["+eachState.getCurrentState()+"]" + " " + eachLetter
                        + " " + eachState.getTransitions().get(eachLetter).toString());
            }
        }

    }
}
