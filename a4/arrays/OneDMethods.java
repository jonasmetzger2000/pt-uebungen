package arrays;

import java.util.Arrays;
import java.util.stream.Stream;

public class OneDMethods {

    public static int countEvens(int[] ary) {
        int counter = 0;
        for (int i = 0; i < ary.length; i++)
            if (isEven(ary[i])) counter++;
        return counter;
    }

    public static int[] collectIndicesOfEvens(int[] ary) {
        int[] result = new int[countEvens(ary)];
        int evenNumbers = 0;
        for (int i = 0; i < ary.length; i++) {
            int current = ary[i];
            if (isEven(current))
                result[evenNumbers++] = i;
        }
        return result;
    }

    public static int[] deleteEvens(int[] ary) {
        int[] result = new int[ary.length - countEvens(ary)];
        int evenNumbers = 0;
        for (int i = 0; i < ary.length; i++) {
            if (!isEven(ary[i])) {
                result[evenNumbers++] = ary[i];
            }
        }
        return result;
    }

    public static int[] concat(int[] ary1, int[] ary2) {
        int[] concatArr = new int[ary1.length + ary2.length];
        for (int i = 0; i < ary1.length; i++) {
            concatArr[i] = ary1[i];
        }
        for (int i = 0; i < ary2.length; i++) {
            concatArr[i+ary1.length] = ary2[i];
        }
        return concatArr;
    }

    private static boolean isEven(int number) {
        return number % 2 == 0;
    }


}
