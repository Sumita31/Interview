package hardwater;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

/**
 * This is a programming test
 To get familiarized with our coding environment, try our Sample Test
 You must use C, C++ or Java to complete this challenge.
 If the code area contains the function signature, just complete the function alone, we'll take care of the main function, headers, etc
 If you're expected to write the full code, it'd be mentioned in the code area. All inputs are from STDIN and output to STDOUT. If you're using Java, use the classname as 'Solution'
 To understand more about the environment, time limits, etc. you can read the FAQ here
 You can print to console to debug your code using the appropriate print command for each language (Eg: cout for C++, printf for C, etc.)
 */
public class Q2 {


    static int power(int n, int p) throws Exception {
        if(n < 0 || p < 0) {
            throw new Exception("n and p should be non-negative");
        }

        return (p == 0) ? 1 : n*power(n,p-1);
    }

    public static void main(String args[]){

        Scanner scanner = new Scanner(System.in);
        String line;
        while (scanner.hasNextLine() && (line = scanner.nextLine()).trim().length() != 0 ) {
            String[] numbers = line.split("\\s+");
            int n = Integer.parseInt(numbers[0]);
            int p = Integer.parseInt(numbers[1]);
            try {
                System.out.println(power(n, p));
            } catch (Exception e) {
                System.out.println(e.toString());
            }
        }
//        List<Integer> i = new ArrayList<>();
//        Pattern p = Pattern.compile("(\\d+)\\s(\\d+)");
//        while(scanner.hasNext(p)) {
//           i.add(scanner.nextInt());
//        }
//        System.out.println(i);
    }
}
