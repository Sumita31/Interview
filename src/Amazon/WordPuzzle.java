package Amazon;

/*
Find a word in a matrix
 */

public class WordPuzzle {
    private final int[] x={0,0,0,1,1,1,-1,-1,-1};
    private final int[] y={1,-1,0,-1,1,0,1,-1,0};

    public boolean findWord(char[][] gameBoard, String word, int row, int col){
        if(gameBoard[row][col]!=word.charAt(0))
            return false;
        for(int dir=0; dir<8; dir++){
            int rd=row+x[dir];
            int cd=col+y[dir];
            int k;
            for(k=1; k<word.length(); k++){
                if (rd >= gameBoard.length || rd < 0 || cd >= gameBoard[0].length || cd < 0)
                    break;
                if (gameBoard[rd][cd] != word.charAt(k))
                    break;
                rd=rd+x[dir];
                cd=cd+y[dir];
            }
            if(k==word.length())
                return true;
        }
        return false;
    }

    private boolean isValid(int rows, int cols, int row, int col){
        return row<rows && row>=0 && col<cols && col>=0;
    }

    public void find(char[][] gameBoard, String word){
        boolean isFound=false;
        for(int i=0; i<gameBoard.length;i++){
            for(int j=0; j<gameBoard[0].length; j++){
                if(findWord(gameBoard, word, i,j)){
                    System.out.println("word found at:"+i+", "+j);
                    isFound=true;
                    break;
                }
            }
        }
        if(!isFound){
            System.out.println("word not found");
        }
    }

    public static void main(String[] args) {
        char[][] grid = {
                {'s','u','m','i','t'},
                {'s','m','m','i','t'},
                {'s','s','m','i','t'},
                {'s','u','m','i','t'},
                {'s','t','m','i','t'},
                {'s','t','m','i','t'},
        };
        String word="mmit";
        WordPuzzle obj=new WordPuzzle();
        obj.find(grid,word);
        System.out.println(1<<8);
    }
}
