package Miscellaneous;


import java.util.Arrays;

public class TriangularMatrix {
    //private final int[] mat;

//    public TriangularMatrix(int size) {
//        mat = new int[sumFormula(size)];
//    }
    public TriangularMatrix(){;}

//    public int set(int row, int column, int value) {
//        validateArguments(row, column);
//        int listIndex = getListIndex(row, column);
//        int oldValue = mat[listIndex];
//        mat[listIndex] = value;
//
//        return oldValue;
//    }
    public void printMatrix(){

    }

//    public int get(int row, int column) {
//        validateArguments(row, column);
//
//        return mat[getListIndex(row, column)];
//    }

    private void validateArguments(int row, int column) {
        if (row > column) {
            throw new IllegalArgumentException("Row (" + row + " given) has to be smaller or equal than column (" + column + " given)!");
        }
    }

    private int getListIndex(int row, int column) {
        return sumFormula(row) - 1 + row;
    }

    private int sumFormula(int i) {
        return (i*i + i) / 2;
    }

    public int[][] arraytriangle(int lines){

        int[][] tri = new int[lines][];
        int c = 1; // incremented number to use as filler
        for (int i = 0; i < lines; i++){
            tri[i] = new int[i+1]; // defines number of columns
            for (int j = 0; j <= i; j++){

                tri[i][j] = c;
                System.out.print(c + " ");
                c++; // increment counter
            }
            System.out.println(); // making new line
        }
        System.out.println(Arrays.deepToString(tri));
        return tri;
    }

    public static void main(String[] args) {
        TriangularMatrix obj = new TriangularMatrix();
        obj.arraytriangle(3);
    }

}
