package StringArray;

import java.io.BufferedReader;
import java.io.FileReader;

/**
 * Created by sumitachauhan on 6/12/17.
 */
public class PrintTable {
    public static void main(String[] args) {
        PrintTable obj = new PrintTable();
//        obj.printTab (12);
//        obj.sumIntFromFile("test.txt");
        int[] a = {-230,19,2,100,11,3,0,200};
//        obj.printOddNum(-90);
//        obj.largestInArray (a);
        System.out.println (obj.formatRGB (0, 155, 100));
    }

    public void printTab(int n)
    {
        for(int i=1; i<=n; i++){
            for(int j=1; j<=n; j++){
                System.out.print(String.format ("%4d", i*j) );
            }
            System.out.println(" ");
        }
    }

    public int fibonacci(int n){
        if(n==0)
            return 0;
        if(n==1)
            return 1;
        int fibprev=0;
        int fibcurr=1;

        for(int i=2; i<=n; i++){
            fibprev=fibcurr;
            fibcurr=fibprev+fibcurr;
        }
        return fibcurr;
    }

    public static void sumIntFromFile(String name) {
        try{
            int total=0;
            BufferedReader bf = new BufferedReader(new FileReader(name));
            for(String s = bf.readLine(); s!=null; s=bf.readLine()){
                total=total+Integer.parseInt(s);
            }
            System.out.println(total);
            bf.close();
        }catch (Exception ex){
            ex.printStackTrace ();
        }
    }

    public void printOddNum(int n){
        //does not handle negative values
        int num=n;
        if(num==0)
            return;
        if(num<0)
            num=num*-1;
        for(int i=1; i<=num; i++){
                if(i%2!=0){
                    System.out.println (i+"\n" );
                }
        }
    }

    public void largestInArray(int[] a){
        int largest=a[0];
        for(int i=1; i<a.length;i++){
            if(a[i]>largest)
                largest=a[i];
        }
        System.out.println(largest);
    }

    public String formatRGB(int red, int green, int blue){
        return getHexadecimal(red) + getHexadecimal(green) + getHexadecimal(blue);
    }
    public String getHexadecimal(int num){
        String hString = Integer.toHexString(num);
        if(hString.length ()==1){
            hString = "0"+hString;
        }
        return hString;
    }
}
