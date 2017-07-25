package Amazon;


public class CloneRandomLL {
    public Node clone(Node head){
        if(head==null) return head;
        Node curr=head;
        while(curr!=null){
            Node temp=new Node(curr.data);
            temp.next=curr.next;
            curr.next=temp;
            curr=curr.next.next;
        }
        curr=head;
        while(curr!=null){
            curr.next.random=curr.random.next;
            curr=curr.next.next;
        }
        Node copy= head.next;
        curr=head;
        while(curr.next!=null){
            Node tmp = curr.next;
            curr.next = curr.next.next;
            curr = tmp;
        }
        return copy;
    }

    public static void main(String[] args) {
        Node one=new Node(10);
        Node two=new Node(20);
        Node three=new Node(30);
        Node four=new Node(40);

        one.next=two; two.next=three; three.next=four;
        one.random=three; two.random=three; three.random=one; four.random=two;
        CloneRandomLL obj = new CloneRandomLL();

        Node n = obj.clone(one);
        while (n != null) {
            System.out.print(n.data + ", ");
            System.out.print(n.random.data);
            System.out.println();
            n = n.next;
        }
    }
    private static class Node{
        Node next;
        Node random;
        int data;
        public Node(int data){
            this.data=data;
        }
    }
}
