package HackerRank.WeekOfCode32;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class FightTheMonster {
    static int getMaxMonsters(int n, int hit, int t, int[] h){
        // Complete this function
        int count=0;
        Arrays.sort(h);
        for(int i=0; i<n; i++){
            while(h[i] > 0 && t > 0){
                h[i]=h[i]-hit;
                t=t-1;
            }
            if(h[i]<=0){
                count=count+1;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int hit = in.nextInt();
        int t = in.nextInt();
        int[] h = new int[n];
        for(int h_i=0; h_i < n; h_i++){
            h[h_i] = in.nextInt();
        }
        int result = getMaxMonsters(n, hit, t, h);
        System.out.println(result);
    }
}
