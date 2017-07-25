package Amazon;

/**
 * Created by sumitachauhan on 7/24/17.
 */
public class Average {
    public double findAverage(int[] arr){
        if(arr==null || arr.length<1)
            throw new IllegalArgumentException("array is null or empty");
        double sum=0.0;

        for(int i=0; i<arr.length; i++){
            sum=sum+arr[i];
        }
        return sum/arr.length;
    }

    public static void main(String[] args) {
        int[] ar={1};
        Average obj = new Average();
        System.out.println(obj.findAverage(ar));
    }
}
