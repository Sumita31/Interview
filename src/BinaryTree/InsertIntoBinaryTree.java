package BinaryTree;

/**
 * Created by sumitachauhan on 3/8/17.
 */
public class InsertIntoBinaryTree {

    public BinaryTreeNode insertNode(BinaryTreeNode root, int data)
    {
        BinaryTreeNode node = new BinaryTreeNode(data);
        if(root == null)
            return node;
        BinaryTreeNode parent = null, current = root;
        while(current!= null)
        {
            parent = current;
            if(current.nodeValue<=data)
            {
                current = current.right;
            }
            else current = current.left;
        }
        if(parent.nodeValue>data)
            parent.left = node;
        else parent.right = node;

        return root;
    }
}
