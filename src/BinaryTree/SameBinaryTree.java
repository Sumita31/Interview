package BinaryTree;

/**
 * Created by sumitachauhan on 3/8/17.
 */
public class SameBinaryTree {
    public boolean findIfSameTree(BTNode root1, BTNode root2)
    {
        if(root1 == null && root2 == null)
            return true;
        if(root1 == null || root2 == null)
            return false;

        return (root1.nodeValue == root2.nodeValue)
                && findIfSameTree(root1.left, root2.left)
                && findIfSameTree(root1.right, root2.right);
    }

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

        BTNode root2 = new BTNode(20);
        BTNode node12 = new BTNode(10);
        BTNode node22 = new BTNode(15);
        BTNode node32 = new BTNode(25);
        BTNode node42 = new BTNode(30);
        BTNode node52 = new BTNode(8);

        root2.left = node12;
        root2.right = node32;
        node12.right = node22;
        node32.right = node42;
        node12.left = node52;

        SameBinaryTree obj = new SameBinaryTree();
        System.out.println(obj.findIfSameTree(root1, root2));

    }
}
