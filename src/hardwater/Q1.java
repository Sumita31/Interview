package hardwater;

import java.util.Arrays;
import java.util.Stack;

/**
 *
 */
public class Q1 {

    static int[] balancedOrNot(String[] expressions, int[] maxReplacements) {
        int[] output = new int[expressions.length];
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < expressions.length; i++) {
            String expression = expressions[i];
            int maxReplacement = maxReplacements[i];
            // empty the stack;
            stack.removeAllElements();
            int numMistakes = 0;
            for(char ch : expression.toCharArray()) {
                if(ch == '<') {
                    stack.push(ch);
                }
                if (ch == '>') {
                    if(stack.isEmpty()) {
                        numMistakes++;
                    } else {
                        stack.pop();
                    }
                }
            }
            if(!stack.isEmpty()) {
                output[i] = 0;
            }
            else {
                output[i] = numMistakes <= maxReplacement ? 1 :0;
            }
        }
        return output;
    }

    public static void main(String[] args) {
        String[]  expressions = {"<<<><><>"};
        int[] maxReplacements = {2};
        System.out.println(Arrays.toString(balancedOrNot(expressions, maxReplacements)));
    }
}
