package Miscellaneous;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by sumitachauhan on 2/16/17.
 */
public class TwoSum {

    public static void main(String[] args) {
        TwoSum obj = new TwoSum();
        int[] ar = {23,4,6,7,8,10};
        int[] res = obj.twoSum2(ar, 270);
        System.out.println(ar[res[0]] + " " +ar[res[1]]);
    }

    public int[] twoSum(int[] numbers, int target) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        int[] result = new int[2];

        for (int i = 0; i < numbers.length; i++) {
            if (map.containsKey(numbers[i])) {
                int index = map.get(numbers[i]);
                result[0] = index ;
                result[1] = i;
                break;
            } else {
                map.put(target - numbers[i], i);
            }
        }

        return result;
    }

    public int[] twoSum1(int[] arr, int k)
    {
        if(arr==null || arr.length<2)
            return new int[]{0,0};

        Map<Integer, Integer> map = new HashMap<>();

        for(int i=0; i<arr.length; i++)
        {
            if(map.containsKey(arr[i]))
                return new int[]{map.get(arr[i]), i};
            else map.put(k-arr[i],i);
        }
        return new int[]{0,0};

    }

    public int[] twoSum2(int[] arr, int target)
    {
        if(arr.length<2)
            return new int[] {0,0};

        int i=0;
        int j=arr.length-1;

        Arrays.sort(arr);

        while(i<j)
        {
            if(arr[i]+arr[j] == target) {
                return new int[]{i, j};
            }
            else if(arr[i]+arr[j]> target){
                j--;
            }
            else if(arr[i]+arr[j] < target){
                i++;
            }

        }
        return new int[]{0,0};
    }



}
