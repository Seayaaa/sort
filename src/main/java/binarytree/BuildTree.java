package binarytree;

/**
 * @author lsy
 * @version 1.0
 * @date 2020/10/27 16:01
 */
public class BuildTree {
    public TreeNode insertNode(int key, TreeNode root) {
        TreeNode currentNode = root;
        TreeNode treeNode = new TreeNode();
        treeNode.val = key;
        if (root == null) {
            return treeNode;
        }
        while (currentNode != null) {
            if (currentNode.val > key) {
                currentNode = currentNode.leftNode;
                if (currentNode == null) {
                    currentNode = treeNode;
                    return currentNode;
                }
            }else {
                currentNode = currentNode.rightNode;
                if (currentNode == null) {
                    currentNode = treeNode;
                    return currentNode;
                }
            }
        }
        return null;
    }

    public TreeNode findNode(int key,TreeNode root) {
        //查找操作
        TreeNode current = root;
        while (current != null) {
            if (current.val > key) {
                current = current.leftNode;
            }
            if (current.val < key) {
                current = current.rightNode;
            }else {
                return current;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode();
        root.val = 1;
        TreeNode current = root;
        current.val = 101;
        System.out.println(root.val);
        System.out.println(current.val);
    }
}
