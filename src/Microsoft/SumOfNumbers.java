package Microsoft;

/**
 * Created by sumitachauhan on 6/29/17.
 */
public class SumOfNumbers {
    public static void main(String[] args) {
        String inputStr = "xyzonexyztwothreeeabrminusseven";
        int i=0, sum=0;

        String currString = "";

        inputStr =inputStr.replace("one", "1");
        inputStr =inputStr.replace("two", "2");
        inputStr =inputStr.replace("three", "3");
        inputStr =inputStr.replace("four", "4");
        inputStr =inputStr.replace("five", "5");
        inputStr =inputStr.replace("six", "6");
        inputStr =inputStr.replace("seven", "7");
        inputStr =inputStr.replace("eight", "8");
        inputStr =inputStr.replace("nine", "9");
        inputStr =inputStr.replace("zero", "0");
        inputStr =inputStr.replace("minus", "-");

        while(i<inputStr.length())
        {
            if(inputStr.charAt(i) >= '0' && inputStr.charAt(i) <= '9' || inputStr.charAt(i) == '-' )
            {
                currString = currString + inputStr.charAt(i);
                i++;
            }
            else
            {
                if(currString != "")
                {
                    sum = sum + Integer.parseInt(currString);
                    currString = "";
                }
                i++;
            }
        }

        if(currString != "")
            sum = sum + Integer.parseInt(currString);

        System.out.println(sum);

    }
}
