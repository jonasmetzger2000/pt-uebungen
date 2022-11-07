/**
 * Wandelt den ersten Buchstaben eines gegebenen Textes in Großbuchstaben und
 * alle weiteren Buchstaben in Kleinbuchstaben.
 * @author kerim, jonas
 */
public class Capitalize {
    /**
     * Liest einen String zeichenweise ein und konvertiert den ersten Buchstaben
     * in Großbuchstaben und alle weiteren in Kleinbuchstaben. Der
     * transformierte String wird in einer Zeile ohne Leerzeichen ausgegeben.
     * Der Parameter wird aus den Argumenten gelesen.
     * @param args <br>
     *             <strong>args[0]:</strong> string, zu konvertierender Text
     */
    public static void main(String[] args) {
        // argumente definieren
        String textToCapitalize = args[0];

        // string formatiert ausgeben
        for (int i = 0; i < textToCapitalize.length(); i++) {
            char current = textToCapitalize.charAt(i);
            // keine leerzeichen ausgeben
            if (current != ' ') {
                // der erste Buchstabe soll als Großbuchstabe formatiert sein
                if (i == 0) System.out.print(Character.toUpperCase(current));
                // der zweite Buchstabe soll als Kleinbuchstabe formatiert sein
                else System.out.print(Character.toLowerCase(current));
            }
        }
    }
}
