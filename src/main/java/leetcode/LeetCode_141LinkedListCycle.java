package leetcode;

/**
 * @author lsy
 * @version 1.0
 * @date 2020/10/9 15:13
 * @site
 * @desc 判断链表是否成环
 */
public class LeetCode_141LinkedListCycle {

    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public boolean hasCycle(ListNode head) {
        ListNode pre = head;
        ListNode temp = head;
        while (pre != null && temp != null && temp.next != null) {
            pre = pre.next;
            temp = temp.next.next;
            if (pre == temp) {
                return true;
            }
        }
        return false;
    }
}
