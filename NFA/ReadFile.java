import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class ReadFile {


    public static void readFile(ArrayList<String> alphabets, HashMap<String, State> states) {

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
                alphabets.add("?");

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
                        set.clear();
                        if (alphabets.contains(splittedLine[1])) {
                            states.get(splittedLine[0]).addTransitions(splittedLine[1], transition);
                        }
                        if (splittedLine[1].equals("?")) {
                            states.get(splittedLine[0]).addName(splittedLine[2]);
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


