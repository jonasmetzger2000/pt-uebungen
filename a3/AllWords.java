import java.util.ArrayList;

/**
 * Nimmt einen gegebenen Satz und gibt alle
 * Wörter nummeriert und seperat aus
 * @author kerim, jonas
 */
public class AllWords {
    /**
     * Nimmt einen String und seperiert den Satz nach jedem Whitespace
     * und gibt jedes Wort im Satz in einer Zeile und Nummerierung aus
     * @param args <br>
     *             <strong>args[0]:</strong> string, Satz der nummertiert und seperat ausgegeben wird
     */
    public static void main(String[] args) {
        String text = args[0];
//        String text = "go home and feel well";

        int word = 0;
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < text.length(); i++) {
            char current = text.charAt(i);
            if (Character.isWhitespace(current)) {
                stringBuilder.append(current);
            } else {
                System.out.printf("%d:%s%n", word++, stringBuilder);
                stringBuilder = new StringBuilder();
            }
        }
    }
}
