package StringArray;

import java.util.*;

public class StringPermutation {

    int count = 0;

    public void permute(String str, int start, int end, List<String> list)
    {
        if(start == end) {
            //System.out.println(str);
            list.add(str);
        }
        else
        {
            for(int i =start; i<=end; i++)
            {
                str = swap(str,start,i);
                permute(str, start+1, end, list);
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
        String str = "123";
        List<String> permutations = new ArrayList<>();
        StringPermutation obj = new StringPermutation();
        obj.permute(str, 0, str.length() - 1, permutations);
        for(String s:permutations){
            System.out.print(s +", ");
        }
    }
}
