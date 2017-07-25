package ByteByByte;

/**
 * Created by sumitachauhan on 7/21/17.
 */
public class BiggestSquareMatrix {
    public int squareMatrix(int[][] arr){
        int x= arr.length;
        if(x==0) return 0;
        int y=arr[0].length;
        if(y==0) return 0;
        int max=0;
        int[][] sizes=new int[x][y];
        for(int i=0; i<x; i++){
            for(int j=0; j<y; j++){
                if(i==0 || j==0){
                    sizes[i][j]=arr[i][j];
                }
                else if(arr[i][j]==1){
                    sizes[i][j]=Math.min(Math.min(sizes[i][j-1], sizes[i-1][j]), sizes[i-1][j-1])+1;
                }
                max=Math.max(sizes[i][j],max);
            }
        }
        return max;
    }

    public static void main(String[] args) {
        BiggestSquareMatrix obj = new BiggestSquareMatrix();
        int[][] ar={
                {1,1,1,1,0},
                {1,1,1,1,0},
                {1,1,1,1,0},
                {1,1,0,1,0},
                {1,1,0,1,1},
                {1,1,0,1,1},
                {1,1,0,1,1},
                {1,1,1,1,1}
        };
        System.out.println(obj.squareMatrix(ar));
    }
}
