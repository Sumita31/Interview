package Amazon;

/**
 * Created by sumitachauhan on 7/24/17.
 */
public class OddNumber {
    public int finOdd(int[] arr, int size){
        int num=0;
        for(int i=0; i<size; i++){
            num=num^arr[i];
        }
        return num;
    }

    public static void main(String[] args) {
        int[] ar={8,6,4,8,8,6,6,6,3,3,8};
        OddNumber obj = new OddNumber();
        System.out.println(obj.finOdd(ar, ar.length));
    }
}
