package StringManupulation;


import java.util.Arrays;
import java.util.Stack;

public class ExtractWords{

    public void extractWords(String str){
        if(str==null|| str.length ()==0)
            throw new IllegalArgumentException ("String can't be null");

        String inputString = str.trim();
        String[] splitStr = inputString.split (" ");
        for(String s: splitStr){
            System.out.println (s );
        }
    }

    public String reverseString(String str){
        if(str==null || str.length()==0)
            throw new IllegalArgumentException("string can not be null or empty");
        String input = str.trim();
        String[] strWords = input.split(" ");
        Stack<String> strStack = new Stack<> ();
        for(String s : strWords){
            strStack.push(s);
        }
        StringBuilder reversedString = new StringBuilder ();
        while(!strStack.isEmpty()){
            reversedString.append(strStack.pop()).append (" ");
        }

        System.out.println(reversedString);
        return String.valueOf(reversedString);
    }

    public String reverseChar(String str){
        if(str==null || str.length()==0)
            throw new IllegalArgumentException("string can not be null or empty");
        int start=0, end=str.length()-1;
        char[] temp = str.toCharArray();
        while(start<end){
            char tempChar = temp[start];
            temp[start]=temp[end];
            temp[end]=tempChar;
            start++;
            end--;
        }
        return String.copyValueOf (temp);
    }

    public static void reverse(char arr[], int fromIdx, int toIdx){
        while(fromIdx < toIdx) {
            char temp = arr[fromIdx];
            arr[fromIdx] = arr[toIdx];
            arr[toIdx] = temp;
            fromIdx++;
            toIdx--;
        }
    }

    public String reverseWords(String str){
        char[] arr = str.toCharArray ();
        int startIdx=-1, counter=0;
        while(counter<arr.length){
            if(startIdx==-1 && arr[counter+1]!= ' ')
            {
                startIdx = counter;
            }
            else if(startIdx != -1 && (arr[counter+1] == ' '
                    || counter + 1 == arr.length))  //throws error - array index out of bounds
            {
                reverse (arr, startIdx, counter);
                startIdx=-1;
            }
            counter++;
        }
        reverse (arr, 0, arr.length-1);
        return String.copyValueOf(arr);
    }

    public String commonSubString(String[] str){
        Arrays.sort(str);
        int i=0, len=str.length;
        while(i<str[0].length() && str[0].charAt(i)==str[len-1].charAt(i)){
            i++;
        }
        return str[0].substring (0,i);
    }

    public static void main(String[] args){
        ExtractWords obj = new ExtractWords ();
        obj.extractWords ("My name is sumita chauhan. what is your name? ");
        obj.reverseString ("sumita harshita kritika");
        System.out.println (obj.reverseWords ("sumita harshita kritika"));
        String[] str = {"Sumita", "SumitaChauhan", "Sumina", "S","h"};
        System.out.println (obj.commonSubString (str));
    }
}
