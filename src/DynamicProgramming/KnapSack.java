package DynamicProgramming;

/**
 * Created by sumitachauhan on 5/21/17.
 * 0/1 Knapsack - either you pick the item or you don't.
 * if you can split the item then there is a greedy solution where you sort the items by value/weight in decreasing order.
 *
 */
public class KnapSack {
    public static void main(String[] args) {
        int tw = 7;
        int[] w= {1,3,4,5};
        int[] v ={1,4,5,7};
        KnapSack obj = new KnapSack();
        System.out.println(obj.maxValue(v, w, tw));
    }

    public int maxValue(int[] value, int[] weight, int totalWeight){
        int[][] allVal = new int[value.length+1][totalWeight+1];

        for(int w=0; w<weight.length; w++){
            for(int v=0; v<=totalWeight; v++){
                //fill the matrix
                if(w==0 || v ==0){
                    allVal[w][v]=0;
                    continue;
                }
                if(v>=weight[w-1]){
                    allVal[w][v]= Math.max(allVal[w-1][v], value[w-1]+allVal[w-1][v-weight[w-1]]);
                }
                else{
                    allVal[w][v]=allVal[w-1][v];
                }
            }
        }
        return allVal[value.length][totalWeight];
    }

}
