package Thread;

public class UnsafeUseOfThreads{

    private final static class Unsafe{
        public int getState(){
            return state;
        }

        public  void setState(int state){
            synchronized (this) {
                this.state = state;
            }
        }

        private int state;
    }

    private final static class MyThread extends Thread{
        private final UnsafeUseOfThreads.Unsafe unsafe;
        private final int setVal;

        private MyThread(UnsafeUseOfThreads.Unsafe unsafe, int setVal){
            this.unsafe = unsafe;
            this.setVal = setVal;
        }

        public void run() {
            unsafe.setState(setVal);
        }
    }

    public static void main(String[] args){
        UnsafeUseOfThreads.Unsafe unsafe = new UnsafeUseOfThreads.Unsafe ();
        unsafe.setState (5);
        for(int i = 0; i < 100; i++) {
            Thread t1 = new UnsafeUseOfThreads.MyThread (unsafe, 10);
            Thread t2 = new UnsafeUseOfThreads.MyThread (unsafe, 12);
            t1.start ();
            t2.start ();
        }
        System.out.println(unsafe.getState( ));
    }
}
