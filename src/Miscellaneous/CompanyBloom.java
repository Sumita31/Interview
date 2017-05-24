package Miscellaneous;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

/**
 * Created by sumitachauhan on 5/4/17.
 */
public class CompanyBloom {

    public int productOfThreeWithSort(int[] arr){
        if(arr.length==0 || arr==null)
            return 0;
        if(arr.length == 2)
            return arr[0]*arr[1];
        int maxproduct;
        int len = arr.length;
        Arrays.sort(arr);

        maxproduct = arr[len-1]*arr[len-2]*arr[len-3];
        maxproduct = Math.max(maxproduct, arr[len-1]*arr[0]*arr[1]);

        return maxproduct;
    }

    public static void CompareDates(Date d1,Date d2)
    {
        try{
//            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//            Date date1 = sdf.parse(d1);
//            Date date2 = sdf.parse(d2);
//
//            System.out.println("Date1: "+sdf.format(date1));
//            System.out.println("Date2: "+sdf.format(date2));
//            System.out.println();

            if(d1.after(d2)){
                System.out.println("Date1 is after Date2");
            }

            if(d1.before(d2)){
                System.out.println("Date1 is before Date2");
            }

            if(d1.equals(d2)){
                System.out.println("Date1 is equal Date2");
            }

            System.out.println();
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
    }


    public double power(double x, double n){
        if(x==0) {
            return x;
        }
        if(n==0) {
            return 1;
        }
        return Math.exp(n*Math.log(x));
    }

    public double pow(int x, int n){
        if(x==0) {
            return (double)x;
        }
        if(n==0) {
            return (double)1;
        }
        double pow=1;
        int count=n;
        if(n<0)
            count=n*-1;
        for(int i=0; i<count; i++){
            pow = pow * (double)x;
        }
        if(n<0)
            return 1/pow;
        else return pow ;

    }

    public static void main(String[] args) {
        CompanyBloom obj = new CompanyBloom();
//        System.out.println(obj.power(2, 0));
        int[] arr = {-100,7,5,9,-200,4,10};
        //System.out.println(obj.productOfThreeWithSort(arr));
        Date d1= new Date(2017,4,14);
        Date d2= new Date(2017,8,20);
        obj.CompareDates(d1,d2);
    }
}
