package Amazon;

/**
 * Created by sumitachauhan on 7/19/17.
 */
public class MedianInSortedArray {
    public int findMedian(int[] a, int[] b, int a_start, int a_end, int b_start, int b_end){
        if ((a_end - a_start < 0) || ((b_end - b_start < 0))){
            System.out.println("Invalid Input." );
            return Integer.MAX_VALUE;
        }

        if ((a_end - a_start == 0) || ((b_end - b_start == 0))){
            return (a[0] + b[0])/2;
        }

        if(a_end-a_start==1 && b_end-b_start==1)
        {
            return (Math.max(a[a_start],b[b_start])+Math.min(a[a_end],b[b_end]))/2;
        }

        int m1_index=a_start+a_end/2;
        int m2_index=b_start+b_end/2;

        int median1=a[m1_index];
        int median2=b[m2_index];

        if(median1==median2){
            return median2;
        }

        if(median1<median2){
            a_start=m1_index;
            b_end=m2_index;
        }
        else{
            a_end=m1_index;
            b_start=m2_index;
        }
        return findMedian(a,b,a_start,a_end,b_start,b_end);
    }

    public int findMedianN(int[] a, int[] b){
        int[] c = new int[a.length+b.length];
        int i=0;
        int j=0;
        int k=0;
        while(i<a.length && j<b.length){
            if(a[i]<=b[j]){
                c[k]=a[i];
                i++;
            }
            else{
                c[k]=b[j];
                j++;
            }
            k++;
        }
        while(i<a.length){
            c[k]=a[i];
            i++;
            k++;
        }
        while(j<b.length){
            c[k]=b[j];
            j++;
            k++;
        }
        int len = a.length+b.length;
        if(len%2==0){
            return (c[len/2-1]+c[(len/2)])/2;
        }else return c[len/2];
    }

    public static void main(String[] args) {
        int [] a = {1,2,3,4,5,6,7,8,9};
        int [] b = {6,7,8,9,10};
        MedianInSortedArray obj=new MedianInSortedArray();
        System.out.println(obj.findMedianSortedArrays(a, b,0,8,0,4));
    }

    public double findMedianSortedArrays(int[] a, int[] b, int startIndexA, int endIndexA, int startIndexB, int endIndexB)
    {

        if ((endIndexA - startIndexA < 0) || ((endIndexB - startIndexB < 0)))
        {
            System.out.println("Invalid Input.");
            return Integer.MIN_VALUE;
        }

        if ((endIndexA - startIndexA == 0) && ((endIndexB - startIndexB == 0)))
        {
            return (a[0] + b[0])/2;
        }

        if ((endIndexA - startIndexA == 1) && ((endIndexB - startIndexB == 1)))
        {
            return (1.0*(max(a[startIndexA], b[startIndexB]) + min(a[endIndexA], b[endIndexB])))/2;
        }

        double m1 = findMedian(a, startIndexA, endIndexA);
        double m2 = findMedian(b, startIndexB, endIndexB);

        if (m2 == m1)
        {
            return m2;
        }

        // since m1 <= median <= m2 narrow down search by eliminating elements less than m1 and elements greater than m2
        if (m1 < m2)
        {
            if ((endIndexA - startIndexA) % 2 == 0) // we are looking at odd number of elements
            {
                startIndexA = startIndexA + (endIndexA - startIndexA) / 2;
                endIndexB = startIndexB + (endIndexB - startIndexB) / 2;
            }
            else
            {
                startIndexA = startIndexA + (endIndexA - startIndexA) / 2;
                endIndexB = startIndexB + (endIndexB - startIndexB) / 2 + 1;
            }
        }

        // since m2 <= median <= m1 narrow down search by eliminating elements less than m2 and elements greater than m1
        else // m2 < m1
        {
            if ((endIndexB - startIndexB) % 2 == 0) // we are looking at odd number of elements
            {
                startIndexB = startIndexB + (endIndexB - startIndexB) / 2;
                endIndexA = startIndexA + (endIndexA - startIndexA) / 2;
            }
            else
            {
                startIndexB = startIndexB + (endIndexB - startIndexB) / 2;
                endIndexA = startIndexA + (endIndexA - startIndexA) / 2 + 1;
            }
        }
        return findMedianSortedArrays(a, b, startIndexA, endIndexA, startIndexB, endIndexB);
    }

    private double findMedian(int[] array, int startIndex, int endIndex)
    {
        int indexDiff = (endIndex - startIndex);
        if (indexDiff % 2 == 0) // we are looking at odd number of elements
        {
            return array[startIndex + (indexDiff/2)];
        }
        else
        {
            return 1.0*(array[startIndex + (indexDiff/2)] + array[startIndex + (indexDiff/2) + 1])/2;
        }
    }

    public int max(int a, int b)
    {
        if (a > b) return a;
        return b;
    }

    public int min(int a, int b)
    {
        if (a < b) return a;
        return b;
    }
}
