/**
 * Gibt alle Zeichen zwischen einen gegebenen Start und Endzeichen aus. Die einzelnen
 * Zeichen werden in 10er Gruppen formatiert und durch ein ":" zwischen den Zeichen und
 * des Codes formatiert. Beispiel: <i>@: 64</i>.
 * @author kerim, jonas
 */
public class CharacterPrinter {
    /**
     * Gibt alle Zeichen zwischen einen Startzeichen (<strong>args[0]</strong>) und einen
     * Endzeichen (<strong>args[1]</strong>) aus. Die Eingabeparameter müssen eine Ganzzahl
     * sein. Die einzelnen Zeichen werden in 10er Gruppen pro Zeile formatiert und durch
     * (zahl):(zeichen) formatiert.
     * @param args
     *             <strong>args[0]:</strong> integer, Startzeichen
     *             <strong>args[1]:</strong> integer, Endzeichen
     */
    public static void main(String[] args) {
        // parse input from arguments
        int start = Integer.parseInt(args[0]);
        int end = Integer.parseInt(args[1]);

        // print formatted numbers grouped as 10 per line
        for (int i = start; i < end; i++) {
            System.out.printf("%c: %d ", (char)i, i);
            if ((i-start) % 10 == 9) System.out.printf("%n");
        }
    }
}
