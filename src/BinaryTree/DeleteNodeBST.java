package BinaryTree;

/**
 * Created by sumitachauhan on 6/29/17.
 */
public class DeleteNodeBST {
    public BTNode deleteNode(BTNode root, int data){
        if(root==null)
            return root;
        if(root.nodeValue>data){
            root.left=deleteNode(root.left, data);
        }
        if(root.nodeValue<data){
            root.right=deleteNode(root.right,data);
        }
        else if(root.nodeValue==data){
            if(root.left==null)
                return root.right;
            if(root.right==null)
                return root.left;
            else{
//                root.nodeValue=findMin(root.right);
//                root.right=deleteNode(root.right,root.nodeValue);
                root.nodeValue=findMax(root.left);
                root.left=deleteNode(root.left,root.nodeValue);
            }
        }
        return root;
    }

    private int findMin(BTNode node){
        int min=node.nodeValue;
        while(node.left!=null){
            min=node.left.nodeValue;
            node=node.left;
        }
        return min;
    }

    private int findMax(BTNode node){
        int max=node.nodeValue;
        while(node.right!=null){
            max=node.right.nodeValue;
            node=node.right;
        }
        return max;
    }

    public static void main(String[] args) {
        BTNode root = new BTNode(20);
        BTNode node1 = new BTNode(10);
        BTNode node2 = new BTNode(15);
        BTNode node3 = new BTNode(25);
        BTNode node4 = new BTNode(30);
        BTNode node5 = new BTNode(7);
        BTNode node6 = new BTNode(23);
        BTNode node7 = new BTNode(22);
        BTNode node8 = new BTNode(40);
        BTNode node9 = new BTNode(28);

        root.left = node1;
        root.right = node3;
        node1.right = node2;
        node3.right = node4;
        node1.left = node5;
        node3.left=node6;
        node6.left=node7;
        node4.left=node9;
        node4.right=node8;

        DeleteNodeBST obj = new DeleteNodeBST();
        BTNode Newroot = obj.deleteNode(root,30);
        Traversal objT = new Traversal();
        objT.inOrder(Newroot);

    }
}
