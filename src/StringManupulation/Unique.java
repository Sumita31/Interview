package StringManupulation;

import java.util.Arrays;

/**
 * Created by sumitachauhan on 6/17/17.
 */
public class Unique{
    public boolean isUnique(String str){
        boolean[] allchar = new boolean[256];
        for(int i=0; i<str.length (); i++){
            if(allchar[str.charAt (i)]!=true){
                allchar[str.charAt (i)]= true;
            }
            else return false;
        }
        return true;
    }

    public boolean isUniqueBySort(String str){
        char[] ar = str.toCharArray();
        Arrays.sort(ar);
        for(int i=0; i<ar.length-1; i++){
            if(ar[i]==ar[i+1])
                return false;
        }
        return true;
    }

    public static void main(String[] args){
        String str = "sumi";
        Unique obj = new Unique();
        System.out.println (obj.isUnique (str));
        System.out.println (obj.isUniqueBySort (str));
    }
}
