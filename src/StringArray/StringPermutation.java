package StringArray;

import java.util.*;

public class StringPermutation {

    int count = 0;

    public void permute(String str, int start, int end)
    {
        if(start == end)
            System.out.println(str );
        else
        {
            for(int i =start; i<=end; i++)
            {
                str = swap(str,start,i);
                permute(str, start+1, end);
                //str = swap(str,start,i);
            }
        }
    }

    public String swap(String a, int i, int j)
    {
        char temp;
        char[] charArray = a.toCharArray();

        temp = charArray[i] ;
        charArray[i] = charArray[j];
        charArray[j] = temp;

        return String.valueOf(charArray);
    }

    public Queue<List<Integer>> permutations(int[] arr) {
        Queue<List<Integer>> result = new LinkedList<>();
        for(int i = 0; i < arr.length; i++) {
            method(result, arr[i]);
        }
        return result;
    }

    public void method(Queue<List<Integer>> knownPermutations, int newElement)
    {
        int len = knownPermutations.size();
        if(len == 0) {
            List<Integer> singlePermutation = new ArrayList<>();
            singlePermutation.add(newElement);
            knownPermutations.add(singlePermutation);
            return;
        }
        for(int i = 0; i < len;  i++) {
            List<Integer> knownPermutation = knownPermutations.remove();
            for(int j = 0 ; j <= knownPermutation.size(); j++) {
                List<Integer> newPermutation = new ArrayList<>();
                newPermutation.addAll(knownPermutation);
                newPermutation.add(j, newElement);
                knownPermutations.add(newPermutation);
            }
        }

    }

    public static void main(String[] args) {
//        String str = "ABC";
//        StringPermutation obj = new StringPermutation();
//        obj.permute(str, 0, str.length()-1);
        System.out.println(new StringPermutation().permutations(new int[]{1, 2, 3}));
    }
}
