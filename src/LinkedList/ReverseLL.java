package LinkedList;


public class ReverseLL {
    public static void main(String[] args) {
        Node node1 = new Node(10);
        Node node2 = new Node(20);
        Node node3 = new Node(30);
        Node node4 = new Node(40);

        node1.next=node2;
        node2.next=node3;
        node3.next=node4;

        ReverseLL obj = new ReverseLL();
//        Node head = obj.reverseList(node1);
//        while(head!=null){
//            System.out.println(head.data);
//            head=head.next;
//        }

        Node head2 = obj.RLL(node1);
        while(head2!=null){
            System.out.println(head2.data);
            head2=head2.next;
        }
    }
    public Node reverseList(Node head){
        if(head == null || head.next==null)
            return head;

        Node prev = head;
        Node curr = prev.next;
        Node next = curr.next;
        prev.next = null;

        while(next != null){
            curr.next = prev;
            prev = curr;
            curr = next;
            next = next.next;
        }
        curr.next=prev;
        head=curr;
        return head;
    }

    public Node RLL(Node root){
        Node prev = root;
        Node curr = prev.next;
        Node next = curr.next;
        prev.next=null;

        while(curr.next!=null){
            curr.next=prev;
            prev=curr;
            curr=next;
            next=next.next;
        }
        curr.next=prev;
        root=curr;
        return root;
    }
}
