package DataStructure;

/**
 * Created by sumitachauhan on 3/8/17.
 */
public class Stack {
    Node top;
    public int pop()
    {
        if(top!=null)
        {
            int data = top.data;
            top.next = top;
            return data;
        }
        return Integer.MIN_VALUE;
    }
    public void push(int data)
    {
        Node newNode = new Node(data);
        if(top==null)
            top=newNode;
        else
        {
            newNode.next = top;
            top = newNode;
        }
    }
}
