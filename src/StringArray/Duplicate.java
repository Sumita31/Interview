package StringArray;

import java.util.*;


public class Duplicate {

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

    public void removeDuplicate2(int[] ar)
    {
        Set<Integer> set = new HashSet<>();
        for(int i: ar)
        {
            set.add(i);
        }

        Iterator it = set.iterator();
        while (it.hasNext())
        {
            System.out.print(it.next());
        }
    }

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

        int[] whitelist = new int[end];
        System.arraycopy(arr, 0, whitelist, 0, end);
        return whitelist;
    }

    public static void main(String[] args) {
        Duplicate obj = new Duplicate();
        int[] ar = {99,20,30,99,20};

        int[] res = obj.removeDuplicate1(ar);
        for(int i=0; i<res.length; i++)
        {
            System.out.print(res[i]);
        }

        System.out.println();
        obj.removeDuplicate2(ar);

        System.out.println();
        int[] res2 = obj.removeDuplicate3(ar);
        for(int i=0; i<res2.length; i++)
        {
            System.out.print(res2[i]);
        }
    }
}
