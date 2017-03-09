package StringArray;

/**
 * Created by sumitachauhan on 3/8/17.
 */
public class RotateArray {
    //Rotate input = [2,4,1,7,1,2,6] position = 3 output =[7,1,2,6,2,4,1]

    public int[] rotate1(int[] input, int position)
    {
        if(input==null || position > input.length || position < 0 || input.length==0)
            throw new IllegalArgumentException("Argument not valid");

        int[] afterRotation = new int[input.length];
        int location = input.length -1;
        int i;
        for(i=0; i<=location-position; i++)
        {
            afterRotation[i] = input[position + i];
        }

        int j=0;
        for(int z=i; z<input.length; z++)
        {
            afterRotation[z] = input[j];
            j++;
        }

        return afterRotation;
    }

    public int[] rotate2(int[] input, int position)
    {
        if(input==null || position > input.length || position < 0 || input.length==0)
            throw new IllegalArgumentException("Argument not valid");
        rotateHelper(input, 0, position-1);
        rotateHelper(input, position, input.length-1);
        rotateHelper(input, 0, input.length-1);
        return input;
    }

    public void rotateHelper(int[] input, int start, int end)
    {
        if(input == null || input.length ==1)
            return;
        while(start < end)
        {
            int temp = input[start];
            input[start] = input[end];
            input[end] = temp;
            start++;
            end--;
        }
    }

    public static void main(String[] args)
    {
        RotateArray obj = new RotateArray();
        int[] input = {2,4,1,7,1,2,6};
        int[] result = obj.rotate2(input,2);
        for(int i=0; i<result.length; i++)
        {
            System.out.print(result[i] +",");
        }
    }
}
