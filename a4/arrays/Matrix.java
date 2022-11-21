package arrays;

public class Matrix {

    private int[][] array;
    private int rows;
    private int cols;

    public Matrix(int rows, int cols){
        array = new int[rows][cols];
        this.rows = rows;
        this.cols = cols;
    }

    private boolean is2D(int[][] ary){
        for (int[] inner : ary)
            if (inner == null) return false;
        return true;
    }

    public int rows(){
        return rows;
    }

    public int cols(){
        return cols;
    }

    public boolean copyFrom(int[][] ary2D){
        if (ary2D == null || !is2D(ary2D)) return false;

        for (int row = 0; row < rows; row++) {
            if (ary2D.length <= row) continue;
            for (int col = 0; col < cols; col++) {
                if (ary2D[row].length <= col) continue;
                array[row][col] = ary2D[row][col];
            }
        }
       return true;
    }

    public int[][] toArray(){
        int[][] array = new int[rows][cols];
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                array[row][col] = this.array[row][col];
            }
        }
        return array;
    }

    public Matrix deepCopy(){
        Matrix newMatrix = new Matrix(rows, cols);
        newMatrix.copyFrom(toArray());
        return newMatrix;
    }

    public void put(int row, int col, int value){
        array[row][col] = value;
    }

    public int get(int row, int col){
        return array[row][col];
    }

    public Matrix add(Matrix other){
        Matrix copy = deepCopy();
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                copy.put(row, col, copy.get(row, col) + other.get(row, col));
            }
        }
        return copy;
    }

    public Matrix mult(int value){
        Matrix copy = deepCopy();
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                copy.put(row, col, copy.get(row, col) * value);
            }
        }
        return copy;
    }

    public Matrix sub(Matrix other){
        Matrix copy = deepCopy();
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                copy.put(row, col, copy.get(row, col) - other.get(row, col));
            }
        }
        return copy;
    }

    private int maxElemSpace(){
        int max = 0;
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                int current = get(row, col);
                if (current > max)
                    max = current;
            }
        }
        return max;
    }

    @Override
    public String toString() {
        for (int row = 0; row < array.length; row++) {
            for (int col = 0; col < array[row].length; col++) {
                System.out.printf("%d", array[row][col]);
            }
            System.out.println();
        }
        return "";
    }

}
