package iteration;

/**
 * Zeichnet n-Zahlen auf das sout, alle 10 Zahlen (inc. 0) werden durch einen Zeilenumbruch terminiert.
 * @author jonas,kerim
 * @version 0.1
 */
public class FormattedNumbers {

    /**
     * @param args <strong>[0]:</strong> Integer, Anzahl der Zahlen die auf das sysout dargestellt werden sollen
     */
    public static void main(String... args) {
        int maxNumber = Integer.parseInt(args[0]);
        for (int i = 0; i < maxNumber; i++) {
            if (i % 10 == 0) System.out.printf("%n");
            System.out.print(String.format("%s ", i));
        }
    }

}
