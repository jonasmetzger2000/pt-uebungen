package arrays;

/**
 * Beinhaltet die Aufgaben zu den 1-dimensionalen Arrays Methoden
 */
public class OneDMethods {

    /**
     * Zählt die graden Zahlen im gegebenen Array
     * @param ary nach graden Zahlen zu suchendes Array
     * @return anzahl von graden Zahl im Array
     */
    public static int countEvens(int[] ary) {
        int counter = 0;
        for (int i = 0; i < ary.length; i++)
            if (isEven(ary[i])) counter++;
        return counter;
    }

    /**
     *  Sammelt die Stellen der Vorkommen der graden Zahlen und gibt dieser zurück
     * @param ary zu suchendes Array
     * @return alle vorkommen bzw. deren Indices als eigenes array
     */
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

    /**
     * Sammelt alle ungraden Zahlen und gibt diese aus. Es werden alle graden Zahlen gefiltert.
     * @param ary array bei dem die graden Zahlen gelöscht werden
     * @return neues array mit nur den ungraden Zahlen
     */
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

    /**
     * Hängt ein Array an ein anderes heran, erstellt dabei ein neues
     * @param ary1 linkes array
     * @param ary2 rechts array, wird and linked array angehängt
     * @return gibt beide arrays zusammengefügt wieder
     */
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
