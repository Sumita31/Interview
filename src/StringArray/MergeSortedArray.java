package StringArray;

/**
 * Created by sumitachauhan on 3/8/17.
 */
public class MergeSortedArray {

    public void mergeArray1(int[] input1, int noOfElementsInput1, int[] input2, int noOfElementsInput2)
    {
        while(noOfElementsInput1>0 && noOfElementsInput2>0)
        {
            if(input1[noOfElementsInput1-1] >= input2[noOfElementsInput2-1]) {
                input1[noOfElementsInput1 + noOfElementsInput2 - 1] = input1[noOfElementsInput1 - 1];
                noOfElementsInput1--;
            }
            else
            {
                input1[noOfElementsInput1 + noOfElementsInput2 -1] = input2[noOfElementsInput2-1];
                noOfElementsInput2--;
            }
        }
        while(noOfElementsInput2>0)
        {
            input1[noOfElementsInput1 + noOfElementsInput2 -1] = input2[noOfElementsInput2-1];
            noOfElementsInput2--;
        }

        for(int len=0; len < input1.length; len++)
        {
            System.out.print(input1[len] + ",");
        }
    }

    public static void main(String[] args)
    {
        MergeSortedArray obj = new MergeSortedArray();
        int[] A = {7,8,90,0,0,0,0,0,0};
        int[] B = {2,4,10,11};
        obj.mergeArray1(A, 3, B, 4);

    }
}
