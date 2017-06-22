package LinkedList;

public class NodeWIthPrivate {

    private int data;
    private NodeWIthPrivate next;

    public NodeWIthPrivate(int data) {
        this.data=data;
        this.next=null;
    }

    public int getVal(){
        return this.data;
    }
    public void setNext(NodeWIthPrivate nextNode){
        this.next=nextNode;
    }

    public NodeWIthPrivate getNext(){
        return this.next;
    }
}
