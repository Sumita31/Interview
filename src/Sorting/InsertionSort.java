package Sorting;

/**
 * O(n^2)
 * Better than Selection sort and bubble sort
 */
public class InsertionSort {
    public static void main(String[] args) {
        int[] arr = {7,2,8, 11, 0, 4,1,5,3, 99, 3};
        InsertionSort obj = new InsertionSort();
        int[] res = obj.sort(arr);

        for(int z=0; z<res.length; z++){
            System.out.print(res[z]+", ");
        }
    }
    public int[] sort(int[] arr){
        int n=arr.length;
        for(int k=1; k<n; k++){
            for(int i=k; i>0; i--){
                if(arr[i]<arr[i-1]){
                    int temp=arr[i];
                    arr[i]=arr[i-1];
                    arr[i-1]=temp;
                }
            }
        }
        return arr;
    }
}
