package StringArray;


import com.sun.javaws.exceptions.InvalidArgumentException;

import java.util.*;

/**
 * Created by sumitachauhan on 3/8/17.
 */
public class MajorityElement{

    public int naiveSolution(int[] input)
    {
        if(input == null || input.length ==0)
            throw null;

        Arrays.sort(input);
        int midElement = input[(input.length-1)/2];
        int totalCount=0;
        for(int count=0; count<input.length; count++)
        {
            if(input[count] == midElement)
                totalCount =totalCount+1;
        }

        if(totalCount > (input.length)/2)
            return midElement;
        else return Integer.MIN_VALUE;
    }

    public int betterSolution(int[] input)
    {
        /*
        Moore’s Voting Algorithm
         */
        int result = 0;
        int count=0;

        for(int counter=0; counter<input.length; counter++)
        {
            if(count==0)
            {
                result=input[counter];
                count++;
            }
            else if(result == input[counter])
            {
                count++;
            }
            else count--;
        }
        return result;
    }

    public int majorityElement(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i: nums){
            if(map.containsKey(i)){
                map.put(i, map.get(i)+1);
            }else{
                map.put(i, 1);
            }
        }

        //List<Integer> result = new ArrayList<Integer>();
        int result =Integer.MIN_VALUE;
        for(Map.Entry<Integer, Integer> entry: map.entrySet()){
            if(entry.getValue() > nums.length/2){
                result = entry.getKey();
            }
        }

        return result;
    }

    public int findMajority(int a[], int size)
    {
        int maj_index = 0, count = 1;
        int i;
        for (i = 1; i < size; i++)
        {
            if (a[maj_index] == a[i])
                count++;
            else
                count--;
            if (count == 0)
            {
                maj_index = i;
                count = 1;
            }
        }
        return a[maj_index];
    }

    public static void main(String[] args) {
        int[] input = {3,3,5,4,4,2,2,2};
        MajorityElement obj = new MajorityElement();
        System.out.println(obj.findMajority(input, input.length));
        System.out.println(obj.naiveSolution(input));
        System.out.println(obj.majorityElement(input));
    }
}
