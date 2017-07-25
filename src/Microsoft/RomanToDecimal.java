package Microsoft;

import java.util.*;


public class RomanToDecimal {
    public int convert(String num){
        int intNum=0;
        int prev = 0;
        Map<Character, Integer> map = new HashMap<>();
        map.put('V',5);
        map.put('I',1);
        map.put('X',10);
        map.put('C',100);
        map.put('L',50);
        map.put('M',1000);
        for(int i = num.length()-1; i>=0 ; i--)
        {
            int temp = map.get(num.charAt(i));
            if(temp < prev)
                intNum-=temp;
            else
                intNum+=temp;
            prev = temp;
        }
        return intNum;
    }

    public static void main(String[] args) {
//        System.out.println((22&1)==0? "EVEN":"ODD");
//        System.out.println((8<<1)); // Multiply number with 2(shift left by 1 bit)
//        System.out.println((8>>1)); // Divide number by 2(shift right by 1 bit)
        //swaping two numbers without using third variable
        int a=10;
        int b=20;
        a=a^b;
        b=a^b;
        a=a^b;
        System.out.println(a+", "+b);
        RomanToDecimal obj = new RomanToDecimal();
        System.out.println(obj.convert("XIV"));
    }
}
