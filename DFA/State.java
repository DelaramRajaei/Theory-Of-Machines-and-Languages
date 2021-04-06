import java.util.*;

public class State {

    private String currentState;
    public boolean start = false;
    public boolean finish = false;
    private HashMap<String,ArrayList<String>> transitions = new HashMap<String,ArrayList<String>>();
    private Set set = new HashSet();

    public String getCurrentState() {
        return currentState;
    }

    public void setCurrentState(String currentState) {
        this.currentState = currentState;
    }

    public HashMap<String, ArrayList<String>> getTransitions() {
        return transitions;
    }

    public void setTransition(HashMap<String, ArrayList<String>> transitions) {
        this.transitions = transitions;
    }

    public void addTransitions(String alphabet, ArrayList<String> transition) {
        transitions.put(alphabet, transition);
    }



}
