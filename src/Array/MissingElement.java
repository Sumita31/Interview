package Array;

/**
 * Created by sumitachauhan on 6/30/17.
 */
public class MissingElement {
    public int finMissingUsinSum(int[] input){
        if(input==null || input.length==0)
            throw new IllegalArgumentException("Array is null");
        int len=input.length+1;
        int sum=(len*(len+1))/2;
        int arraySum=0;
        for(int i=0; i<input.length;i++){
            arraySum=arraySum+input[i];
        }
        System.out.println(sum);
        System.out.println(arraySum);
        return sum-arraySum;
    }
    public int finMissingXoR(int[] input){
        if(input==null || input.length==0)
            throw new IllegalArgumentException("Array is null");
        int len=input.length;
        int totalXoR=0;
        int inputXoR=0;
        for(int i=1; i<=len+1; i++){
            totalXoR=totalXoR^i;
        }
        for(int i=0; i<len; i++){
            inputXoR=inputXoR^input[i];
        }
        return totalXoR^inputXoR;
    }
    public static void main(String args[])
    {
        MissingElement obj=new MissingElement();
        int a[] = {1,2,4,5,6};
        //int miss = obj.finMissingXoR(a);
        int miss = obj.finMissingUsinSum(a);
        System.out.println(miss);
    }
}
