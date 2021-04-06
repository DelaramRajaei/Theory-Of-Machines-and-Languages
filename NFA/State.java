import java.util.*;

public class State {

    private String currentState;
    private ArrayList<String> stateName = new ArrayList<>();
    public boolean start = false;
    public boolean finish = false;
    private HashMap<String, ArrayList<String>> transitions = new HashMap<String, ArrayList<String>>();
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

    public ArrayList<String> getStateNames() {
        return stateName;
    }

    public void setStateName(ArrayList<String> stateName) {
        this.stateName = stateName;
    }

    public void addName(String name) {


        set.addAll(stateName);

        if (name != null) {
            set.add(name);

            stateName.clear();
            stateName.addAll(set);
            set.clear();

        }

    }

    public void mergeTransitions(HashMap<String, ArrayList<String>> t2) {
        ArrayList<String> temp;

        for (String s : t2.keySet()) {
            if (transitions.get(s) == null) {
                temp = new ArrayList<String>();
                temp.addAll(t2.get(s));
                transitions.put(s, temp);
            } else {
                set.addAll(t2.get(s));
                set.addAll(transitions.get(s));
                transitions.get(s).clear();
                transitions.get(s).addAll(set);
                set.clear();
            }

        }
    }
}
