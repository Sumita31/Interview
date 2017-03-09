package CrackingCodingInterview;

import java.util.Stack;

/**
 * Created by sumitachauhan on 2/17/17.
 */
public class MyQueueUsingStack<T> {
    Stack<T> stackMain = new Stack<>();
    Stack<T> tempStack = new Stack<>();

    public void enQueue(T item)
    {
        stackMain.push(item);
    }

    public T dequeue()
    {
        if(tempStack.isEmpty())
        {
            if(stackMain.isEmpty()) {
                System.out.println("Queue is empty.");
                return null;
            }
            else {
                while (!stackMain.isEmpty()) {
                    tempStack.push(stackMain.pop());
                }

            }
        }
        return tempStack.pop();
    }

    public static void main(String[] args) {
        MyQueueUsingStack myQ = new MyQueueUsingStack();
        System.out.println(myQ.dequeue());
        myQ.enQueue("Sumita");
        myQ.enQueue("chauhan");
        myQ.enQueue("Shoubhik");
        System.out.println(myQ.dequeue());
        System.out.println(myQ.dequeue());
        System.out.println(myQ.dequeue());
        System.out.println(myQ.dequeue());
    }
}
