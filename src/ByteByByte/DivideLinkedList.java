package ByteByByte;

import CareerCup.*;

import java.util.LinkedList;
import java.util.List;

public class DivideLinkedList {
    public List<Node> divide(Node list){
        LinkedList<Node> res=new LinkedList<>();
        if(list==null) {
            return res;
        }
        Node first=list;
        Node second=list.next;
        while(second!=null){
            second=second.next;
            if(second==null)
                break;
            first=first.next;
            second=second.next;
        }
        if(first.next!=null) {
            res.add(first.next);
            first.next = null;
        }
        res.add(list);
        return res;
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
        DivideLinkedList obj = new DivideLinkedList();
        List<Node> res= obj.divide(head);
        for(Node n:res){
            while(n!=null){
                System.out.print(n.data+"->");
                n=n.next;
            }
            System.out.println();
        }
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
