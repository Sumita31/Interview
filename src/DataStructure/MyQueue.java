package DataStructure;

import java.util.Stack;


public class MyQueue {
    Stack<Integer> mainStack ;
    Stack<Integer> tempStack ;

    public MyQueue()
    {
        mainStack = new Stack<>();
        tempStack = new Stack<>();
    }

    public void enQueue(int data)
    {
        mainStack.push(data);
    }

    public int deQueue()
    {
        if(!tempStack.isEmpty())
        {
            return tempStack.pop();
        }
        else
        {
            while(!mainStack.isEmpty())
            {
                tempStack.push(mainStack.pop());
            }
            return tempStack.pop();
        }
    }

    public int size()
    {
        return mainStack.size() + tempStack.size();
    }

    public static void main(String[] args) {
        MyQueue obj = new MyQueue();
        obj.enQueue(10);
        obj.enQueue(20);
        obj.enQueue(30);
        obj.enQueue(40);
        System.out.println(obj.deQueue());
        System.out.println(obj.deQueue());
        System.out.println(obj.deQueue());

    }
}
