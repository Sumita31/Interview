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
}
