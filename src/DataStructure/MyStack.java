package DataStructure;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by sumitachauhan on 6/23/17.
 */
public class MyStack {
    private Queue<Integer> primary = new LinkedList<>();
    private Queue<Integer> secondary = new LinkedList<>();
    public MyStack(){
        ;
    }
    public void push(int item){
        if(item>Integer.MAX_VALUE || item<Integer.MIN_VALUE)
            throw new IllegalArgumentException("not a valid integer value");
        secondary.add(item);
        while(!primary.isEmpty()){
            secondary.add(primary.remove());
        }
        Queue<Integer> temp=primary;
        primary=secondary;
        secondary=temp;
    }

    public int pop(){
       if(!primary.isEmpty()){
           return primary.remove();
       }
       else throw new ArrayIndexOutOfBoundsException("list is empty");
    }

    public static void main(String[] args) {
        MyStack obj = new MyStack();
        obj.push(1);
        obj.push(2);
        obj.push(3);
        System.out.println(obj.pop());
        System.out.println(obj.pop());
        System.out.println(obj.pop());
        //System.out.println(obj.pop());
    }
}
