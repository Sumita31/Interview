package ByteByByte;

import java.util.HashSet;
import java.util.Set;
import java.util.Objects;

/**
 * Created by sumitachauhan on 7/19/17.
 */
public class CircularLinkedList {
    public boolean isCircular(Node head){
        Node first=head;
        Node second=head;
        while(second!=null){
            second=second.next;
            if(second!=null){
                first=first.next;
                second=second.next;
            }
            if(first==second) return true;
        }
        return false;
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
        node6.next=node6;
        CircularLinkedList obj = new CircularLinkedList();
        System.out.println(obj.isCircular(head));
        System.out.println(obj.isCircularll(head));
    }

    public boolean isCircularll(Node head){
        Set<Node> nodeSet=new HashSet<>();
        for(Node curr=head; curr!=null; curr=curr.next){
            if(nodeSet.contains(curr))
                return true;
            else nodeSet.add(curr);
        }
        return false;
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

        public int hashCode() {

            return Objects.hash(data);
        }

        public boolean equals(Object o) {
            if(o == null || !(o instanceof Node)) {
                return false;
            }
            Node that = ((Node) o);
            return this.data == that.data;
        }
    }
}
