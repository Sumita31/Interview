package ByteByByte;


public class MaxStack {
    private Node stack;
    public void push(int element){
        Node n=new Node(element);
        if(stack==null){
            stack=n;
            stack.max=element;
        }
        else{
            n.next=stack;
            n.max=Math.max(stack.max,element);
            stack=n;
        }
    }
    public int pop(){
        if(stack==null){
            throw new NullPointerException("stack is empty.");
        }
        int res=stack.val;
        stack=stack.next;
        return res;
    }
    public int maxInStack(){
        if(stack==null){
            throw new NullPointerException("stack is empty.");
        }
        return stack.max;
    }
    private class Node{
        private int val;
        private Node next;
        private int max;
        public Node(int value){
            this.val=value;
            this.next=null;
        }
    }

    public static void main(String[] args) {
        MaxStack obj = new MaxStack();
        obj.push(10);
        obj.push(20);
        obj.push(15);
        obj.push(40);
        obj.push(1);
        System.out.println(obj.maxInStack());
        System.out.println(obj.pop());
        System.out.println(obj.maxInStack());
        System.out.println(obj.pop());
        System.out.println(obj.maxInStack());
        obj.push(100);
        System.out.println(obj.maxInStack());
        System.out.println(obj.pop());
        System.out.println(obj.pop());
        System.out.println(obj.maxInStack());
        System.out.println(obj.pop());
        System.out.println(obj.maxInStack());
    }
}
