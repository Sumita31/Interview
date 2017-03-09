package LinkedList;


public class NthToLast {

    public Node nthToLast(Node head, int n)
    {
        if(head == null || n < 1)
            return head;
        Node p1= head;
        Node p2= head;
        for(int i=0; i<n-1; i++)
        {
            if(p2==null)
                return null;
            p2=p2.next;
        }
        while(p2.next!=null)
        {
            p1=p1.next;
            p2=p2.next;
        }
        return p1;
    }
}
