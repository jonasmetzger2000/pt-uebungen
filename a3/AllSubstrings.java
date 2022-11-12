/**
 * Gibt alle Teilzeichenketten einer gegebenen Zeichenkette
 * aus, zusätzlich mit deren Bereich. e.g
 * ähnlich zu der mathematischen Potenzmengen Funktion
 */
public class AllSubstrings {
    /**
     * Gibt die atomaren Ketten einer Zeichenkette aus.
     * Jede Teilzeichenkette wird zusammen mit den Bereich
     * in einer Zeile ausgegeben.
     * @param args <br>
     *             <strong>args[0]:</strong> string, String deren Potenzmenge gebaut werden soll
     */
    public static void main(String[] args) {
//        String text = args[0];
        String text = "abcde";
        for (int i = 0; i < text.length(); i++)
            for (int k = i+1; k < text.length() + 1; k++) {
                System.out.printf("go to %s-%s:%s%n", i, k, text.substring(i, k));
            }
    }
}
