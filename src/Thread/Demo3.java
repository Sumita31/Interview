package Thread;

//Keyword Synchronized
public class Demo3 {
    private int count;

    /*volatile keyword won't solve the problem here because its not just caching problem
    only one thread can acquire intrinsic lock at a time and runs this method.
    Other thread waits for this lock to get free
    */
    public synchronized void increment(){
        count++;
    }

    public static void main(String[] args) {
        Demo3 obj = new Demo3();
        obj.doSomeWork();
    }

    public void doSomeWork() {
        Thread t1 = new Thread(new Runnable() {
            public void run() {
                for(int i=0; i<10000; i++){
                    increment();
                }
            }
        });

        Thread t2 = new Thread(new Runnable() {
            public void run() {
                for(int i=0; i<10000; i++){
                    increment();
                }
            }
        });

        t1.start();
        t2.start();
        /*
        To wait for the threads to finish before we display the count value
         */
        try {
            t2.join();
            t1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(count);
    }
}
