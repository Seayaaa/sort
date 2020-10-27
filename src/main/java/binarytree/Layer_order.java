package binarytree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author lsy
 * @version 1.0
 * @date 2020/10/20 11:34
 * @desc 层序遍历
 */
public class Layer_order {
    
    public void layerOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode front = queue.poll();
            System.out.println(front.val);
            if (front.leftNode != null) {
                queue.offer(front.leftNode);
            }
            if (front.rightNode != null) {
                queue.offer(front.rightNode);
            }
        }
    }
    
    public void layerOrder1(TreeNode root) {
        
    }
}
