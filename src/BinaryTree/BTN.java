package BinaryTree;

public class BTN {
    private BTN left;
    private BTN right;
    private int data;

    public BTN(int val){
        this.data=val;
        this.left=null;
        this.right=null;
    }

    public void setLeft(BTN node){
        this.left=node;
    }
    public BTN getLeft(){
        return this.left;
    }
    public void setRight(BTN node){
        this.right=node;
    }
    public BTN getRight(){
        return this.right;
    }
    public int getData(){
        return this.data;
    }

}
