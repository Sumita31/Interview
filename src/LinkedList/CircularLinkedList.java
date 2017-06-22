package LinkedList;


public class CircularLinkedList {

    //Hare & Tortoise Algorithm
    public NodeWIthPrivate isCircular(NodeWIthPrivate head)
    {
        if(head==null)
            return null;

        NodeWIthPrivate n1=head;
        NodeWIthPrivate n2=head;

        while(n2.getNext().getNext()!=null)
        {
            n1=n1.getNext();
            n2=n2.getNext().getNext();
            if(n1==n2)
                break;
        }

        if(n2.getNext().getNext()==null)
            return null;

        n1=head;
        while(n1!=n2)
        {
            n1=n1.getNext();
            n2=n2.getNext();
        }
        return n2;
    }

}

class TestCircular{
    public static void main(String[] args) {
        NodeWIthPrivate head1= new NodeWIthPrivate(10);
        NodeWIthPrivate n2= new NodeWIthPrivate(20);
        NodeWIthPrivate n3= new NodeWIthPrivate(30);
        NodeWIthPrivate n4= new NodeWIthPrivate(40);

         head1.setNext(n2);
         n2.setNext(n3);
         n3.setNext(n4);
//         n4.setNext(n2);
         CircularLinkedList obj = new CircularLinkedList();
        NodeWIthPrivate res = obj.isCircular(head1);
         if(res!=null){
             System.out.println(res.getVal());
         }else System.out.println("not circular");
    }
}
