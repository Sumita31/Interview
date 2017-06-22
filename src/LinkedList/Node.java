package LinkedList;

/**
 * Created by sumitachauhan on 3/8/17.
 */
public class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data=data;
        this.next=null;
    }

    public int getVal(){
        return this.data;
    }
    public void setNext(Node nextNode){
        this.next=nextNode;
    }

    public Node getNext(){
        return this.next;
    }
}
