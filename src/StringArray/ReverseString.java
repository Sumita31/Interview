package StringArray;

import java.util.Stack;

/**
 * Created by sumitachauhan on 3/5/17.
 */
public class ReverseString {

    public String reverseWords1(String str)
    {
        if(str == null || str.length()==0) {
            System.out.println("Invalid String");
            return null;
//            throw new IllegalArgumentException ("Input string null or empty");
        }

        str.trim();

        String[] strA = str.split(" ");

        Stack<String> stackOfStrings = new Stack<>();
        for(String s : strA)
        {
            stackOfStrings.push(s);
        }

        StringBuilder sb = new StringBuilder();
        while(!stackOfStrings.empty())
        {
            sb.append(stackOfStrings.pop()).append(" ");
        }

        return sb.substring(0);

       //String.copyValueOf(resA);
    }

    //reverse characters in a string
    public String reverseString2(String str)
    {
        if(str == null)
            return str;

        int p1=0, p2=str.length()-1;
        char[] charA = str.toCharArray();
        while(p1<p2)
        {
            char temp = charA[p1];
            charA[p1] = charA[p2];
            charA[p2] = temp;
            p1++;
            p2--;
        }
        str = str.copyValueOf(charA);
        return str;

    }

    /**
     * Example: Let the input string be “i like this program very much”. The
     * function should change the string to “much very program this like i”
     Algorithm:
     1) Reverse the individual words, we get the below string.
     "i ekil siht margorp yrev hcum"
     2) Reverse the whole string from start to end and you get the desired output.
     "much very program this like i"
     */
    public static void reverse(char arr[], int fromIdx, int toIdx){
        while(fromIdx < toIdx) {
            char temp = arr[fromIdx];
            arr[fromIdx] = arr[toIdx];
            arr[toIdx] = temp;
            fromIdx++;
            toIdx--;
        }
    }

    public static void reverseWords(char arr[]){
        int startIdx = -1;
        int counter = 0;
        while(counter < arr.length){
            if(startIdx == -1 && arr[counter] != ' ')
                startIdx = counter;
            else if(startIdx != -1 && (counter + 1 == arr.length ||
                    arr[counter+1] == ' ' ))
            {
                reverse(arr,startIdx, counter);
                startIdx = -1;
            }
            counter++;
        }
        reverse(arr,0, arr.length-1);
    }

    public static void main(String[] args) {
        String str = "Sumita is my name";
        ReverseString obj = new ReverseString();

        System.out.println(obj.reverseWords1("Sumita Chauhan"));
//        System.out.println(obj.reverseString2(str));
//        System.out.println("Reverse of Sumita Chauhan is: "+obj.reverseString ("Sumita Chauhan"));

    }

    public String reverseString(String str){
        char[] chars = str.toCharArray();
        int last = chars.length-1;
        for(int i=0; i<=last/2; i++){
            char temp = chars[i];
            chars[i] = chars[last-i];
            chars[last-i]=temp;
        }
        return new String(chars);
    }
}
