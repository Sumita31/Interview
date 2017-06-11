package Miscellaneous;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {

        int n = 4;
        int m = 3;
        int coins[] = new int[m];
        int count=0;
        for(int coins_i=0; coins_i < m; coins_i++){
            count = count+1;
            coins[coins_i] = count;
        }
        System.out.println(makeChange(coins, n));
    }

    public static long makeChange(int[] coins, int money)
    {
        int noOfRows = coins.length;
        int noOfCol = money;
        int[][] result = new int[noOfRows][noOfCol+1];
        Arrays.sort(coins);
        for(int i=0; i<noOfRows; i++){
            result[i][0]=0;
        }
        for(int j=1; j<=noOfCol; j++){
            if(j%coins[0]==0){
                result[0][j] = 1;
            }
            else result[0][j] = 0;
        }

        for(int i=1; i<noOfRows; i++){
            for(int j=1; j<=noOfCol; j++){
                if(coins[i]>j){
                    result[i][j] = result[i-1][j];
                }
                else result[i][j] = result[i-1][j] + result[i-coins[i]][j];
            }
        }
        System.out.println(result[noOfRows][noOfCol+1]);
        return (long)result[noOfRows][noOfCol+1];
    }
}
