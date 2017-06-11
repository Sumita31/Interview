package Thread;


import java.util.concurrent.*;

public class Application2 {
    public static void main(String[] args) {

        //Thread pool is like workers in a factory, in our case its 2.
        ExecutorService executor = Executors.newFixedThreadPool(2);

        for(int i=0; i<5; i++){
            executor.submit(new Processor2(i));
        }

        executor.shutdown();

        System.out.println("All tasks submitted");

        try {
            executor.awaitTermination(1, TimeUnit.DAYS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class Processor2 implements Runnable{
    private int id;
    public Processor2(int id){
        this.id=id;
    }
    public void run(){
        System.out.println("Starting: " +id);
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Completed: "+id);
    }
}
