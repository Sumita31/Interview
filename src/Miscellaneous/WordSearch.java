package Miscellaneous;

public class WordSearch {
    int[] x = { -1, -1, -1, 0, 0, 1, 1, 1 };
    int[] y = { -1, 0, 1, -1, 1, -1, 0, 1 };


    boolean search2D(char[][] grid, int row, int col, String word)
    {
        int R = grid.length;
        int C = grid[0].length;

        if (grid[row][col] != word.charAt(0))
            return false;

        int len = word.length();

        for (int dir = 0; dir < 8; dir++)
        {
            int k, rd = row + x[dir], cd = col + y[dir];
            //no need to check the first word, we already did it
            for (k = 1; k < len; k++)
            {
                //check out of bound
                if (rd >= R || rd < 0 || cd >= C || cd < 0)
                    break;

                //if at any point letter of the word doesn't match the grid value
                if (grid[rd][cd] != word.charAt(k))
                    break;

                rd += x[dir];
                cd += y[dir];
            }

            if (k == len)
                return true;
        }
        return false;
    }


    void patternSearch(char[][] grid, String word)
    {
        int R = grid.length;
        int C = grid[0].length;

        for (int row = 0; row < R; row++)
            for (int col = 0; col < C; col++)
                //search word starting from every point in the grid
                if (search2D(grid, row, col, word))
                    System.out.println("patter found at row:" + row+", col:"+col);
    }


    public static void main(String[] args) {
        char[][] grid = {{'G','E','E','K','S','F','O','R','G','E','E','K','S'},
                {'G','I','E','K','S','F','O','R','G','E','E','K','S'},
                {'G','K','E','K','S','F','O','R','G','E','E','K','S'},
                {'G','E','S','K','S','F','O','R','G','E','E','K','S'},
                {'T','E','E','K','S','F','H','R','G','E','E','K','S'},
                {'G','E','E','K','S','F','O','R','G','E','E','K','S'}
        };

        WordSearch obj = new WordSearch();
        obj.patternSearch(grid, "HRGE");


    }
}
