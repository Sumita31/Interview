package BinaryTree;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by sumitachauhan on 3/8/17.
 */
public class IsBST {
    private static List<Integer> elements = new ArrayList<>();
    public static void main(String[] args) {

        BinaryTreeNode root = new BinaryTreeNode(20);
        BinaryTreeNode node1= new BinaryTreeNode(10);
        BinaryTreeNode node2= new BinaryTreeNode(15);
        BinaryTreeNode node3= new BinaryTreeNode(25);
        BinaryTreeNode node4= new BinaryTreeNode(30);
        BinaryTreeNode node5= new BinaryTreeNode(7);

        root.left=node1;
        root.right=node3;
        node1.right=node2;
        node3.right=node4;
        node1.left=node5;

        IsBST obj = new IsBST();
        System.out.println(obj.isBSTRecursive(root));

        obj.inOrderTraversal(root);
        Iterator i = elements.iterator();
        boolean isbinaryTree=true;
        while(i.hasNext())
        {
            int a = (int) i.next();
            int b = (int) i.next();
            if(a>b) {
                isbinaryTree=false;
                break;
            }
        }
        System.out.println(isbinaryTree);
    }

    public void inOrderTraversal(BinaryTreeNode root)
    {
        if(root != null)
        {
        inOrderTraversal(root.left);
        elements.add(root.nodeValue);
        inOrderTraversal(root.right);
        }

    }

    public boolean isBSTRecursive(BinaryTreeNode root)
    {
        return isBSTRecursive(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    public boolean isBSTRecursive(BinaryTreeNode node, int min, int max)
    {
        if(node == null)
            return true;

        if(node.nodeValue <= min || node.nodeValue > max)
            return false;

        return isBSTRecursive(node.left, min, node.nodeValue) && isBSTRecursive(node.right, node.nodeValue, max);
    }
}
