package Miscellaneous;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sumitachauhan on 2/23/17.
 */
class FindDuplicate
{
    void printRepeating(int[] arr, List<Integer> res)
    {
        int size = arr.length;
        int i;
        System.out.println("The repeating elements are : ");

        for (i = 0; i < size; i++)
        {
//            System.out.print(arr[Math.abs(arr[i])]+", ");
            if (arr[Math.abs(arr[i])] >= 0)
                arr[Math.abs(arr[i])] = -arr[Math.abs(arr[i])];
            else
                //System.out.print(Math.abs(arr[i]) + " ");
                res.add(Math.abs(arr[i]));
        }
    }

    /* Driver program to test the above function */
    public static void main(String[] args)
    {
        FindDuplicate duplicate = new FindDuplicate();
        int arr[] = {5, 2, 4, 5, 2, 3, 1, 3, 1};
        List<Integer> res=new ArrayList<>();
        duplicate.printRepeating(arr,res);
        for(int i:res){
            System.out.print(i+", ");
        }
    }
}