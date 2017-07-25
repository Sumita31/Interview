package Thread;

import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * Created by sumitachauhan on 7/22/17.
 */
public class ProducerConsumerEx {
    public static void main(String[] args) {
        Thread t1= new Thread(new Runnable() {
            @Override
            public void run() {
                producer();
            }
        });
        Thread t2= new Thread(new Runnable() {
            @Override
            public void run() {
                consumer();
            }
        });
        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        }catch (InterruptedException ex){
            System.out.println(ex);
        }
    }
    private static BlockingQueue<Integer> queue = new ArrayBlockingQueue<Integer>(10);
    private static Random rand = new Random();
    private static void producer(){
        while(true){
            try {
                queue.put(rand.nextInt(100));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private static void consumer(){
        Random r=new Random();
        while (true){
            try {
                //Thread.sleep(100);
                if(r.nextInt(10)==0){
                    Integer val = queue.take();
                    System.out.println("value: "+val+" size: "+queue.size());
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
