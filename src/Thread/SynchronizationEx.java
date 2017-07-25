package Thread;

/**
 * Created by sumitachauhan on 7/22/17.
 */
public class SynchronizationEx {
    public int count=0;
    //with synchronization only one thread gets intrinsic lock on the object
    public synchronized void increment(){
        count++;
    }

    public static void main(String[] args) {
        SynchronizationEx obj = new SynchronizationEx();
        Thread t1=new Thread(new Runnable() {
            public void run() {
                for(int i=0; i<10000; i++){
                    obj.increment();
                }
            }
        });

        Thread t2=new Thread(new Runnable() {
            public void run() {
                for(int i=0; i<10000; i++){
                    obj.increment();
                }
            }
        });
        t1.start();
        t2.start();
        try {
            t1.join();
            t2.join();
        }
        catch (InterruptedException ex){
            System.out.println(ex);
        }
        System.out.println(obj.count);

    }
}
