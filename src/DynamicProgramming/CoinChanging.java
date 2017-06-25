package DynamicProgramming;

import com.sun.org.apache.regexp.internal.RE;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sumitachauhan on 6/24/17.
 */
public class CoinChanging {
    public Result minimumCoins(int[] coins, int total){
        int[] minCoins = new int[total+1];
        int[] coinVlue=new int[total+1];
        for(int j=1; j<=total; j++){
            minCoins[j]=Integer.MAX_VALUE-1;
            coinVlue[j]=-1;
        }
        for(int i=0; i<coins.length; i++){
            for(int j=1; j<=total; j++){
               if(j >= coins[i]){
                   if(minCoins[j] > 1+ minCoins[j-coins[i]]) {
                       coinVlue[j] = i;
                       minCoins[j] = 1+ minCoins[j-coins[i]];
                   }

               }
            }
        }
        ArrayList<Integer> res = new ArrayList<>();
        if(minCoins[total]<Integer.MAX_VALUE-1) {
            int k=total;
            while(k>0){
                res.add(coinVlue[k]);
                k=k-coins[coinVlue[k]];
            }
        }
        return new Result(minCoins[total], res);
    }

    public static void main(String[] args) {
        int[] coins = {3,2,4};
        int total=6;
        CoinChanging obj = new CoinChanging();
        Result res = obj.minimumCoins(coins, total);
        System.out.println(res.val);
        for(int i:res.list){
            System.out.println(coins[i]);
        }

    }

    private class Result{
        int val;
        List<Integer> list;
        public Result(int val, ArrayList<Integer> list){
            this.val=val;
            this.list=list;
        }
    }
}
