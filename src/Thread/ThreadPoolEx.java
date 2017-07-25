package Thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ThreadPoolEx {
    public static void main(String[] args) {
        ExecutorService executor= Executors.newFixedThreadPool(2);
        for(int i=0; i<5; i++){
            executor.submit(new ThreadPoolProcessor(i));
        }
        executor.shutdown();
        System.out.println("all tasks submitted");
        try {
            executor.awaitTermination(1, TimeUnit.DAYS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class ThreadPoolProcessor implements Runnable{
    private int id;
    public ThreadPoolProcessor(int id){
        this.id=id;
    }
    public void run(){
        System.out.println("started: "+id);
        try{
            Thread.sleep(5000);
        }catch (Exception ex){
            System.out.println(ex);
        }

        System.out.println("completed: "+id);
    }
}
