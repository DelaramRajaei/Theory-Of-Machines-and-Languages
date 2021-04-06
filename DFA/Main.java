import java.util.ArrayList;
import java.util.HashMap;

public class Main {

    public static void main(String[] args) {

        ArrayList<String> alphabets = new ArrayList<String>();
        HashMap<String, State> states = new HashMap<String, State>();
        boolean flag = false;


        ReadFile.readFile(alphabets, states, flag);

         if (!flag) {
            for (State eachState : states.values()) {
                for (String letter : alphabets) {
                    if (!eachState.getTransitions().containsKey(letter)){
                        flag=true;
                        break;
                    }
                }
                if (flag)break;
            }
        }

        if (flag) System.out.println("This string is not accepted by DFA!");
        else System.out.println("This string is accepted by DFA!");
    }
}
