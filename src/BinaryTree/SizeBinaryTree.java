package BinaryTree;

/**
 * Created by sumitachauhan on 3/8/17.
 */
public class SizeBinaryTree {
    public int findSize(BinaryTreeNode root)
    {
        if(root == null)
            return 0;
        int leftSize = findSize(root.left);
        int rightSize = findSize(root.right);
        return leftSize + rightSize +1;
    }
}
