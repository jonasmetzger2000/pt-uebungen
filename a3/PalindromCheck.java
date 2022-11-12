/**
 * Überprüft ob ein gegebener Text ein Palindrom ist,
 * e.g ob der gegebene Text sowohl von links nach rechts
 * als auch von rechts nach links gleich gelesen werden kann
 * Die Groß und Kleinschreibung ist hierbei irrelevant
 * @author kerim, jonas
 */
public class PalindromCheck {
    /**
     * Iteriert über die erste Hälfte des gegebenen Strings und überprüft
     * ob auch auf der anderen Hälfte der gleiche Character steht. Hierbei
     * wird Groß und Kleinschreibung ignoriert.
     * @param args <br>
     *             <strong>args[0]:</strong> string, Text der auf das Palindrom überprüft werden soll
     */
    public static void main(String[] args) {
        String input = args[0];
//        String input = "Regallager";
        String text = input.toLowerCase();

        boolean isPalindrom = true;
        for (int i = 0; i < text.length() / 2; i++) {
            if (text.charAt(i) != text.charAt(text.length()-i-1)) {
                isPalindrom = false;
                break;
            }
        }
        if (isPalindrom) {
            System.out.printf("'%s' ist ein Palindrom!%n", input);
        } else {
            System.out.printf("'%s' ist kein Palindrom!%n", input);
        }
    }
}
