package Array;

/**
 * Created by sumitachauhan on 7/3/17.
 */
public class BinarySearch {
    public boolean findElement(int[] ar, int val, int start, int end){
        if(end > ar.length-1)
            throw new IllegalArgumentException("Array length is shorter than the end point");
        if(end>=start) {
            int pivot = end-start / 2;
            if(ar[pivot]==val)
                return true;
            else if(ar[pivot]>val)
                return findElement(ar, val, start, pivot-1);
            else return findElement(ar, val, pivot+1, end);
        }
        return false;
    }

    public static void main(String[] args) {
        BinarySearch obj = new BinarySearch();
        int[] ar = {1,2,3,4,5};
        int end = ar.length-1;
        System.out.println(obj.findElement(ar, 0, 0, end));
    }
}
