import java.util.ArrayList;
import java.util.HashMap;

public class Main {

    public static void main(String[] args) {

        ArrayList<String> alphabets = new ArrayList<String>();
        HashMap<String, State> nfaStates = new HashMap<String, State>();


        ReadFile.readFile(alphabets, nfaStates);

        Conversion.conversion(nfaStates, alphabets);

        PrintStates.print(nfaStates, alphabets);

    }
}
