package BinaryTree;


public class HeightOfBinaryTree {

    public int findHeight(BinaryTreeNode root)
    {
        //Counting number of nodes in the longest path - from node to leaf node
//        if(root == null)
//            return 0;
//        int leftHeight = findHeight(root.left);
//        int rightHeight = findHeight(root.right);
//        return leftHeight >= rightHeight ? leftHeight +1 : rightHeight +1;

        //Counting edges in the longest path - from root to leaf node
        if(root==null)
            return -1;
        return Math.max(findHeight(root.left), findHeight(root.right))+1;
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

        HeightOfBinaryTree obj = new HeightOfBinaryTree();

        System.out.println(obj.findHeight(root));
    }

}
