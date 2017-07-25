package Thread;

import java.util.*;

public class MultipleLocksEx {
    public static void main(String[] args) {
        WorkerLock obj = new WorkerLock();
        obj.main();
    }
}
class WorkerLock{
    private Random rand=new Random();
    private Object lock1=new Object();
    private Object lock2=new Object();
    private List<Integer> list1=new ArrayList<>();
    private List<Integer> list2=new ArrayList<>();

    public void stageOne(){
        synchronized (lock1){
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            list1.add(rand.nextInt());
        }
    }

    public void stageTwo(){
        synchronized (lock2){
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            list2.add(rand.nextInt());
        }
    }

    public void process(){
        for(int i=0; i<1000; i++){
            stageOne();
            stageTwo();
        }
    }
    public void main(){
        System.out.println("start ........");

        long start=System.currentTimeMillis();
        Thread t1=new Thread(new Runnable() {
            @Override
            public void run() {
                process();
            }
        });

        Thread t2=new Thread(new Runnable() {
            @Override
            public void run() {
                process();
            }
        });

        t1.start();
        t2.start();
        try {
            t1.join();
            t2.join();
        }catch (Exception ex){
            System.out.println(ex);
        }
        long end = System.currentTimeMillis();
        System.out.println("total time: " + (end-start));
        System.out.println("List1: "+list1.size()+" List2: "+list2.size());
        System.out.println("finish........");
    }
}
