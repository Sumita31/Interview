package BinaryTree;

import java.util.Stack;

/**
 * Created by sumitachauhan on 6/25/17.
 */
public class SpiralOrder {
    /**
     * Two stack to print in spiral way
     */
    public void spiralWithTwoStack(BTNode root) {
        if (root == null) {
            return;
        }
        Stack<BTNode> s1 = new Stack<>();
        Stack<BTNode> s2 = new Stack<>();
        s1.push(root);

        while (!s1.isEmpty() || !s2.isEmpty()) {
            while (!s1.isEmpty()) {
                root = s1.pop();
                System.out.print(root.nodeValue + " ");
                if (root.left != null) {
                    s2.push(root.left);
                }
                if (root.right != null) {
                    s2.push(root.right);
                }
            }
            while (!s2.isEmpty()) {
                root = s2.pop();
                System.out.print(root.nodeValue + " ");
                if (root.right != null) {
                    s1.push(root.right);
                }
                if (root.left != null) {
                    s1.push(root.left);
                }
            }
        }
    }

    public static void main(String[] args) {
        BTNode root = new BTNode(3);
        BTNode node1 = new BTNode(10);
        BTNode node2 = new BTNode(2);
        BTNode node3 = new BTNode(20);
        BTNode node4 = new BTNode(1);
        BTNode node5 = new BTNode(11);

        root.left = node1;
        root.right = node3;
        node1.right = node2;
        node3.right = node4;
        node1.left = node5;
        SpiralOrder obj = new SpiralOrder();
        obj.spiralWithTwoStack(root);
    }
}
