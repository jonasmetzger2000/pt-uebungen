package arrays;

import java.util.Arrays;
import java.util.Random;

public class OneDGenerator {

    public static int[] generate1DIntArray(int n, int min, int max, Random rand) {
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = rand.nextInt(min,max+1);
        }
        return arr;
    }

    public static String[] generate1DStringArray(int n, String pre, int min , int max, Random rand) {
        String[] arr = new String[n];
        for (int i = 0; i < n; i++) {
            arr[i] = pre + rand.nextInt(min,max+1);
        }
        return arr;
    }


}
