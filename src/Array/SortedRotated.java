package Array;

public class SortedRotated {
    public boolean pivotedSearch(int[] input, int start, int end, int key){
        if(input==null || input.length==0)
        return false;

        int len=input.length;
        int pivot=len/2;
        if(input[pivot]==key)
            return true;

        if(key>input[start]){
                return pivotedSearch(input, start, pivot - 1, key);
        }
        else return pivotedSearch(input,pivot+1,end,key);
    }
    public static void main(String args[])
    {
        // Let us search 3 in below array
        int arr1[] = {5, 6, 7, 8, 9, 10, 1, 2, 3};
        int n = arr1.length;
        int key = 3;
        SortedRotated obj = new SortedRotated();
        System.out.println(obj.pivotedSearch(arr1, 0,n, key));
    }
}
