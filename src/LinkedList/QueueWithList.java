package LinkedList;

import java.util.LinkedList;

/**
 * Created by sumitachauhan on 6/18/17.
 */
public class QueueWithList<K> {
    private LinkedList<K> primary = new LinkedList<K>();
    private LinkedList<K> secondary = new LinkedList<K>();

    public void enqueue(K item){
        primary.push(item);
    }

    public K dequeue(){
        if(primary.isEmpty() && secondary.isEmpty())
            return null;
        if(secondary.isEmpty()){
            while(!primary.isEmpty()){
                secondary.push(primary.pop());
            }
        }
        return secondary.pop();
    }

}

class Test{
    public static void main(String[] args) {
        QueueWithList<Integer> queue = new QueueWithList<Integer>();
        int[] ar = {2,4,6,8,10};
        for(int i=0; i<ar.length; i++){
        queue.enqueue(ar[i]);
        }
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        queue.enqueue(20);
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
    }
}