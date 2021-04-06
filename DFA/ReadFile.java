import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class ReadFile {


    public static void readFile(ArrayList<String> alphabets, HashMap<String, State> states, boolean flag) {

        String[] splittedLine = null;
        File textFile = SelectFile.selectFile();
        State state;
        ArrayList<String> transition = new ArrayList<String>();
        Set set=new HashSet();

        if (textFile == null) return;
        else {
            try {
                Scanner scan = new Scanner(textFile);

                //First Line
                splittedLine = Splitter.split(scan.nextLine());
                Collections.addAll(alphabets, splittedLine);

                //Second Line
                splittedLine = Splitter.split(scan.nextLine());
                for (int i = 0; i < splittedLine.length; i++) {
                    state = new State();
                    state.setCurrentState(splittedLine[i]);
                    states.put(state.getCurrentState(), state);
                }

                //Third and Forth Line
                String s = scan.nextLine();
                splittedLine = Splitter.split(scan.nextLine());

                for (State eachState : states.values()) {
                    if (eachState.getCurrentState().equals(s)) {
                        eachState.start = true;
                    }
                    for (int i = 0; i < splittedLine.length; i++) {
                        if (eachState.getCurrentState().equals(splittedLine[i]))
                            eachState.finish = true;
                    }

                }


                //Other Lines
                while (scan.hasNextLine()) {
                    splittedLine = Splitter.split(scan.nextLine());
                    if (states.containsKey(splittedLine[0])) {
                        if (states.get(splittedLine[0]).getTransitions().containsKey(splittedLine[1])) {
                            set.addAll( states.get(splittedLine[0]).getTransitions().get(splittedLine[1]));
                        }
                        set.add(splittedLine[2]);
                        transition = new ArrayList<>(set);
                        if (transition.size()>1 && !flag)flag=true;
                        set.clear();
                        if (alphabets.contains(splittedLine[1])) {
                            states.get(splittedLine[0]).addTransitions(splittedLine[1], transition);
                        }
                    }
                }


            } catch (FileNotFoundException e) {
                System.out.println("An error occurred.");
                e.printStackTrace();
            }
        }

    }
}


