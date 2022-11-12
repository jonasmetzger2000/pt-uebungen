package arrays.clients;

import java.util.Arrays;
import java.util.Random;

import static arrays.OneDGenerator.generate1DIntArray;
import static arrays.OneDGenerator.generate1DStringArray;
import static arrays.OneDMethods.*;
import static arrays.OneDPredicate.*;
import static arrays.OneDSort.*;
import static utils.PrintUtility.printSeparator;

public class OneDClient {


    public static void main(String[] args) {
        printSeparator("generate1DIntArray(10, -4, 7, new Random(11111))");
        int[] oneDInt = generate1DIntArray(10, -4, 7, new Random(11111));
        System.out.println(Arrays.toString(oneDInt));

        printSeparator("generate1DStringArray(10, \"mup\", 90, 110, new Random(7777778))");
        String[] oneDString = generate1DStringArray(10, "mup", 90, 110, new Random(7777778));
        System.out.println(Arrays.toString(oneDString));

        printSeparator("countEvens([-3, -4, 1, -2, 1, 7, 3, 2, 7, 2])");
        System.out.println(countEvens(oneDInt));

        printSeparator("collectIndicesOfEvens([-3, -4, 1, -2, 1, 7, 3, 2, 7, 2])");
        System.out.println(Arrays.toString(collectIndicesOfEvens(oneDInt)));

        printSeparator("deleteEvens([-3, -4, 1, -2, 1, 7, 3, 2, 7, 2])");
        System.out.println(Arrays.toString(deleteEvens(oneDInt)));

        int[] oneDInt2 = generate1DIntArray(7, -3, 15, new Random(1816731));
        printSeparator(String.format("concat(%s,%s)", Arrays.toString(oneDInt), Arrays.toString(oneDInt2)));
        System.out.println(Arrays.toString(concat(oneDInt, oneDInt2)));

        int[] oneDIntMult = new int[oneDInt.length];
        for (int i = 0; i < oneDInt.length; i++) {
            oneDIntMult[i] = oneDInt[i] * 3;
        }
        int[] oneDIntNotMult = oneDIntMult.clone();
        oneDIntNotMult[oneDIntNotMult.length - 1] = 7;
        oneDIntNotMult[new Random(34334).nextInt(oneDIntNotMult.length)] = 11;
        printSeparator(String.format("isMultiple(%s, %s)", Arrays.toString(oneDInt), Arrays.toString(oneDIntMult)));
        System.out.println(isMultiple(oneDInt, oneDIntMult));

        printSeparator(String.format("isMultiple(%s, %s)", Arrays.toString(oneDInt), Arrays.toString(oneDInt)));

        System.out.println(isMultiple(oneDInt, oneDInt));

        printSeparator(String.format("isMultiple(%s, %s)", Arrays.toString(oneDIntMult), Arrays.toString(oneDInt)));
        System.out.println(isMultiple(oneDIntMult, oneDInt));

        printSeparator(String.format("isMultiple(%s, %s)", Arrays.toString(oneDInt), Arrays.toString(oneDIntNotMult)));
        System.out.println(isMultiple(oneDInt, oneDIntNotMult));

        int[] symAry1 = {5, 3, 1, 3, 5};
        int[] symAry2 = {5, 3, 3, 5};
        int[] symAry3 = {};
        int[] notSymAry1 = {1,2,2,4};
        int[] notSymAry2 = {1,2,5,2,4};
        int[] notSymAry3 = {1,2,3,1};
        int[] notSymAry4 = {1,3,55,2,1};

        printSeparator(String.format("isSymmetric(%s)", Arrays.toString(symAry1)));
        System.out.println(isSymmetric(symAry1));

        printSeparator(String.format("isSymmetric(%s)", Arrays.toString(symAry2)));
        System.out.println(isSymmetric(symAry2));

        printSeparator(String.format( "isSymmetric(%s)",Arrays.toString(symAry3)));
        System.out.println(isSymmetric(symAry3));

        printSeparator(String.format("isSymmetric(%s)", Arrays.toString(notSymAry1)));
        System.out.println(isSymmetric(notSymAry1));

        printSeparator(String.format("isSymmetric(%s)", Arrays.toString(notSymAry2)));
        System.out.println(isSymmetric(notSymAry2));

        printSeparator(String.format("isSymmetric(%s)", Arrays.toString(notSymAry3)));
        System.out.println(isSymmetric(notSymAry3));

        printSeparator(String.format("isSymmetric(%s)", Arrays.toString(notSymAry4)));
        System.out.println(isSymmetric(notSymAry4));


        printSeparator(String.format("anyOfLenght(%s, %d)", Arrays.toString(oneDString),6));
        System.out.println(anyOfLength(oneDString,6));


        printSeparator(String.format("anyOfLenght(%s, %d)", Arrays.toString(oneDString),7));
        System.out.println(anyOfLength(oneDString,7));

        int[] oneDIntClone = oneDInt.clone();
        printSeparator(String.format("swap(%s, %d, %d)",Arrays.toString(oneDInt),0,4));
        swap(oneDInt,0,4);
        System.out.println(Arrays.toString(oneDInt));

        oneDInt = oneDIntClone.clone();
        printSeparator(String.format("moveFrom(%s, %d)",Arrays.toString(oneDInt),1));
        moveFrom(oneDInt,1);
        System.out.println(Arrays.toString(oneDInt));

        printSeparator(String.format("moveFrom(%s, %d)",Arrays.toString(oneDInt),2));
        moveFrom(oneDInt,2);
        System.out.println(Arrays.toString(oneDInt));

        printSeparator(String.format("moveFrom(%s, %d)",Arrays.toString(oneDInt),3));
        moveFrom(oneDInt,3);
        System.out.println(Arrays.toString(oneDInt));

        oneDInt = oneDIntClone.clone();
        printSeparator(String.format("sort(%s)", Arrays.toString(oneDInt)));
        sort(oneDInt);
        System.out.println(Arrays.toString(oneDInt));

    }
}
