package binarytree;

/**
 * @author lsy
 * @version 1.0
 * @date 2020/10/20 11:00
 */
public class Traversal {
    class TreeNode {
        int val;
        TreeNode leftNode;
        TreeNode rightNode;
    }
    
    public void preOrderTraverse(TreeNode node) {
        if (node == null) {
            return;
        }
        System.out.println(node.val);
        preOrderTraverse(node.leftNode);
        preOrderTraverse(node.rightNode);
    }
    
    public void inOrderTraverse(TreeNode node) {
        if (node == null) {
            return;
        }
        inOrderTraverse(node.leftNode);
        System.out.println(node.val);
        inOrderTraverse(node.rightNode);
    }
    public void postOrderTraverse(TreeNode node) {
        if (node == null) {
            return;
        }
        postOrderTraverse(node.leftNode);
        postOrderTraverse(node.rightNode);
        System.out.println(node.val);
    }


}
