
public class Splitter {
    /**
     * Split a line into array of strings.
     * @param line
     * @return
     */
    public static String[] split(String line) {

        if (line == null) return null;
        String[] splittedLine = line.split("\\s+", -1);
        return splittedLine;
    }
}
