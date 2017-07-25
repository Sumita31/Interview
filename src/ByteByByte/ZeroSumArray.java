package ByteByByte;

import java.util.*;

/**
 * Created by sumitachauhan on 7/21/17.
 */
public class ZeroSumArray {

    public int[] zeroSumBF(int[] arr){
        for(int i=0; i<arr.length-1; i++){
            int sum=arr[i];
            for(int j=i+1; j<arr.length; j++){
                sum = sum + arr[j];
                if(sum==0){
                    int[] res = new int[j+1-i];
                    for(int k=0; k<res.length; k++){
                        res[k]=arr[i];
                        i++;
                    }
                    return res;
                }
            }
        }
        return null;
    }
    public int[] zeroSumBYB(int[] arr) {
        HashMap<Integer, Integer> sums = new HashMap<>();
        int sum = 0;
        for (int i = 0; i <= arr.length; i++) {
            Integer oldIndex = sums.get(sum);
            if (oldIndex == null && i == arr.length) {
                return null;
            } else if (oldIndex == null) {
                sums.put(sum, i);
                sum += arr[i];
            } else {
                return Arrays.copyOfRange(arr, oldIndex, i);
            }
        }

        return null;
    }

    public static void main(String[] args) {
        ZeroSumArray obj = new ZeroSumArray();
        int[] arr={11,20,-5,2,1,2};
        int[] res = obj.zeroSumBF(arr);
        for(int i: res){
            System.out.print(i+", ");
        }
        System.out.println();
        res = obj.zeroSumBYB(arr);
        for(int i: res){
            System.out.print(i+", ");
        }
    }
}
