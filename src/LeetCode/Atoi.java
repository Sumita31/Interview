package LeetCode;

/**
A to i ==> String to integer
 */
public class Atoi {

    public int atoi(String str)
    {
        if(str == null || str.length()<=0)
            return 0;

        str = str.trim();

        char flag = '+';
        int i=0;

        if(str.charAt(0) == '-') {
            flag = '-';
        }

        i++;

        double result = 0;

        while(i<str.length() && str.charAt(i)>='0' && str.charAt(i)<='9')
        {
            result = result * 10 + str.charAt(i) - '0';
            i++;
        }

        if(flag == '-')
            result = -result;

        if(result>Integer.MAX_VALUE)
            return Integer.MAX_VALUE;
        if(result<Integer.MIN_VALUE)
            return Integer.MIN_VALUE;

        return (int) result;
    }

    public static void main(String[] args) {
        Atoi obj = new Atoi();
        System.out.println(obj.atoi("000020"));
    }
}
