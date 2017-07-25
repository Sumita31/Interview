package Thread;

import java.util.Scanner;

public class VolatileForCachingProblem {

    public static void main(String[] args) {
        //object of class VolatileEx that implements Runnable interface
        VolatileEx obj = new VolatileEx();
        //object of Thread class, pass object obj
        Thread t1=new Thread(obj);
        t1.start();
        Scanner sc = new Scanner(System.in);
        sc.nextLine();
        System.out.println("press any key");
        obj.shutdown();
    }
}

class VolatileEx implements Runnable{
    //Volatile keyword solves the problem of caching
    public volatile
    boolean running = true;
    public void run(){
        while(running){
            System.out.println("hello!");
        }
    }
    public void shutdown(){
        running = false;
    }
}
