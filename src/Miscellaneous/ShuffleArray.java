package Miscellaneous;

import java.util.Random;

public class ShuffleArray {
    public static void main(String args[])
    {
        int[] solutionArray = { 1, 2, 3, 4, 5, 6, 16, 15, 14, 13, 12, 11 };
        shuffleArray(solutionArray);

        //Print elements after shuffling
        for (int i = 0; i < solutionArray.length; i++)
        {
            System.out.print(solutionArray[i] + " ");
        }

    }

    // Implementing Fisher–Yates shuffle
    static void shuffleArray(int[] ar)
    {
        Random rdm = new Random();

        for(int i = ar.length-1; i>0; i--)
        {
            int index = rdm.nextInt(i);
            int temp = ar[index];
            ar[index]=ar[i];
            ar[i] = temp;
        }
//        Random rnd = new Random();
//        for (int i = ar.length - 1; i > 0; i--)
//        {
//            int index = rnd.nextInt(i + 1);
//
//            int a = ar[index];
//            ar[index] = ar[i];
//            ar[i] = a;
//        }
    }

}
