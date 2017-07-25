package ByteByByte;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by sumitachauhan on 7/21/17.
 */
public class DeleteDuplicateLL {
    public void deldup(Node head){
        while(head!=null){
            Node curr=head;
            while(curr.next!=null){
                if(curr.next.data==head.data){
                    curr.next=curr.next.next;
                }
                else
                    curr=curr.next;
            }
            head=head.next;
        }
    }

    public void dedup(Node head){
        if(head==null) return;
        Set<Integer> nodes=new HashSet<>();
        Node prev=null;
        while(head!=null){
            if(nodes.contains(head.data)){
                prev.next=head.next;
            }
            else prev=head;
            head=head.next;
        }
    }

    public static void main(String[] args) {
        Node head=new Node(10);
        Node node2=new Node(20);
        Node node3=new Node(20);
        Node node4=new Node(40);
        Node node5=new Node(50);
        Node node6=new Node(10);
        head.next=node2;
        node2.next=node3;
        node3.next=node4;
        node4.next=node5;
        node5.next=node6;
        DeleteDuplicateLL obj = new DeleteDuplicateLL();
        obj.deldup(head);
        Node temp=head;
        while(temp!=null){
            System.out.println(temp.data);
            temp=temp.next;
        }
        obj.dedup(head);
        temp=head;
        while(temp!=null){
            System.out.println(temp.data);
            temp=temp.next;
        }
    }
    private static class Node{
        int data;
        Node next;
        public Node(int data){
            this.data=data;
            this.next=null;
        }
        public String toString(){
            return this.data+" ";
        }
    }
}
