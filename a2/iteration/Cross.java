package iteration;

/**
 * Zeichnet ein Kreuz auf das Sysout. Zwei Parameter steuern die Anzahl von Reihen und Zeilen
 * @author jonas,kerim
 * @version 0.1
 */
public class Cross {

    /**
     * Zeichnet ein Kreuz auf die Konsole
     * @param args <strong>[0]:</strong> Integer, Anzahl von Reihen<br><strong>[1]:</strong> Integer, Anzahl von Zeilen
     */
    public static void main(String[] args) {
        int rows = Integer.parseInt(args[0]);
        int cols = Integer.parseInt(args[1]);

        if (rows % 2 == 0 || cols % 2 == 0) {
            System.err.printf("%s or %s is even%n", rows, cols);
        } else {
            int crossRow = rows/2+1;
            int crossCol = cols/2+1;
            for (int col = 1; col < cols + 1; col++) {
                for (int row = 1; row < rows + 1; row++) {
                    if (row == crossRow || col == crossCol)
                        System.out.print("* ");
                    else System.out.print("  ");
                }
                System.out.println();
            }
        }
    }
}
