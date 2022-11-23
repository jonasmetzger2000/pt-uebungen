package arrays;


/**
 * Aufgaben zu 1 dimensionalen Arrays zur Sortierung
 */
public class OneDSort {

    /**
     * Nimmt ein array und tauscht gegebene Positionen miteinander
     * @param ary zu tauschendes Array
     * @param i position des zu tauschenden Elementes
     * @param j position des zu tauschenden Elementes
     */
    public static void swap(int[] ary, int i , int j){
        int temp = ary[i];
        ary[i] = ary[j];
        ary[j] = temp;
    }

    /**
     * Tauscht das Element an gegebener Stelle bis das Element auf der linken Seite kleiner ist als das tauschende Element
     * @param ary zu tauschendes Element
     * @param from index des zu bewegendes Element
     */
    public static void moveFrom(int[] ary, int from){
        int index = from;
        while (index != 0 && ary[index-1] > ary[index]) {
            swap(ary, index, --index);
        }
    }

    /**
     * Sortiert ein gegebenes Array, kleinste Elemente werden links sortiert
     * @param ary zu sortierendes Array
     */
    public static void sort(int[] ary) {
//        Arrays.sort(ary);
        for (int i = 0; i < ary.length; i++) {
            moveFrom(ary, i);
        }
    }
}
