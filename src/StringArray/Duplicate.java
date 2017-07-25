package StringArray;

import java.util.*;


public class Duplicate {

    //AFTER SORTING
    public int[] removeDuplicate1(int[] ar)
    {
        //remove from sorted array
        if(ar.length<2)
            return ar;

        Arrays.sort(ar);
        int j=0, i=1;
        while(i<ar.length) {

            if (ar[i] == ar[j]) {
            i++;
            }
            else{
              j++;
              ar[j]=ar[i];
              i++;
            }
        }

        int[] result = Arrays.copyOf(ar, j+1);
        return result;

    }

    //USING EXTRA SPACE
    public int[] removeDuplicate2(int[] ar)
    {
        Set<Integer> set = new HashSet<>();
        for(int i: ar)
        {
            set.add(i);
        }
        int[] res = new int[set.size ()];
        int i=0;


        for(int t: set){
            res[i]=t;
            i++;
        }

//        Iterator it = set.iterator();
//        while (it.hasNext())
//        {
//            res[i]= (int)it.next();
//            //System.out.print(it.next());
//            i++;
//        }
        return res;
    }

    //WITHOUT SORTING
    public int[] removeDuplicate3(int[] arr)
    {
        //remove without sorting array
        if(arr.length<2)
            return arr;

        int end = arr.length;

        for (int i = 0; i < end; i++) {
            for (int j = i + 1; j < end; j++) {
                if (arr[i] == arr[j]) {
                    arr[j] = arr[end-1];
                    end--;
                    j--;
                }
            }
        }
        int[] result = Arrays.copyOf(arr, end);
//        int[] whitelist = new int[end];
//        System.arraycopy(arr, 0, whitelist, 0, end);
        return result;
    }

    public static void main(String[] args) {
        Duplicate obj = new Duplicate();
        int[] ar = {99,90,90,99,20,100};

//        int[] res = obj.removeDuplicate1(ar);
//        for(int i=0; i<res.length; i++)
//        {
//            System.out.print(res[i]);
//        }
//
//        System.out.println();
        int[] res1=obj.removeDuplicate2(ar);
        for(int i=0; i<res1.length; i++)
        {
            System.out.print(res1[i]+", ");
        }

//        System.out.println();
//        int[] res2 = obj.removeDuplicate3(ar);
//        for(int i=0; i<res2.length; i++)
//        {
//            System.out.print(res2[i]+", ");
//        }
//
//        System.out.println (obj.hasDuplicate1(ar) );
//        System.out.println (obj.hasDuplicate2(ar) );
    }

    public boolean hasDuplicate1(int[] a){
        for(int i=0; i<a.length-2; i++){
            for(int j=1; j<a.length-1; j++){
                if(a[i]==a[j])
                    return true;
            }
        }
        return false;
    }
    public boolean hasDuplicate2(int[] a){
        Arrays.sort(a);
        for(int i=0; i<a.length-1; i++){
            if(a[i] == a[i+1]){
                System.out.println(a[i]);
                return true;
            }
        }
        return false;
    }
}
