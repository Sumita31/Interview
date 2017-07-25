package BinaryTree;


public class HeightOfBinaryTree {

    public int findHeight(BTNode root)
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

        BTNode root = new BTNode(20);
        BTNode node1 = new BTNode(10);
        BTNode node2 = new BTNode(15);
        BTNode node3 = new BTNode(25);
        BTNode node4 = new BTNode(30);
        BTNode node5 = new BTNode(7);

        root.left = node1;
        root.right = node3;
        node1.right = node2;
        node3.right = node4;
        node1.left = node5;

        HeightOfBinaryTree obj = new HeightOfBinaryTree();

        System.out.println(obj.findHeight(root));
    }

}
