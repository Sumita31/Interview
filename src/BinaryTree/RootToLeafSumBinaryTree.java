package BinaryTree;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by sumitachauhan on 3/8/17.
 */
public class RootToLeafSumBinaryTree {

    List<Integer> result = new ArrayList<>();
    public boolean findRootToLeafSum(BinaryTreeNode root, int sum)
    {
        if(root == null)
        {
            return false;
        }

        //Check for leaf node
        if(root.left == null && root.right == null)
        {
            if(root.nodeValue == sum)
            {
                result.add(root.nodeValue);
                return true;
            }
            else return false;
        }

        //Check for left subtree
        if(findRootToLeafSum(root.left, sum - root.nodeValue))
        {
            result.add(root.nodeValue);
            return true;
        }

        //Check for right subtree
        if(findRootToLeafSum(root.right, sum - root.nodeValue))
        {
            result.add(root.nodeValue);
            return true;
        }

        return false;
    }

    public static void main(String[] args) {

        BinaryTreeNode root = new BinaryTreeNode(20);
        BinaryTreeNode node1 = new BinaryTreeNode(10);
        BinaryTreeNode node2 = new BinaryTreeNode(15);
        BinaryTreeNode node3 = new BinaryTreeNode(25);
        BinaryTreeNode node4 = new BinaryTreeNode(30);
        BinaryTreeNode node5 = new BinaryTreeNode(7);

        root.left = node1;
        root.right = node3;
        node1.right = node2;
        node3.right = node4;
        node1.left = node5;

        RootToLeafSumBinaryTree obj = new RootToLeafSumBinaryTree();
        //System.out.println(obj.findRootToLeafSum(root, 20+25+30));

        System.out.println(obj.rootToleafSum(root, 20+25+30));
        Iterator i = obj.result.iterator();
//        while(i.hasNext()){
//            System.out.println(i.next());
//        }
    }

    public boolean rootToleafSum(BinaryTreeNode root, int sum){
        if(root==null)
            return false;
        if(root.nodeValue==sum) {
            return true;
        }
        return rootToleafSum(root.left, sum-root.nodeValue) || rootToleafSum(root.right, sum-root.nodeValue);
    }
}
