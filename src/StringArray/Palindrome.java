package StringArray;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by sumitachauhan on 3/6/17.
 */
public class Palindrome {

    public boolean isPalindrome1(String str)
    {
        if(str==null)
            return false;

        char[] charA = str.toCharArray();
        int i=0, j=charA.length-1;
        while(i<=j)
        {
            if(charA[i]!=charA[j])
                return false;
            else {
                i++;
                j--;
            }
        }
        return true;
    }


    public boolean canFormPalindrome(String str)
    {
        if(str == null) throw new RuntimeException("str is null");

        if (str.length() == 1) return true;

        char arr[] = str.toCharArray();

        int possible_palindrome = (int)arr[0];

        for (int i = 1; i < arr.length; i++) {
            possible_palindrome ^= arr[i];
        }

        if (possible_palindrome == 0) return true;

        int is_palindrome = arr[0];
        boolean hasSkipped = false;

        for (int i = 1; i < arr.length; i++) {
            if (!hasSkipped && arr[i] == possible_palindrome) {
                hasSkipped = true;
                continue;
            }
            is_palindrome ^= arr[i];
        }
        return is_palindrome == 0;

    }

    public static void main(String[] args) {
        Palindrome obj = new Palindrome();
        System.out.println("isPalindrome1"+ obj.isPalindrome1("adda"));
        System.out.println("canFormPalindrome: " + obj.isPalindrome1("aaaaaabaaaaaaaaa"));

    }
}
