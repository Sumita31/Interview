package ByteByByte;

/**
 * Created by sumitachauhan on 7/20/17.
 */
public class SearchMatrix {
    public boolean contains(int[][] arr, int ele){
        if(arr.length==0)
            return false;
        int row=0;
        int col=arr[0].length-1;
        while(row<arr.length && col>=0){
            if(arr[row][col]==ele) {
                return true;
            }
            if(arr[row][col]<ele) row++;
            else col--;
        }
        return false;
    }
    private boolean binarySearch(int[] arr, int ele, int start, int end){
        if(end>arr.length-1) return false;
        if(start<end){
            int pivot=end-start/2;
            if(arr[pivot]==ele) {
                return true;
            }
            else if(arr[pivot]>ele)
                return binarySearch(arr, ele, start, pivot-1);
            else return binarySearch(arr, ele, pivot+1, end);
        }
        return false;
    }
    public boolean containsUsingBS(int[][] arr, int ele){
        if(arr.length==0)
        return false;
        for(int i=0; i<arr.length; i++){
            if(binarySearch(arr[i], ele,0,arr[i].length-1)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] array ={{1,  2,  3,  4},
                {5,  6,  7,  8},
                {9, 10, 11, 12},
                {13, 14, 15, 16},
                {17, 18, 19, 20}};
        SearchMatrix obj = new SearchMatrix();
        System.out.println(obj.contains(array, 0));
        System.out.println(obj.containsUsingBS(array,0));
    }
}
