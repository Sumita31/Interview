package Miscellaneous;

/**
 * Created by sumitachauhan on 5/5/17.
 */
public class ImplementStack {

    public static void main(String[] args) {

        Node<String> first = new Node<>("sumita");
        StackI<String> obj = new StackI<>();
        obj.push(first);
        Node second = new Node<>("chauhan");
        Node third = new Node<>(18);
        obj.push(second);
        obj.push(third);
        obj.getProperty();
        System.out.println("pop: " + obj.pop().data);
        System.out.println("pop: " + obj.pop().data);
    }
}

class StackI<T>{
    Node<T> top;
    int noOfItems = 0;
    //get the top element
    public Node pop(){
        if(top!=null){
            Node toPop = top;
            top=top.next;
            toPop.next = null;
            return toPop;
        }
        noOfItems--;
        return null;
    }
    //insert an element at the top
    public void push(Node<T> item){
        if(top!=null){
            item.next=top;
            top = item;

        }
        else top = item;
        noOfItems++;
    }
    public void getProperty(){
        int[] len = new int[noOfItems];
        int counter=0;
        Node forProp = top;
        while(forProp != null){
            len[counter] = forProp.data.toString().length();
            forProp = forProp.next;
            counter++;
        }
        int largest=Integer.MIN_VALUE;
        for(int i=0; i<noOfItems; i++){
            if(len[i]>largest)
                largest=len[i];
        }
        System.out.println(largest);

    }
}

class Node<T>{
    Node next;
    T data;
    public Node(T item){
        this.data=item;
        this.next=null;
    }
}