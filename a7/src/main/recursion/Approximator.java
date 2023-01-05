package recursion;

public class Approximator {

    public static void main(String[] args) {
        int zahl = 100;
        System.out.println("Math Log: " + Math.log(zahl));
        System.out.println("Math lnIter: " + lnIter(zahl, 150));
        System.out.println("Math lnRec: " + lnRec(zahl, 150));
        System.out.println("Math lnRecTail: " + lnRecTail(zahl, 150));
    }

    public static double lnIter(double x, int n) {
        checkArgs(n);
        double sum = 0;
        for (int i = 1; i < n+1; i++) {
            final double formula = formula(x, i);
            sum += formula;
        }
        return sum;
    }

    public static double lnRec(double x, int n) {
        checkArgs(n);
        return lnRec(x, 1, n);
    }

    private static double lnRec(double x, int n, int max) {
        if (n > max) {
            return 0;
        }
        return formula(x, n) + lnRec(x, ++n, max);
    }

    public static double lnRecTail(double x, int n) {
        checkArgs(n);
        return lnRecTail(x, 1, n);
    }

    private static double lnRecTail(double x, int n, int max) {
        if (n > max) {
            return 0;
        }
        return lnRec(x, n+1, max) + formula(x, n);
    }

    private static void checkArgs(double x) {
        if (x <= 0.5) {
            throw new IllegalArgumentException("Illegal x > 0.5");
        }
    }

    private static double formula(double x, double i) {
        return Math.pow(x-1, i)/(i*Math.pow(x, i));
    }

}
