package arrays;

import javax.naming.PartialResultException;

/**
 * Beinhaltet die Aufgaben C für Prädikate der eindimensionalen Arrays
 */
public class OneDPredicate {

    /**
     * Vergleicht Element zu Element von zwei gegebenen Zahlenreihen ob diese ein Vielfaches sind
     * @param ary1 array eins, vielfache
     * @param ary2 array zwei, faktor
     * @return wenn alle konkurriende Elemente ein vielfaches sind true, ansonsten false
     */
    public static boolean isMultiple(int[] ary1, int[] ary2) {
        for (int i = 0; i < ary1.length; i++) {
            int left = ary1[i];
            int right = ary2[i];

            if (left % right == 0) return false;
        }
        return true;
    }

    /**
     * Überprüft ob das gegebene Array symmetrisch zueinander ist, ähnlich zum Palindromecheck
     * @param ary zu überprüfendes Array
     * @return wenn array symmetrisch true, ansonsten false
     */
    public static boolean isSymmetric(int[] ary) {
        for (int i = 0; i < ary.length/2; i++) {
            if (ary[i] != ary[ary.length-i-1]) return false;
        }
        return true;
    }

    /**
     * Überprüft ob irgendein Element die gleich Länge besitzt
     * @param ary zu überprüfendes Array
     * @param length zu suchende Lönge
     * @return wenn länge gefunden, true ansonsten false
     */
    public static boolean anyOfLength(String[] ary, int length) {
        for (String str : ary) {
            if (str.length() == length) return true;
        }
        return false;
    }
}
