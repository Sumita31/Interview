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

        BTNode root = new BTNode(20);
        BTNode node1= new BTNode(10);
        BTNode node2= new BTNode(15);
        BTNode node3= new BTNode(25);
        BTNode node4= new BTNode(30);
        BTNode node5= new BTNode(7);

        root.left=node1;
        root.right=node3;
        node1.right=node2;
        node3.right=node4;
        node1.left=node5;

        IsBST obj = new IsBST();
        System.out.println(obj.isBSTRecursive(root));
        boolean isbinaryTree=true;
        obj.inOrderTraversal(root);
        for(int k=0; k<elements.size()-1; k++){
            if(elements.get(k)>elements.get(k+1)) {
                isbinaryTree = false;
                break;
            }
        }
        Iterator i = elements.iterator();
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

    public void inOrderTraversal(BTNode root)
    {
        if(root != null)
        {
        inOrderTraversal(root.left);
        elements.add(root.nodeValue);
        inOrderTraversal(root.right);
        }

    }

    public boolean isBSTRecursive(BTNode root)
    {
        return isBSTRecursive(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    public boolean isBSTRecursive(BTNode node, int min, int max)
    {
        if(node == null)
            return true;

        if(node.nodeValue <= min || node.nodeValue > max)
            return false;

        return isBSTRecursive(node.left, min, node.nodeValue) && isBSTRecursive(node.right, node.nodeValue, max);
    }
}
