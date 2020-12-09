package leetcode;

/**
 * @author lsy
 * @version 1.0
 * @date 2020/12/9 17:52
 * @site https://leetcode-cn.com/problems/count-of-range-sum/
 * @desc 区间和的个数
 * 给定一个整数数组 nums，返回区间和在 [lower, upper] 之间的个数，包含 lower 和 upper。
 * 区间和 S(i, j) 表示在 nums 中，位置从 i 到 j 的元素之和，包含 i 和 j (i ≤ j)。
 *
 * 说明:
 * 最直观的算法复杂度是 O(n2) ，请在此基础上优化你的算法。
 *
 * 示例:
 *
 * 输入: nums = [-2,5,-1], lower = -2, upper = 2,
 * 输出: 3 
 * 解释: 3个区间分别是: [0,0], [2,2], [0,2]，它们表示的和分别为: -2, -1, 2。
 * 
 * 
 * 
 * 
 * 解法同
 * @link leetcode.LeetCode_493ReversePairs翻转对
 */
public class LeetCode_327CountofRangeSum {
    public int countRangeSum(int[] nums, int lower, int upper) {
        if (nums.length == 0) {
            return 0;
        }
        long s = 0;
        long[] sums = new long[nums.length+1];
        for (int i=0;i<nums.length;i++) {
            s += nums[i];
            sums[i+1] = s;
        }
        // 使用归并排序，时间复杂度O(n*logn)  空间复杂度O（n）
        return revCountRangeSum(sums, lower, upper, 0, sums.length-1);
    }

    public int revCountRangeSum(long[] nums, int lower, int upper, int left, int right) {
        if (left == right) {
            return 0;
        } else {
            int middle = (right + left) /2;
            int n1 = revCountRangeSum(nums, lower, upper, left, middle);
            int n2 = revCountRangeSum(nums, lower, upper, middle+1, right);
            int res = n1 + n2;
            int i = left;
            int j = middle + 1;
            int k = middle + 1;
            while (i <= middle) {
                while (j <= right && nums[j] < nums[i] + lower) {
                    j++;
                }
                while (k <= right && nums[k] <= nums[i] + upper) {
                    k++;
                }
                res += (k - j);
                i++;
            }
            long[] newNums = new long[right-left+1];
            int index = 0;
            int p1 = left;
            int p2 = middle+1;
            while (p1 <= middle || p2 <= right) {
                if (p1 > middle) {
                    newNums[index++] = nums[p2++];
                }else if (p2 > right) {
                    newNums[index++] = nums[p1++];
                }else {
                    if (nums[p1] < nums[p2]) {
                        newNums[index++] = nums[p1++];
                    } else {
                        newNums[index++] = nums[p2++];
                    }
                }
            }
            for (int p = 0;p < newNums.length;p++) {
                nums[left+p] = newNums[p];
            }
            return res;
        }
    }
}
