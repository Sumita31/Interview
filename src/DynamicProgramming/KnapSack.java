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
        int[] w= {5,4,3,1};
        int[] v ={7,5,4,1};
        KnapSack obj = new KnapSack();
        System.out.println(obj.maxValue(v, w, tw));
        System.out.println(obj.maxValueKS(v,w, tw));
    }

    public int maxValueKS(int[] value, int[] weight, int totalWeight){
        int K[][] = new int[value.length+1][totalWeight+1];
        for(int i=0; i <= value.length; i++){
            for(int j=0; j <= totalWeight; j++){
                if(i == 0 || j == 0){
                    K[i][j] = 0;
                    continue;
                }
                if(j - weight[i-1] >= 0){
                    K[i][j] = Math.max(K[i-1][j], K[i-1][j-weight[i-1]] + value[i-1]);
                }else{
                    K[i][j] = K[i-1][j];
                }
            }
        }
        return K[value.length][totalWeight];
    }

    public int maxValue(int[] value, int[] weight, int totalWeight){
        //not producing correct result
        int[][] allVal = new int[value.length+1][totalWeight+1];

        for(int w=0; w<weight.length; w++){
            for(int v=0; v<=totalWeight; v++){
                //fill the matrix
                if(w==0 || v ==0){
                    allVal[w][v]=0;
                    continue;
                }
                if(v>=weight[w-1]){
                    allVal[w][v]= Math.max(allVal[w-1][v-weight[w-1]] + value[w-1], allVal[w-1][v]);
                }
                else{
                    allVal[w][v]=allVal[w-1][v];
                }
            }
        }
        return allVal[value.length][totalWeight];
    }

}
