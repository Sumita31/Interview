package Amazon;

import java.util.*;

public class Fibonacci {
    private  Map<Long, Long> fibMap=new HashMap();
    public long recurs(long n){
        if(!fibMap.containsKey(n)){
            if(n==0 || n==1){
                fibMap.put(n,n);
            }
            else{
                fibMap.put(n, recurs(n-1)+recurs(n-2));
            }
        }
        return fibMap.get(n);
    }

    public long itter(int n){
        if(n==0 || n== 1)
            return n;
        long prev=0;
        long cur=1;
        for(int i=2; i<=n; i++){
            cur=cur+prev;
            prev=cur-prev;
        }
        return cur;
    }

    public static void main(String[] args) {
        Fibonacci obj = new Fibonacci();

        long startR = System.currentTimeMillis();
        System.out.println(obj.recurs(100));
        long endR = System.currentTimeMillis();
        System.out.println("time taken: "+(-startR+endR));

        long startI = System.currentTimeMillis();
        System.out.println(obj.recurs(100));
        long endI = System.currentTimeMillis();
        System.out.println("time taken: "+(-startI+endI));
    }

}
