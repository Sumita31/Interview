package HackerRank;


import java.util.*;

public class TaleOf2Stacks {
    public static void main(String[] args) {
        MyQueue<Integer> queue = new MyQueue<Integer>();

        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();

        for (int i = 0; i < n; i++) {
            int operation = scan.nextInt();
            if (operation == 1) { // enqueue
                queue.enqueue(scan.nextInt());
            } else if (operation == 2) { // dequeue
                queue.dequeue();
            } else if (operation == 3) { // print/peek
                System.out.println(queue.peek());
            }
        }
        scan.close();
    }
}

class MyQueue<K>{
    Stack<K> primary = new Stack<>();
    Stack<K> secondary = new Stack<>();

    public void enqueue(K val){
        primary.push(val);
    }

    public K dequeue(){
        performCheck();
        return secondary.pop();
    }
    public K peek(){
        performCheck();
        return secondary.peek();
    }
    private void performCheck(){
        if(secondary.isEmpty() && !primary.isEmpty()){
            while(!primary.isEmpty()){
                secondary.push(primary.pop());
            }
        }
    }
}
