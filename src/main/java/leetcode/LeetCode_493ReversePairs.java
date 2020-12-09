package leetcode;

/**
 * @author lsy
 * @version 1.0
 * @date 2020/12/1 16:00
 * @site https://leetcode-cn.com/problems/reverse-pairs/
 * @desc 493. 翻转对
 * 给定一个数组 nums ，如果 i < j 且 nums[i] > 2*nums[j] 我们就将 (i, j) 称作一个重要翻转对。
 *
 * 你需要返回给定数组中的重要翻转对的数量。
 *
 * 示例 1:
 *
 * 输入: [1,3,2,3,1]
 * 输出: 2
 * 示例 2:
 *
 * 输入: [2,4,3,5,1]
 * 输出: 3
 * 注意:
 *
 * 给定数组的长度不会超过50000。
 * 输入数组中的所有数字都在32位整数的表示范围内。
 * 
 * 
 * 解法同
 * @link leetcode.LeetCode_327CountofRangeSum区间和的个数
 */
public class LeetCode_493ReversePairs {
    public int reversePairs(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        // 使用归并排序，时间复杂度O(n*logn)  空间复杂度O（n）
        return reversePairsRecursive(nums, 0, nums.length-1);
    }

    // 归并排序
    public int reversePairsRecursive(int[] nums, int left, int right) {
        if (left == right) {
            return 0;
        }
        int middle = (left + right) /2;
        int n1 = reversePairsRecursive(nums, left, middle);
        int n2 = reversePairsRecursive(nums, middle+1, right);
        int res = n1 + n2;
        int i = left;
        int j = middle+1;
        
        while (i <= middle) {
            while (j <= right && (long)nums[i] > 2 * (long)nums[j]) {
                j++;
            }
            res += j-middle-1;
            i++;
        }

        // 排序合并数组
        int[] sorted = new int[right-left+1];
        int p = left;
        int q = middle+1;
        int index = 0;
        while (p <= middle || q <= right) {
            if (p > middle) {
                sorted[index++] = nums[q++];
            } else if(q > right) {
                sorted[index++] = nums[p++];
            } else {
                if (nums[p] < nums[q]) {
                    sorted[index++] = nums[p++];
                } else {
                    sorted[index++] = nums[q++];
                }
            }
        }
        for (int k=0;k<sorted.length;k++) {
            nums[left+k] = sorted[k];
        }
        return res;
    }
}
