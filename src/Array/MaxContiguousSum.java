package Array;

/**
 * Created by sumitachauhan on 6/30/17.
 */
public class MaxContiguousSum {
    public int max(int[] input){
        if(input==null)
            throw new IllegalArgumentException("array is null");
        int max=input[0];
        int curmax=input[0];
        for(int i=1; i<input.length;i++){
            curmax=Math.max(input[i], curmax+input[i]);
            max=Math.max(max, curmax);
        }
        return max;
    }

    public static void main(String[] args) {
        MaxContiguousSum obj = new MaxContiguousSum();
        int[] input={-2, -3, 4, -1, -2, 1, 5, -3};
        System.out.println(obj.max(input));
    }
}
