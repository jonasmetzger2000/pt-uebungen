package arrays.clients;

import arrays.Matrix;

import java.util.Arrays;

import static utils.PrintUtility.printSeparator;

public class MatrixClient {    public static void main(String[] args) {

    printSeparator("Matrix mat = new Matrix(3,7);");
    Matrix mat = new Matrix(3,7);
    System.out.println(mat);

    printSeparator(String.format("%s.rows()",Arrays.deepToString(mat.toArray())));
    System.out.println(mat.rows());
    printSeparator(String.format("%s.cols()",Arrays.deepToString(mat.toArray())));
    System.out.println(mat.cols());

    printSeparator(String.format("%s.copyFrom(null)",Arrays.deepToString(mat.toArray())));
    System.out.println(mat.copyFrom(null));

    printSeparator(String.format("%s.copyFrom(%s)",Arrays.deepToString(mat.toArray()),
            Arrays.deepToString(new int[][]{{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, null, {15, 16, 17, 18, 19, 20, 21}})));
    System.out.println(mat.copyFrom(new int[][]{{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, null, {15, 16, 17, 18, 19, 20, 21}}));

    printSeparator(String.format("%s.copyFrom(%s)",Arrays.deepToString(mat.toArray()),
            Arrays.deepToString(new int[][]{{1,2,3,4,5,6,7,8,9,10},{8,9,10}, {15, 16, 17, 18, 19, 20, 21},
                    {22, 23,24}})));
    mat.copyFrom(new int[][]{{1,2,3,4,5,6,7,8,9,10},{8,9,10}, {15, 16, 17, 18, 19, 20, 21},
            {22, 23,24}});
    System.out.println(mat);

    printSeparator("Matrix.toArray()");
    System.out.println(Arrays.deepToString(mat.toArray()));

    printSeparator("Matrix deepCopy = mat.deepCopy()");
    Matrix deepCopy = mat.deepCopy();
    System.out.println(deepCopy);

    printSeparator("deepCopy.put(0,0,999)");
    deepCopy.put(0,0, 999);
    printSeparator("deepCopy");
    System.out.println(deepCopy);
    printSeparator("mat");
    System.out.println(mat);

    printSeparator("mat.add(deepCopy)");
    Matrix added = mat.add(deepCopy);
    System.out.println(added);

    printSeparator("mat.mult(2)");
    Matrix mult = mat.mult(2);
    System.out.println(mult);

    printSeparator("mat.sub(deepCopy)");
    Matrix sub = mat.sub(deepCopy);
    System.out.println(sub);
    }
}
