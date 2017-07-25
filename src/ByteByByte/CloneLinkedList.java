package ByteByByte;

import com.sun.tools.doclets.formats.html.SourceToHTMLConverter;

import java.util.*;

/**
 * Created by sumitachauhan on 6/27/17.
 */
public class CloneLinkedList {
    //with additional space
    public Node cloneLL(Node input){

        Map<Node, Node> map=new HashMap<>();
        Node clone=new Node(input.data);

        Node originalRunner=input;
        Node cloneRunner=clone;

        while(originalRunner.next!=null){
            map.put(originalRunner,cloneRunner);
            cloneRunner.next=new Node(originalRunner.next.data);
            cloneRunner=cloneRunner.next;
            originalRunner=originalRunner.next;
        }
        map.put(originalRunner,cloneRunner);

        originalRunner=input;
        cloneRunner=clone;

        while(originalRunner!=null){
            cloneRunner.random = map.get(originalRunner.random);
            cloneRunner=cloneRunner.next;
            originalRunner=originalRunner.next;

        }
        return clone;
    }

    //without additional space
    public Node[] cloneWithoutSpaceLL(Node original){
        Node curr=original;
        while(curr!=null){
            Node n = new Node(curr.data);
            n.next=curr.next;
            curr.next=n;
            curr=curr.next.next;
        }

        curr=original;
        while(curr!=null){
            curr.next.random=curr.random.next;
            curr=curr.next.next;
        }

        curr=original;
        Node clone=curr.next;
        while(curr.next!=null){
            Node tmp = curr.next;
            curr.next = curr.next.next;
            curr = tmp;
        }
        Node[] res = {original,clone};
        return res;
    }

    public static void main(String[] args) {

        Node one=new Node(10);
        Node two=new Node(20);
        Node three=new Node(30);
        Node four=new Node(40);

        one.next=two; two.next=three; three.next=four;
        one.random=three; two.random=three; three.random=one; four.random=two;
        CloneLinkedList obj = new CloneLinkedList();

        Node n = obj.cloneLL(one);
        while (n != null) {
                System.out.print(n.data + ", ");
                System.out.print(n.random.data);
                System.out.println();
                n = n.next;
            }

//        Node[] res = obj.cloneWithoutSpaceLL(one);
//        for(Node n:res) {
//            while (n != null) {
//                System.out.print(n.data + ", ");
//                System.out.print(n.random.data);
//                System.out.println();
//                n = n.next;
//            }
//        }
    }
    private static class Node{
        int data;
        Node next;
        Node random;
        public Node(int data){
            this.data=data;
            this.next=null;
            this.random=null;
        }
    }
}


