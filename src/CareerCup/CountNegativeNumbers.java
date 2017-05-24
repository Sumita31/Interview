package CareerCup;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by sumitachauhan on 3/29/17.
 */
public class CountNegativeNumbers {
    public static void main(String[] args) {
        int[][] arr = {
                {-4, -3, -1, 0},
                {-3, -2, 0, 4},
                {-1, 0, 3, 4}
        };
        int count=0, j=arr[0].length-1;
        for(int i=0; i<arr.length; i++){
            System.out.println(j);
            while(arr[i][j] >= 0){
                j=j-1;
            }
            count=count+j+1;
        }
        System.out.println(count);
    }
}
