package DataStructure;

import java.util.Stack;


public class MyQueue<K> {
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
    public boolean isEmpty(){
        if(secondary.isEmpty() && primary.isEmpty())
            return true;
        else return false;
    }

    public void clear(){
        while(!primary.isEmpty()){
            primary.pop();
        }
        while(!secondary.isEmpty()){
            secondary.pop();
        }
    }


    public int size()
    {
        return primary.size() + secondary.size();

    }

    public static void main(String[] args) {
        MyQueue obj = new MyQueue();
        obj.enqueue(10);
        obj.enqueue(20);
        obj.enqueue(30);
        obj.enqueue(40);
        System.out.println(obj.dequeue());
        System.out.println(obj.dequeue());
        System.out.println(obj.dequeue());

    }
}

