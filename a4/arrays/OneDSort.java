package arrays;

import javax.naming.PartialResultException;
import java.util.Arrays;
import java.util.stream.Stream;

public class OneDSort {

    public static void swap(int[] ary, int i , int j){
        int temp = ary[i];
        ary[i] = ary[j];
        ary[j] = temp;
    }

    public static void moveFrom(int[] ary, int from){
        int index = from;
        while (index != 0 && ary[index-1] > ary[index]) {
            swap(ary, index, --index);
        }
    }

    public static void sort(int[] ary) {
//        Arrays.sort(ary);
        for (int i = 0; i < ary.length; i++) {
            moveFrom(ary, i);
        }
    }
}
