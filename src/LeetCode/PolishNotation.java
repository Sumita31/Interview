package LeetCode;
import java.util.*;
import java.io.*;
/**
 * Created by sumitachauhan on 2/24/17.
 */
public class PolishNotation {
    public static void main(String[] args) throws IOException {
        String[] tokens = new String[] { "2", "10", "+", "3", "*" };
        System.out.println(evalRPN(tokens));
    }

    public static int evalRPN(String[] tokens) {
        int result = 0;
        String symbol ="+-*/";
        Stack<String> tempStack = new Stack<>();

        for(String t: tokens)
        {
            if(!symbol.contains(t))
            {
                tempStack.push(t);
            }
            else
            {
                int a = Integer.valueOf(tempStack.pop());
                int b = Integer.valueOf(tempStack.pop());
                System.out.println(t);
                switch (t)
                {
                    case "+":
                        result = a+b;
                        tempStack.push(String.valueOf(result));
                        break;
                    case "-":
                        result = a-b;
                        tempStack.push(String.valueOf(result));
                        break;
                    case "*":
                        result = a*b;
                        tempStack.push(String.valueOf(result));
                        break;
                    case "/":
                        result = a/b;
                        tempStack.push(String.valueOf(result));
                        break;
                }
            }
        }
        result = Integer.valueOf(tempStack.pop());
        return result;
    }
}
