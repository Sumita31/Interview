package BinaryTree;

/**
 * Created by sumitachauhan on 3/8/17.
 */
public class InsertIntoBinaryTree {

    public BTNode insertNode(BTNode root, int data)
    {
        BTNode node = new BTNode(data);
        if(root == null)
            return node;
        BTNode parent = null, current = root;
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

    public BTNode insertNodeBT(BTNode root, int data){
       if(root == null)
           return root;
       BTNode next=root;
       BTNode newNode=new BTNode(data);
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

    public void inOrderT(BTNode root){
        if(root==null)
        return;
        inOrderT(root.left);
        System.out.print(root.nodeValue+", ");
        inOrderT(root.right);
    }

    public static void main(String[] args) {
        BTNode root = new BTNode(20);
        BTNode node1 = new BTNode(10);
        BTNode node2 = new BTNode(15);
        BTNode node3 = new BTNode(25);
        BTNode node4 = new BTNode(30);
        BTNode node5 = new BTNode(7);

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
