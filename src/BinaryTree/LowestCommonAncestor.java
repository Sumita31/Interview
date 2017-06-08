package BinaryTree;

/**
 * Created by sumitachauhan on 3/8/17.
 */
public class LowestCommonAncestor {

    public BinaryTreeNode findLowestCommonAncestor(BinaryTreeNode root, int val1, int val2){
        if(root == null)
            return root;
        BinaryTreeNode curr = root;
        if(curr.nodeValue==val1 || curr.nodeValue==val2){
           return curr;
        }
        else if(curr.nodeValue>val1 && curr.nodeValue<val2){
            return curr;
        }
        else if(curr.nodeValue>val1 && curr.nodeValue>val2){
            return findLowestCommonAncestor(curr.left,val1,val2);
        }
        else if(curr.nodeValue<val1 && curr.nodeValue<val2){
            return findLowestCommonAncestor(curr.right,val1,val2);
        }
        return root;
    }
    //Tushar's method of finding lowest common ancestor in binary SEARCH tree
    public BinaryTreeNode findLCA(BinaryTreeNode root, int firstVal, int secondVal){
        if(root==null)
            return root;
        if(root.nodeValue > Math.max(firstVal,secondVal))
            return findLCA(root.left,firstVal,secondVal);
        else if(root.nodeValue<Math.min(firstVal,secondVal))
            return findLCA(root.right,firstVal,secondVal);
        else return root;
    }

    //recursive method to find lowest common ancestor in binary tree
    public  BinaryTreeNode findLCABT(BinaryTreeNode root, int firstVal, int secondVal){
        if(root==null)
            return root;
        if(root.nodeValue==firstVal || root.nodeValue==secondVal)
            return root;
        BinaryTreeNode left = findLCABT(root.left,firstVal,secondVal);
        BinaryTreeNode right = findLCABT(root.right,firstVal,secondVal);
        if(left!=null && right!=null)
            return root;
        else if(left==null&& right==null)
            return null;
        else return left!=null?left:right;
    }

    public static void main(String[] args){
        BinaryTreeNode root = new BinaryTreeNode(3);
        BinaryTreeNode node1 = new BinaryTreeNode(10);
        BinaryTreeNode node2 = new BinaryTreeNode(2);
        BinaryTreeNode node3 = new BinaryTreeNode(20);
        BinaryTreeNode node4 = new BinaryTreeNode(1);
        BinaryTreeNode node5 = new BinaryTreeNode(11);

        root.left = node1;
        root.right = node3;
        node1.right = node2;
        node3.right = node4;
        node1.left = node5;

        LowestCommonAncestor obj = new LowestCommonAncestor();
        BinaryTreeNode res = obj.findLowestCommonAncestor(root, 10,15);
        System.out.println(res.nodeValue + " my method for LCA in Binary Search Tree");

        res = obj.findLCA(root, 10,15);
        System.out.println(res.nodeValue + " tushar's method for LCA in Binary Search Tree");

        res = obj.findLCABT(root, 10,20);
        System.out.println(res.nodeValue + " LCA in Binary Tree ");
    }
}
