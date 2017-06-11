package Thread;

/*
How locks work on multiple threads
 */
public class Application1 {
    public static void main(String[] args) {
        Worker t1 = new Worker();
        t1.main();
    }
}
