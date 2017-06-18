package StringManupulation;


import java.math.BigInteger;

public class StringIsValidNumber{
    public boolean validInt(String str){
        try{
            Integer.parseInt(str);
            return true;
        }catch (Exception e){
            return false;
        }
    }
    public boolean validFloat(String str){
        try{
            Float.parseFloat (str);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    public boolean validBigInt(String str){
        try{
            new BigInteger (str);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    public boolean validNum(String str){
        char[] ca = str.toCharArray ();
        for(int i=0; i<ca.length;i++){
            if(ca[i]-'1'>9 || ca[i]-'1'<0)
                return false;
        }
        return true;
    }

    public boolean validUpper(String str){
        char[] ca = str.toCharArray ();
        for(int i=0; i<ca.length;i++){
            if(ca[i]-'A'>25 || ca[i]-'A'<0)
                return false;
        }
        return true;
    }

    public boolean validLower(String str){
        char[] ca = str.toCharArray ();
        for(int i=0; i<ca.length;i++){
            if(ca[i]-'a'>25 || ca[i]-'a'<0)
                return false;
        }
        return true;
    }

    public static void main(String[] args){
        String s = "WERSA";
        StringIsValidNumber obj = new StringIsValidNumber();
        System.out.println ("Is Big Integer: "+obj.validBigInt (s));
        System.out.println ("Is Float: "+obj.validFloat(s));
        System.out.println ("Is Integer: "+obj.validInt(s));
        System.out.println ("Is Number: "+obj.validNum(s));
        System.out.println ("Is Upper: "+obj.validUpper(s));
        System.out.println ("Is Lower: "+obj.validLower(s));
        System.out.println (Character.isUpperCase ('S'));
    }

    /* FROM geekforgeeks
    Ignore the leading and trailing white spaces.
    Ignore the ‘+’, ‘-‘ and’.’ at the start.
    Ensure that the characters in the string belong to {+, -, ., e, [0-9]}
    Ensure that no ‘.’ comes after ‘e’.
    A dot character ‘.’ should be followed by a digit.
    The character ‘e’ should be followed either by ‘+’, ‘-‘, or a digit.
     */
    public boolean testCases(String str){
        str = str.trim(); // trims the white spaces.

        if (str.length() == 0)
            return false;

        // if string is of length 1 and the only
        // character is not a digit
        if (str.length() == 1 &&
                !Character.isDigit(str.charAt(0)))
            return false;

        // If the 1st char is not '+', '-', '.' or digit
        if (str.charAt(0)!='+' && str.charAt(0)!='-' &&
                !Character.isDigit(str.charAt(0)) &&
                str.charAt(0)!='.')
            return false;

        // To check if a '.' or 'e' is found in given
        // string. We use this flag to make sure that
        // either of them appear only once.
        boolean flagDotOrE = false;

        for (int i=1; i<str.length(); i++)
        {
            // If any of the char does not belong to
            // {digit, +, -, ., e}
            if (!Character.isDigit(str.charAt(i)) &&
                    str.charAt(i) != 'e' && str.charAt(i)!='.' &&
                    str.charAt(i) != '+' && str.charAt(i)!='-')
                return false;

            if (str.charAt(i) == '.')
            {
                // checks if the char 'e' has already
                // occurred before '.' If yes, return 0.
                if (flagDotOrE == true)
                    return false;

                // If '.' is the last character.
                if (i+1 >= str.length())
                    return false;

                // if '.' is not followed by a digit.
                if (!Character.isDigit(str.charAt(i+1)))
                    return false;
            }

            else if (str.charAt(i) == 'e')
            {
                // set flagDotOrE = 1 when e is encountered.
                flagDotOrE = true;

                // if there is no digit before 'e'.
                if (!Character.isDigit(str.charAt(i-1)))
                    return false;

                // If 'e' is the last Character
                if (i+1>=str.length())
                    return false;

                // if e is not followed either by '.',
                // '+', '-' or a digit
                if (!Character.isDigit(str.charAt(i+1)) &&
                        str.charAt(i+1) != '+' &&
                        str.charAt(i+1) != '-')
                    return false;
            }
        }

		/* If the string skips all above cases, then
		it is numeric*/
        return true;
    }
}
