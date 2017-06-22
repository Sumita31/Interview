package StringArray;

import java.util.Arrays;
import java.util.StringJoiner;

/**
 * Created by sumitachauhan on 3/6/17.
 */
public class Anagram {

    //Check if the two strings have identical counts for each unique char
    public boolean isAnagram1(String str1, String str2)
    {
        if(str1==null || str2==null || str1.length()!=str2.length())
            return false;

        int[] letters = new int[256];

        char[] s_array = str1.toCharArray();

        for (char c : s_array)
        {
            letters[c] = letters[c]+1;
        }

        for (int i = 0; i < str2.length(); ++i)
        {
            int c = (int) str2.charAt(i);
            if (letters[c] == 0)
            { // Found more of char c in t than in s.
                return false;
            }
             letters[c] = letters[c]-1;
        }

        return true;

    }

    //Sort the strings and compare
    public boolean isAnagram2(String str1, String str2)
    {
        char[] c1 = str1.toCharArray();
        char[] c2 = str2.toCharArray();

        Arrays.sort(c1);
        Arrays.sort(c2);

        str1 = String.copyValueOf(c1);
        str2 = String.copyValueOf(c2);

        return str1.equals(str2);

    }

    //XOR of same elements is zero. A XOR A = 0
    public boolean isAnagram3(String str1, String str2) {
        if(str1==null || str2==null || str1.length()!=str2.length())
            return false;
        char c1[] = str1.toCharArray();
        char c2[] = str2.toCharArray();

        int j = c1[0];
        for(int i = 1; i < c1.length; i++) {
            j = j ^ c1[i];
        }
        for(char ch : c2) {
            j = j ^ (int)ch;
        }
        return j == 0;
    }


    public static void main(String[] args) {
        Anagram obj = new Anagram();
        System.out.println(obj.isAnagram3("sssaa", "sssaa"));
    }
}
