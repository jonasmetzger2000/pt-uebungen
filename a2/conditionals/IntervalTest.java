package conditionals;

/**
 * Testet ob eine Zahl (arg1) im Intervall [arg2-arg3] liegt.
 * @author jonas,kerim
 * @version 0.1
 */
public class IntervalTest {

    /**
     * @param args <strong>[0]:</strong> Integer Zahl. Mit der gegebenen Zahl wird überprüft ob diese im Intervall liegt<br> <strong>[1]:</strong> Integer, unterer Intervall anfang<br> <strong>[2]:</strong> Integer, oberes Intervall ende
     */
    public static void main(String... args) {
        int value = Integer.parseInt(args[0]);
        int lowerBound = Integer.parseInt(args[1]);
        int upperBound = Integer.parseInt(args[2]);

        if (lowerBound > upperBound) {
            System.err.printf("not a valid interval upper %s < lower %s%n", upperBound, lowerBound);
        } else if (value > upperBound) {
            System.err.printf("%s not in [%s,%s] %s > %s%n", value, lowerBound, upperBound, value, upperBound);
        } else if (value < lowerBound) {
            System.err.printf("%s not in [%s,%s] %s < %s%n", value, lowerBound, upperBound, value, lowerBound);
        }

        System.out.printf("%s in [%s,%s]%n", value, lowerBound, upperBound);
    }
}