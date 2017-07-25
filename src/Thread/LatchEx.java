package Thread;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by sumitachauhan on 7/22/17.
 */
public class LatchEx {
    public static void main(String[] args) {
        CountDownLatch latch = new CountDownLatch(3);
        ExecutorService executor = Executors.newFixedThreadPool(3);
        for (int i = 0; i < 3; i++) {
            executor.submit(new LatchProcessor(latch));
        }

        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("completed");
    }
}

 class LatchProcessor implements Runnable{
    private CountDownLatch latch;
    public LatchProcessor(CountDownLatch latch){
        this.latch=latch;
    }
    public void run(){
        System.out.println("started.");
        try{
            Thread.sleep(3000);
        }catch (InterruptedException ex){
            System.out.println(ex);
        }
        latch.countDown();
    }
}