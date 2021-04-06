import java.util.HashMap;


public class LambdaClosure {

    public static void lambadaClosure(HashMap<String, State> nfaStates) {

        for (State eachState : nfaStates.values()) {
            if (eachState.getTransitions().get("?") != null) {

                for (State neighbor : nfaStates.values()) {
                    if (eachState != neighbor && eachState.getStateNames().contains(neighbor.getCurrentState())) {

                     eachState.mergeTransitions(neighbor.getTransitions());
                    }
                }
                eachState.getTransitions().remove("?");
            }
        }

    }
}
