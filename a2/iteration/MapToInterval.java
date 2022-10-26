package iteration;

import java.util.Scanner;

/**
 * Akzeptiert einen Intervall z.B 13 - 20. So wird aus den Intervall 13 - 20 ein Zahlenstrahl 0 -> 8 gebildet. Alle
 * nachfolgenden Zaheln werden durch 8 terminiert. Sprich 13-20, 21-28, 29-36,... . Durch eine weitere Eingabe
 * von Zahlen kann der unterliegende Intervall bestimmt werden. e.g 22->14, 21->13, 55->15. Eingaben niedriger als
 * das Intervallende werden ignoriert. Durch Eingabe von den oberen Intervallende wird das Programm beendet.
 * Alle Eingaben werden durch das Sysin abgefragt.
 * @author jonas,kerim
 * @version 0.1
 */
public class MapToInterval {

    public static void main(String... args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Bitte geben sie den lowerBound ein >>");
        int lowerBound = scanner.nextInt();
        System.out.print("Bitte geben sie den upperBound ein >>");
        int upperBound = scanner.nextInt();

        while (true) {
            System.out.printf("Bitte geben sie eine Zahl >= %s ein >>", lowerBound);
            int nextNumber = scanner.nextInt();
            if (nextNumber == upperBound) { break; }
            if (nextNumber < lowerBound) continue;
            if (nextNumber < upperBound) continue;

            int diff = upperBound - lowerBound+1;
            int spatial = (nextNumber-lowerBound) % diff;
            int shiftUp = nextNumber - spatial;

            int mappedNumber = nextNumber-shiftUp+lowerBound;
            System.out.printf("Mapped %s onto %s%n", nextNumber, mappedNumber);
        }
    }
}
