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
    public static void main(String[] args) {
        Node head1= new Node(10);
        Node n2= new Node(20);
        Node n3= new Node(30);
        Node n4= new Node(40);
        Node n5= new Node(50);

        head1.next=n2;
        n2.next=n3;
        n3.next=n4;
        n4.next=n5;
        NthToLast obj = new NthToLast();
        Node res = obj.nthToLast(head1,3);
        System.out.println(res.data);
    }
}
