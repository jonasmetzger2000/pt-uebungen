package arrays;

/**
 * Beinhaltet eine Matrix. Beim Initialisieren kann die Anzahl and Spalten/Reihene gegebene werden.
 * Bietet gängige Funktionen der Matrizzen, wie z.B Addition, Subtraktion etc.
 */
public class Matrix {

    private int[][] array;
    private int rows;
    private int cols;

    /**
     * Initialisiert eine neue Matrix Instanz mit gegebenen Spalte/Reihen
     * @param rows Spaltenanzahl der Matrix
     * @param cols Zeilenanzahl der Matrix
     */
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

    /**
     * Gibt die Spaltenanzahl der Matrix wieder
     * @return Spaltenanzahl
     */
    public int rows(){
        return rows;
    }

    /**
     * Gibt die Zeilenanzahl der Matrix wieder
     * @return Zeilenanzahl
     */
    public int cols(){
        return cols;
    }

    /**
     * Kopiert ein gegebenes 2 dimensionales Array in die Matrix. Das Array selber darf dabei nicht null sein.
     * Wenn das array zu groß ist, werden die Elemente außerhalb ignoriert. Das Array darf auch kleiner sein,
     * hierbei werden die Elemente die nicht gegeben sind ignoriert.
     * @param ary2D zu kopierendes Array
     * @return wenn kopiervorgang erfolgreich true, ansonsten false
     */
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

    /**
     * Erstellt eine Tiefe Kopie der atomaren Integer Werte der Matrix.
     * @return das erstellte 2-dimensionale Array
     */
    public int[][] toArray(){
        int[][] array = new int[rows][cols];
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                array[row][col] = this.array[row][col];
            }
        }
        return array;
    }

    /**
     * Erstellt eine tiefe Kopie der Matrix Instanz. Benutzt intern ({{@link #toArray()}}) und ({{@link #copyFrom(int[][])} ()}})
     * @return die neu erstellte Matrix Instanz
     */
    public Matrix deepCopy(){
        Matrix newMatrix = new Matrix(rows, cols);
        newMatrix.copyFrom(toArray());
        return newMatrix;
    }

    /**
     * Setzt eine bestimmte Koordinate in der Matrix auf einen neuen Wert.
     * @param row zu ändernde Reihe
     * @param col zu änderende Zeile
     * @param value zu setzender Wert
     */
    public void put(int row, int col, int value){
        array[row][col] = value;
    }

    /**
     * Gibt einen speziellen Wert aus der Matrix aus
     * @param row zu abfragende Reihe
     * @param col zu abfragende Zeile
     * @return der exake wert an pos row/col
     */
    public int get(int row, int col){
        return array[row][col];
    }

    /**
     * Addiert eine gegebene Matrix auf die existierende, dabei bleibt die bestehende Klasse immutable, da eine neue
     * Instanz erzeugt wird. Jeder atomare Wert wird mit der gegenüberlegenden Matrix addiert
     * @param other zu addierende Matrix
     * @return neu erzeugte Matrix Instanz mit summierten Werten
     */
    public Matrix add(Matrix other){
        Matrix copy = deepCopy();
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                copy.put(row, col, copy.get(row, col) + other.get(row, col));
            }
        }
        return copy;
    }

    /**
     * Faktorisiert eine gegebene Matrix auf die existierende, dabei bleibt die bestehende Klasse immutable, da eine neue
     * Instanz erzeugt wird. Jeder atomare Wert wird mit der gegenüberlegenden Matrix um ein faktor faktorisiert.
     * @param value Faktor
     * @return neu erzeugte Matrix Instanz mit summierten Werten
     */
    public Matrix mult(int value){
        Matrix copy = deepCopy();
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                copy.put(row, col, copy.get(row, col) * value);
            }
        }
        return copy;
    }

    /**
     * Addiert eine gegebene Matrix auf die existierende, dabei bleibt die bestehende Klasse immutable, da eine neue
     * Instanz erzeugt wird. Jeder atomare Wert wird mit der gegenüberlegenden Matrix addiert
     * @param other zu addierende Matrix
     * @return neu erzeugte Matrix Instanz mit summierten Werten
     */
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
                int current = String.valueOf(get(row, col)).length()+1;
                if (current > max)
                    max = current;
            }
        }
        return max;
    }

    /**
     * Gibt eine visuelle Reprensentation der Matrix aus. Die atomaren Werte werden gruppiert ausgegeben.
     * Vorher wird der maximale Stellenanzahl berechnet und der Abstand der einzelnen Werte somit garantiert.
     * @return visuelle Reprensentation in Form eines Strings
     */
    @Override
    public String toString() {
        for (int row = 0; row < array.length; row++) {
            for (int col = 0; col < array[row].length; col++) {
                System.out.printf("%" + maxElemSpace() + "d", array[row][col]);
            }
            System.out.println();
        }
        return "";
    }

}
