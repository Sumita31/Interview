package StringArray;


public class PrintTopRow {

    public void printRepeatTopRow(int arr[][]) {
        int[] topRow = arr[0];
        int repeat = topRow.length;

        for (int column = 0; column < topRow.length; column++) {
            int printInt = topRow[column];
            for (int i = 0; i < repeat; i++) {
                System.out.print(printInt + ",");

            }
            System.out.println();
            for (int nextRows = 1; nextRows < arr.length; nextRows++) {
                for (int nextCol = 0; nextCol < arr[nextRows].length; nextCol++) {
                    System.out.print(arr[nextRows][nextCol] + ",");

                }
                System.out.println();
            }
            System.out.println("--------");
        }
    }

    public void printMatrixWithTop(int[][] input) {
        int[] firstRow = input[0];
        int repeat = firstRow.length;
        for (int col = 0; col < input[0].length; col++)
        {
            int printValue = firstRow[col];

            for (int i = 0; i < repeat; i++) {
                System.out.print(printValue + ",");
            }

            System.out.println();

            for (int nextCol = 0; nextCol < input[0].length; nextCol++)
            {
                System.out.print(input[1][nextCol] + ",");
            }
            System.out.println();
            System.out.println("-----");
        }
    }

    public static void main(String[] args) {
        new PrintTopRow().printMatrixWithTop(new int[][]{{1, 2}, {3, 4}});
    }
}
