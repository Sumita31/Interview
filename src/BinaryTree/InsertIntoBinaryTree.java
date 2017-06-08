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

    public BinaryTreeNode insertNodeBT(BinaryTreeNode root, int data){
       if(root == null)
           return root;
       BinaryTreeNode next=root;
       BinaryTreeNode newNode=new BinaryTreeNode(data);
       while(next.nodeValue>=data && next.left!=null){
           next=next.left;
       }
        while(next.nodeValue<data && next.right!=null){
            next=next.right;
        }
       if(next.nodeValue>=data){
            next.left=newNode;
       }
       else if(next.nodeValue<data){
           next.right=newNode;
       }
       return root;
    }

    public void inOrderT(BinaryTreeNode root){
        if(root==null)
        return;
        inOrderT(root.left);
        System.out.print(root.nodeValue+", ");
        inOrderT(root.right);
    }

    public static void main(String[] args) {
        BinaryTreeNode root = new BinaryTreeNode(20);
        BinaryTreeNode node1 = new BinaryTreeNode(10);
        BinaryTreeNode node2 = new BinaryTreeNode(15);
        BinaryTreeNode node3 = new BinaryTreeNode(25);
        BinaryTreeNode node4 = new BinaryTreeNode(30);
        BinaryTreeNode node5 = new BinaryTreeNode(7);

        root.left = node1; //10
        root.right = node3; //25
        node1.right = node2; //15
        node3.right = node4; //30
        node1.left = node5; //7

        InsertIntoBinaryTree obj = new InsertIntoBinaryTree();
        obj.insertNodeBT(root, 15);
        obj.inOrderT(root);

//        obj.insertNode(root, 19);
//        obj.inOrderT(root);
    }
}
