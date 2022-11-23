package arrays;

import java.util.Arrays;
import java.util.Random;

/**
 * Beinhaltet die Aufgaben zu den 1-dimensionalen Array Generatoren
 */
public class OneDGenerator {

    /**
     * generiert ein Array der Länge n mit den Werten zwischen min bis max
     * @param n länge des arrays
     * @param min minimaler wert der zu erzeugenden Werte im Array
     * @param max maximaler wert der zu erzeugenden Werte im Array
     * @param rand zu benutzende Random Instanz
     * @return generierter Array mit Zufallswerten
     */
    public static int[] generate1DIntArray(int n, int min, int max, Random rand) {
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = rand.nextInt(min,max+1);
        }
        return arr;
    }

    /**
     * generiert ein String-Array der Länge n mit den Werten zwischen min bis max. Die Werte werden zu ein String
     * zusammengesetzt und pre als Prefix angehngt
     * @param n länge des arrays
     * @param pre zu benutzender Prefix
     * @param min minimaler wert der zu erzeugenden Werte im Array
     * @param max maximaler wert der zu erzeugenden Werte im Array
     * @param rand zu benutzende Random Instanz
     * @return generierter Array mit Zufallswerten
     */
    public static String[] generate1DStringArray(int n, String pre, int min , int max, Random rand) {
        String[] arr = new String[n];
        for (int i = 0; i < n; i++) {
            arr[i] = pre + rand.nextInt(min,max+1);
        }
        return arr;
    }


}
