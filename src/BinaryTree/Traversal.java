package BinaryTree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;


public class Traversal{

    public static void main(String[] args) {
        BTNode root1 = new BTNode(20);
        BTNode node1 = new BTNode(10);
        BTNode node2 = new BTNode(15);
        BTNode node3 = new BTNode(25);
        BTNode node4 = new BTNode(30);
        BTNode node5 = new BTNode(7);

        root1.left = node1;
        root1.right = node3;
        node1.right = node2;
        node3.right = node4;
        node1.left = node5;
        Traversal obj = new Traversal();
        obj.Reverse_levelOrderTreversal(root1);

    }

    public void Reverse_levelOrderTreversal(BTNode root){
        Queue<BTNode> q = new LinkedList<>();
        Stack<BTNode> s = new Stack<>();
        q.add(root);
        while(!q.isEmpty()){
            BTNode cur=q.poll();
            if(cur.right!=null)
                q.add(cur.right);
            if(cur.left!=null)
                q.add(cur.left);
            s.push(cur);
        }

        while(!s.isEmpty()){
            System.out.print(s.pop().nodeValue + ", ");
        }
    }

    public void levelOrderTraversal(BTNode root)
    {
        Queue<BTNode> Q = new LinkedList<>();
        Q.add(root);

        while(!Q.isEmpty())
        {
            BTNode temp = Q.poll();
            System.out.println(temp.nodeValue);
            if(temp.left != null)
                Q.add(temp.left);
            if(temp.right != null)
                Q.add(temp.right);
        }
    }

    public void inOrder(BTNode root)
    {
        if(root!=null)
        {
            inOrder(root.left);
            System.out.print(root.nodeValue+", ");
            inOrder(root.right);
        }
    }

    public void preOrder(BTNode root)
    {
        if(root!=null)
        {
            System.out.println(root.nodeValue);
            preOrder(root.left);
            preOrder(root.right);
        }
    }

    public void postOrder(BTNode root)
    {
        if(root!=null)
        {
            postOrder(root.left);
            postOrder(root.right);
            System.out.println(root.nodeValue);

        }
    }
}
