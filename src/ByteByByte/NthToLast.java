package ByteByByte;

/**
 * Created by sumitachauhan on 7/19/17.
 */
public class NthToLast {
    public int nthToLast(Node list, int n){
        Node size=list;
        int listSize=0;
        while(size!=null){
            size=size.next;
            listSize++;
        }
        if(listSize<n || list==null)
            throw new IllegalArgumentException("list is empty or position is greater than the list size");

        Node first=list;
        Node runner=list;
        while(n!=0){
            runner=runner.next;
            n--;
        }
        while(runner.next!=null){
            first=first.next;
            runner=runner.next;
        }
        return first.data;
    }

    public static void main(String[] args) {
        Node head=new Node(10);
        Node node2=new Node(20);
        Node node3=new Node(30);
        Node node4=new Node(40);
        Node node5=new Node(50);
        Node node6=new Node(60);
        head.next=node2;
        node2.next=node3;
        node3.next=node4;
        node4.next=node5;
        node5.next=node6;
        NthToLast obj = new NthToLast();
        System.out.println(obj.nthToLast(null, 10));
    }
    private static class Node{
        Node next;
        int data;
        public Node(int data){
            this.data=data;
            this.next=null;
        }
        public String toString(){
            return data + ":";
        }
    }
}
