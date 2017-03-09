package BinaryTree;

import java.util.LinkedList;
import java.util.Queue;


public class Traversal{

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
