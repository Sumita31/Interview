package Thread;


import java.util.Scanner;

public class Demo2 {

    public static void main(String[] args) {
        /*
        Main method has its own thread - so basically two threads are running
        Both threads are accessing the same variable 'running'
         */
        Processor proc1 = new Processor();
        proc1.start();
        System.out.println("Hit any key to stop.");
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();
        proc1.shutdown();
    }
}


class Processor extends Thread{
    private volatile boolean running = true;

    public void run(){
        /*
        without volatile keyword this method may cahce the value of 'running'
        and never stop even though we call shutdown function to make running = false.
        */
        while(running){
            System.out.println("Inside while loop.");
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void shutdown(){
        running=false;
    }
}