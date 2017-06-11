package Thread;

/**
 * Created by sumitachauhan on 6/10/17.
 */
public class Demo1 {
    public static void main(String[] args){
        MyThread1 t1 = new MyThread1();
        t1.start();

        Thread t2 = new Thread(new MyThread2());
        t2.start();

        Thread t3 = new Thread(new Runnable(){
            public void run(){
                for(int i=0; i<10; i++){
                    System.out.println("Counter running for Annonymous: "+ i);
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        t3.start();
    }
}

/*Two ways to create threads in Java
* 1. extend Thread class -- you can extend only one class
* 2. implement Runnable interface -- you can implement other interfaces as well at the same time.
* */
class MyThread1 extends Thread{
    public void run(){
        for(int i=0; i<10; i++){
            System.out.println("Counter running for Extend: "+ i);
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class MyThread2 implements Runnable{
    public void run(){
        for(int i=0; i<10; i++){
            System.out.println("Counter running for Implement: "+ i);
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
