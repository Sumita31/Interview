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
        int[] numbers={2,3,7,8,10};
        SubSetSum obj = new SubSetSum();
        System.out.println(obj.subsetSum(numbers, total));
    }
}
