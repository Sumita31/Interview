package Thread;

import java.util.*;

public class Worker {
    private Random random = new Random();
    private List<Integer> list1 = new ArrayList<>();
    private List<Integer> list2 = new ArrayList<>();
    private final Object lock1 = new Object();
    private final Object lock2 = new Object();

    /*
    Making both methods synchronized, they try to acquire the lock on same object of Worker
    class and it takes twice as much to run both the methods.
    To work this properly we have to create two separate locks for two methods.
     */
    private synchronized void stageOne(){
        try {
            Thread.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        list1.add(random.nextInt(100));
    }

    private  void stageOneS(){
        synchronized (lock1){
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            list1.add(random.nextInt(100));
        }
    }

    private synchronized void stageTwo(){
        try {
            Thread.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        list2.add(random.nextInt(100));
    }

    private synchronized void stageTwoS(){
        synchronized (lock2) {
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            list2.add(random.nextInt(100));
        }
    }

    private void process(){
        for(int i=0; i<1000; i++){
            stageOneS();
            stageTwoS();
        }
    }

    public void main(){
        System.out.println("----Starting----");
        long start = System.currentTimeMillis();
        Thread t1 = new Thread(new Runnable() {

            public void run() {
                process();
            }
        });
        Thread t2 = new Thread(new Runnable() {

            public void run() {
                process();
            }
        });

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        long end = System.currentTimeMillis();
        System.out.println("Time taken: " + (end-start));
        System.out.println("List1: " + list1.size()+ " List2: "+ list2.size());
    }
}
