package Miscellaneous;

import StringArray.ReverseString;
import StringArray.StringPermutation;

import java.util.*;
import java.lang.Math;

public class RandomEx {
    public static void main(String[] args) {
        Random ran = new Random();
        int[] arr = {1,9,3,0,5};
        Arrays.sort(arr);
        for(int i=0; i< arr.length; i++){
            System.out.print(arr[i]);
        }
        System.out.println();
        for(int i=0; i< arr.length; i++){
            int index = ran.nextInt(4);
            int temp = arr[index];
            arr[index]=arr[i];
            arr[i]=temp;
        }
        for(int i=0; i< arr.length; i++){
            System.out.print(arr[i]);
        }
        System.out.println();
//        for(int i=arr.length-1; i>=0; i--){
//            int index = (int)Math.floor(Math.random()*(i-1));
//            System.out.println(index);
//            System.out.println();
//            int temp = arr[index];
//            arr[index]=arr[i];
//            arr[i]=temp;
//        }
        System.out.println();
        String input = "noon";
        String output = new StringBuilder(input).reverse().toString();
        if(output.equals(input))
            System.out.println("palindrome");
        else System.out.println("not palindrome");

        System.out.println();
        System.out.println(new StringBuilder(input).append(output).toString());

    }
}
