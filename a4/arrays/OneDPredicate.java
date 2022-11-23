package arrays;

import javax.naming.PartialResultException;

/**
 * Beinhaltet die Aufgaben C für Prädikate der eindimensionalen Arrays
 */
public class OneDPredicate {

    /**
     * Vergleicht Element zu Element von zwei gegebenen Zahlenreihen ob diese ein Vielfaches sind
     * @param ary1 
     * @param ary2
     * @return
     */
    public static boolean isMultiple(int[] ary1, int[] ary2) {
        for (int i = 0; i < ary1.length; i++) {
            int left = ary1[i];
            int right = ary2[i];

            if (left % right == 0) return false;
        }
        return true;
    }

    public static boolean isSymmetric(int[] ary) {
        for (int i = 0; i < ary.length/2; i++) {
            if (ary[i] != ary[ary.length-i-1]) return false;
        }
        return true;
    }

    public static boolean anyOfLength(String[] ary, int length) {
        for (String str : ary) {
            if (str.length() == length) return true;
        }
        return false;
    }
}
