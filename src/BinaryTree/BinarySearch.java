package BinaryTree;

/**
 * Created by sumitachauhan on 7/3/17.
 */
public class BinarySearch {
    public boolean findElement(BTNode root, int val){
        if(root==null)
            return false;
        if(root.nodeValue==val)
            return true;
        if(root.nodeValue>val){
            return findElement(root.left, val);
        }
        else if(root.nodeValue<val){
            return findElement(root.right, val);
        }
        return false;
    }

    public static void main(String[] args) {
        BTNode root = new BTNode(20);
        BTNode node1 = new BTNode(10);
        BTNode node2 = new BTNode(15);
        BTNode node3 = new BTNode(25);
        BTNode node4 = new BTNode(30);
        BTNode node5 = new BTNode(7);
        BTNode node6 = new BTNode(23);
        BTNode node7 = new BTNode(22);
        BTNode node8 = new BTNode(40);
        BTNode node9 = new BTNode(28);

        root.left = node1;
        root.right = node3;
        node1.right = node2;
        node3.right = node4;
        node1.left = node5;
        node3.left=node6;
        node6.left=node7;
        node4.left=node9;
        node4.right=node8;
        BinarySearch obj=new BinarySearch();
        System.out.println(obj.findElement(root, 7));
    }
}
