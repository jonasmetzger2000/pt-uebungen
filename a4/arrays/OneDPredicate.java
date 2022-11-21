package arrays;

import javax.naming.PartialResultException;

public class OneDPredicate {

    private OneDPredicate() {
    }

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
