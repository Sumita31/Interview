package LinkedList;


public class CircularLinkedList {

    //Hare & Tortoise Algorithm
    public Node isCircular(Node head)
    {
        if(head==null)
            return null;

        Node n1=head;
        Node n2=head;

        while(n2.next!=null)
        {
            n1=n1.next;
            n2=n2.next.next;
            if(n1==n2)
                break;
        }

        if(n2==null)
            return null;

        n1=head;
        while(n1!=n2)
        {
            n1=n1.next;
            n2=n2.next;
        }
        return n2;
    }

}
