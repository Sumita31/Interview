package BinaryTree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;


public class Traversal{

    public static void main(String[] args) {
        BinaryTreeNode root1 = new BinaryTreeNode(20);
        BinaryTreeNode node1 = new BinaryTreeNode(10);
        BinaryTreeNode node2 = new BinaryTreeNode(15);
        BinaryTreeNode node3 = new BinaryTreeNode(25);
        BinaryTreeNode node4 = new BinaryTreeNode(30);
        BinaryTreeNode node5 = new BinaryTreeNode(7);

        root1.left = node1;
        root1.right = node3;
        node1.right = node2;
        node3.right = node4;
        node1.left = node5;
        Traversal obj = new Traversal();
        obj.Reverse_levelOrderTreversal(root1);

    }

    public void Reverse_levelOrderTreversal(BinaryTreeNode root){
        Queue<BinaryTreeNode> q = new LinkedList<>();
        Stack<BinaryTreeNode> s = new Stack<>();
        q.add(root);
        while(!q.isEmpty()){
            BinaryTreeNode cur=q.poll();
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

    public void levelOrderTraversal(BinaryTreeNode root)
    {
        Queue<BinaryTreeNode> Q = new LinkedList<>();
        Q.add(root);

        while(!Q.isEmpty())
        {
            BinaryTreeNode temp = Q.poll();
            System.out.println(temp.nodeValue);
            if(temp.left != null)
                Q.add(temp.left);
            if(temp.right != null)
                Q.add(temp.right);
        }
    }

    public void inOrder(BinaryTreeNode root)
    {
        if(root!=null)
        {
            inOrder(root.left);
            System.out.println(root.nodeValue);
            inOrder(root.right);
        }
    }

    public void preOrder(BinaryTreeNode root)
    {
        if(root!=null)
        {
            System.out.println(root.nodeValue);
            preOrder(root.left);
            preOrder(root.right);
        }
    }

    public void postOrder(BinaryTreeNode root)
    {
        if(root!=null)
        {
            postOrder(root.left);
            postOrder(root.right);
            System.out.println(root.nodeValue);

        }
    }
}
