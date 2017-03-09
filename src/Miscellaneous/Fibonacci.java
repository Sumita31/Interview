package Miscellaneous;

import java.util.HashMap;
import java.util.Map;


public class Fibonacci {

    Map<Integer, Integer> fibMap = new HashMap<>();

    //RECURSION
    public int fib(int n)
    {
        fibMap.put(0, 0);
        fibMap.put(1, 1);

        if(n==0) {
            return fibMap.get(0);
        }
        else if(n==1) {
            return fibMap.get(1);
        }
        else
        {
            if(fibMap.containsKey(n-1)) {
            }
            else fibMap.put(n-1, fib(n-1));

            if(fibMap.containsKey(n-2)) {
            }
            else fibMap.put(n-1, fib(n-2));


            return fibMap.get(n-1)+fibMap.get(n-2);
        }
    }

    //ITERATION
    int fibIt(int n)
    {
        int fibcurrent = 1;
        int fibprevious = 0;

        if(n==0)
            return 0;
        if(n==1)
            return 1;
        else
        {
            for(int i=2; i<=n; i++)
            {
                int curr = fibcurrent;
                fibcurrent = fibprevious + fibcurrent;
                fibprevious =curr;
            }
            return fibcurrent;
        }
    }

    long fibonacci(int n) {
        if (n == 0)
            return 0;
        else
            return fibonacciTail(n, 1, 0, 1);
    }

    long fibonacciTail(int n, int m, long fibPrev, long fibCurrent) {
        if (n == m)
            return fibCurrent;
        else
            return fibonacciTail(n, m + 1, fibCurrent, fibPrev + fibCurrent);
    }

    public int fact(int n)
    {
        if(n==0 || n==1)
            return 1;
        else return n*fact(n-1);
    }

    public static void main(String[] args) {
        int[] A = {2,4,6,6,8,8,9};
        Fibonacci obj = new Fibonacci();

        int start = (int)System.nanoTime();
        System.out.println(obj.fib(23));
        int end = (int)System.nanoTime();
        int t = end-start;
        System.out.println("runtime1: " + t);

        System.out.println(obj.fib(21));

        int start2 = (int)System.nanoTime();
        System.out.println(obj.fib(11));
        int end2 = (int)System.nanoTime();
        int t2 = end2-start2;
        System.out.println("runtime2: " + t2);

        //System.out.println(obj.fib(17));

    }
}
