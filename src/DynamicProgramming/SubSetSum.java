package DynamicProgramming;



public class SubSetSum {
    public boolean subsetSum(int[] numbers, int total){
        boolean[][] res = new boolean[numbers.length+1][total+1];

        for(int i=0; i<=numbers.length; i++){
            res[i][0]=true;
        }
        for(int i=1; i<=numbers.length; i++){
            for(int j=1; j<=total; j++){
                if(j - numbers[i - 1] >= 0){
                    res[i][j]=res[i-1][j] || res[i-1][j-numbers[i-1]];
                }
                else res[i][j]=res[i-1][j];
            }
        }
        return res[numbers.length][total];
    }

    public static void main(String[] args) {
        int total =13;
        int[] numbers={8,2,3,10,7};
        SubSetSum obj = new SubSetSum();
        System.out.println(obj.findSubset(numbers, total));
    }

    public boolean findSubset(int[] values, int sum){
        boolean[][] subset = new boolean[values.length+1][sum+1];
        for(int i=0; i<values.length+1; i++){
            subset[i][0]=true;
        }
        for(int i=1; i<values.length+1; i++){
            for(int j=1; j<sum+1; j++){
                if(j-values[i-1]>=0){
                    subset[i][j]=subset[i-1][j-values[i-1]] || subset[i-1][j];

                }
                else{
                    subset[i][j]=subset[i-1][j];
                }
            }
        }
        return subset[values.length][sum];
    }
}
