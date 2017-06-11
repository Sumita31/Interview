package Miscellaneous;

/**
 * Created by sumitachauhan on 3/14/17.
 */
public class CaseChange {

    public static String toUpperCase(String string)
    {
        int length = string.length();
        for (int i = 0; i < length; i++)
        {
            if (isLowerCase(string.charAt(i)))
            {
                char[] chars = string.toCharArray();
                for (; i < length; i++)
                {
                    char c = chars[i];
                    if (isLowerCase(c))
                    {
                        chars[i] = (char) (c & 0x5f);
                    }
                }
                return String.valueOf(chars);
            }
        }
        return string;
    }

    public static String toUpperCase2(String string)
    {
        int length = string.length();
        char[] chars = string.toCharArray();
        for (int i = 0; i < length; i++)
        {
            if (isLowerCase(string.charAt(i)))
            {
                chars[i] = (char) (chars[i] & 0x5f);
            }
        }
        return String.valueOf(chars);
    }


    public static boolean isLowerCase(char c) {
        // Note: This was benchmarked against the alternate expression "(char)(c - 'a') < 26" (Nov '13)
        // and found to perform at least as well, or better.
        return (c >= 'a') && (c <= 'z');
    }

    public static void main(String[] args) {
//        System.out.println(CaseChange.toUpperCase2("sumitaCHUGLU"));
        String a = "AbC";
        String b = toUpperCase(a);
        System.out.println(a == b);
    }
}
