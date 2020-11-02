package binarytree;

import java.util.Stack;

/**
 * @author lsy
 * @version 1.0
 * @date 2020/10/20 11:00
 * @desc 二叉树前中后序遍历
 */
public class Traversal {

    /**
     * 前序遍历  根左右
     */
    public void preOrderTraverse(TreeNode node) {
        if (node == null) {
            return;
        }
        System.out.println(node.val);
        preOrderTraverse(node.leftNode);
        preOrderTraverse(node.rightNode);
    }

    /**
     * 中序遍历  左根右
     */
    public void inOrderTraverse(TreeNode node) {
        if (node == null) {
            return;
        }
        inOrderTraverse(node.leftNode);
        System.out.println(node.val);
        inOrderTraverse(node.rightNode);
    }

    /**
     * 后序遍历  左右根
     */
    public void postOrderTraverse(TreeNode node) {
        if (node == null) {
            return;
        }
        postOrderTraverse(node.leftNode);
        postOrderTraverse(node.rightNode);
        System.out.println(node.val);
    }

    
    
    // no 递归   https://blog.csdn.net/qq_38134165/article/details/79871430
    public void preOrderNoRecursive(TreeNode node) {
        if (node == null) {
            return;
        }
        TreeNode p = node;
        Stack<TreeNode> stack = new Stack<>();
        while (!stack.empty() || p != null) {
            // 将左边节点压入栈，直到最左下
            while (p != null) {
                System.out.println(p.val);
                stack.push(p);
                p = p.leftNode;
            }
            p = stack.pop();
            p = p.rightNode;
        }
    }
    
    public void inOrderNoRecursive(TreeNode node) {
        if (node == null) {
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = node;
        while (!stack.isEmpty() || cur != null) {
            // 将左边节点压入栈，直到最左下
            while (cur != null) {
                stack.push(cur);
                cur = cur.leftNode;
            }
            cur = stack.pop();
            System.out.println(cur.val);
            cur = cur.rightNode;
        }
    }
    
    public void postOrderNoRecursive(TreeNode node) {
        if (node == null) {
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = node;
        TreeNode last = null;
        while (!stack.isEmpty() || cur != null) {
            // 将左边节点压入栈，直到最左下
            while (cur != null) {
                stack.push(cur);
                cur = cur.leftNode;
            }
            cur = stack.peek();
            if (cur.rightNode != null && cur.rightNode != last) {
                cur = cur.rightNode;
            }else if (cur.rightNode == null || cur.rightNode == last) {
                System.out.println(cur.val);
                last = cur;
                stack.pop();
                cur = null;
            }
            // 1
        }
    }

}
