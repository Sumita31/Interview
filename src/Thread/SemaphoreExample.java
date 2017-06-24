package Thread;

import java.util.concurrent.Semaphore;

/**
 * Created by sumitachauhan on 6/23/17.
 */
public class SemaphoreExample {

    private static class Counter {
        private int count;

        public Counter() {
            this.count = 0;
        }

        public synchronized void increment() {
            count = count + 1;
        }
    }


    public static void main(String[] args) {

        Counter counter = new Counter();

        Runnable r = new Runnable() {
            @Override
            public void run() {
                while (true) {
                    counter.increment();
                    try {
                        Thread.sleep((long)(Math.random()* 1000));
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };

        new Thread(r).start();
        Thread t2 =  new Thread(r);
        t2.start();

    }
}
