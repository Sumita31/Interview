package BinaryTree;

/**
 * Created by sumitachauhan on 3/8/17.
 */
public class SearchInBinaryTree {

    public BinaryTreeNode findElement(BinaryTreeNode root, int key)
    {
        if(root == null)
            return null;
        if(root.nodeValue == key)
            return root;
        else if(root.nodeValue > key)
            return findElement(root.left, key);
        else
            return findElement(root.right, key);

    }

}
