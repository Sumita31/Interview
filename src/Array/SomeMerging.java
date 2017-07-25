package Array;

import java.util.Arrays;

/**
 * Created by sumitachauhan on 6/30/17.
 */
public class SomeMerging {
    static int arr1[] = new int[]{1, 5, 9, 10, 15, 20};
    static int arr2[] = new int[]{2, 3, 8, 13};

    public static void merge(int[] first, int[] second){
        int i=0;
        int j=0;
        while(i<first.length && j<second.length){
            if(first[i]<second[j]){
                i++;
            }
            else if(first[i]>second[j]){
                int temp =first[first.length-1];
                for(int k=first.length-1; k>i;k--){
                    first[k]=first[k-1];
                }
                first[i]=second[j];
                second[j]=temp;
                i++;
                j++;
            }
        }
        Arrays.sort(second);
    }
    public static void main(String[] args)
    {
        merge(arr1,arr2);
        System.out.print("After Merging \nFirst Array: ");
        System.out.println(Arrays.toString(arr1));
        System.out.print("Second Array:  ");
        System.out.println(Arrays.toString(arr2));
    }
}
