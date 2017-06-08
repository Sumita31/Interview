package BinaryTree;

/**
 * Created by sumitachauhan on 3/8/17.
 */
public class SameBinaryTree {
    public boolean findIfSameTree(BinaryTreeNode root1, BinaryTreeNode root2)
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

        BinaryTreeNode root2 = new BinaryTreeNode(20);
        BinaryTreeNode node12 = new BinaryTreeNode(10);
        BinaryTreeNode node22 = new BinaryTreeNode(15);
        BinaryTreeNode node32 = new BinaryTreeNode(25);
        BinaryTreeNode node42 = new BinaryTreeNode(30);
        BinaryTreeNode node52 = new BinaryTreeNode(8);

        root2.left = node12;
        root2.right = node32;
        node12.right = node22;
        node32.right = node42;
        node12.left = node52;

        SameBinaryTree obj = new SameBinaryTree();
        System.out.println(obj.findIfSameTree(root1, root2));

    }
}
