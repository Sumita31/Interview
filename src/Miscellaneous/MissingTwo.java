package Miscellaneous;

/**
 * Created by sumitachauhan on 6/24/17.
 */
public class MissingTwo {
    public int[] twoMissing(int[] ar){
        int size=ar.length+2;
        int totalSum = size*(size+1)/2;
        int arrSum=0;
        for(int i=0; i<ar.length; i++){
            arrSum+=ar[i];
        }
        int pivot = (totalSum-arrSum)/2;
        int totalLeftXor=0;
        int totalRightXor=0;
        int arrleftXor=0;
        int arrrightXor=0;
        for(int i=1; i<=pivot; i++){
            totalLeftXor^=i;
        }
        for(int i=pivot+1; i<=size; i++){
            totalRightXor^=i;
        }
        for(int i:ar){
            if(i<=pivot)
                arrleftXor^=i;
            else arrrightXor^=i;
        }
        return new int[]{totalLeftXor^arrleftXor, totalRightXor^arrrightXor};
    }

    public static void main(String[] args) {
        int ar[] ={1,2,3,5,7};
        MissingTwo obj = new MissingTwo();
        int[] res=obj.twoMissing(ar);
        for(int i:res){
            System.out.println(i);
        }
    }
}
