package BinaryTree;

/**
 * Created by sumitachauhan on 3/8/17.
 */
public class LowestCommonAncestor {

    public BTNode findLowestCommonAncestor(BTNode root, int val1, int val2){
        if(root == null)
            return root;
        BTNode curr = root;
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
    public BTNode findLCA(BTNode root, int firstVal, int secondVal){
        if(root==null)
            return root;
        if(root.nodeValue > Math.max(firstVal,secondVal))
            return findLCA(root.left,firstVal,secondVal);
        else if(root.nodeValue<Math.min(firstVal,secondVal))
            return findLCA(root.right,firstVal,secondVal);
        else return root;
    }

    //recursive method to find lowest common ancestor in binary tree
    public BTNode findLCABT(BTNode root, int firstVal, int secondVal){
        if(root==null)
            return root;
        if(root.nodeValue==firstVal || root.nodeValue==secondVal)
            return root;
        BTNode left = findLCABT(root.left,firstVal,secondVal);
        BTNode right = findLCABT(root.right,firstVal,secondVal);
        if(left!=null && right!=null)
            return root;
        else if(left==null&& right==null)
            return null;
        else return left!=null?left:right;
    }

    public static void main(String[] args){
        BTNode root = new BTNode(3);
        BTNode node1 = new BTNode(10);
        BTNode node2 = new BTNode(2);
        BTNode node3 = new BTNode(20);
        BTNode node4 = new BTNode(1);
        BTNode node5 = new BTNode(11);

        root.left = node1;
        root.right = node3;
        node1.right = node2;
        node3.right = node4;
        node1.left = node5;

        LowestCommonAncestor obj = new LowestCommonAncestor();
        BTNode res = obj.findLowestCommonAncestor(root, 10,15);
        System.out.println(res.nodeValue + " my method for LCA in Binary Search Tree");

        res = obj.findLCA(root, 10,15);
        System.out.println(res.nodeValue + " tushar's method for LCA in Binary Search Tree");

        res = obj.findLCABT(root, 10,20);
        System.out.println(res.nodeValue + " LCA in Binary Tree ");
    }
}
