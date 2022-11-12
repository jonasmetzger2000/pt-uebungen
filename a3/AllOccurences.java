/**
 * Bestimmt alle Vorkommen eines Textes innerhalb eines Textes
 * und gibt dessen Bereiche aus.
 * @author kerim, jonas
 */
public class AllOccurences {

    /**
     * Erkennt alle Vorkommen eines String innerhalb eines String und
     * gibt deren Vorkommen als Intervall an. Die einzelnen Intervalle
     * werden zeilenweise ausgegeben. Wird kein Vorkommen gefunden, so
     * wird auch keine Ausgabe ausgegeben.
     * @param args unused
     */
    public static void main(String[] args) {
//        String string = "";
        String string = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore ipsum et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.";
        String toSearch = "do";

        int length = toSearch.length();
        int index = 0;
        do {
            index = string.indexOf(toSearch, index);
            if (index != -1) {
                System.out.printf("[%d-%d]%n", index, index+length);
                index++;
            }
        } while (index != -1);
    }
}
