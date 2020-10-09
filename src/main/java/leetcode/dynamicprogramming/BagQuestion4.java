package leetcode.dynamicprogramming;

/**
 * @author lsy
 * @version 1.0
 * @date 2020/9/28 14:24
 * @site https://www.lintcode.com/problem/backpack-iv/description
 * @desc 描述
 * 给出 n 个物品, 以及一个数组, nums[i]代表第i个物品的大小, 保证大小均为正数并且没有重复, 正整数 target 表示背包的大小, 找到能填满背包的方案数。
 * 每一个物品可以使用无数次
 *
 * 您在真实的面试中是否遇到过这个题？  
 * 样例
 * 样例1
 *
 * 输入: nums = [2,3,6,7] 和 target = 7
 * 输出: 2
 * 解释:
 * 方案有: 
 * [7]
 * [2, 2, 3]
 * 样例2
 *
 * 输入: nums = [2,3,4,5] 和 target = 7
 * 输出: 3
 * 解释:
 * 方案有: 
 * [2, 5]
 * [3, 4]
 * [2, 2, 3]
 */
public class BagQuestion4 {
    public int backPackIV(int[] nums, int target) {
        int[][] dp = new int[nums.length+1][target+1];
        dp[0][0] = 1;
        for (int i=1;i<=nums.length;i++) {
            for (int j = 0;j <= target; j++) {
                int k = 0;
                while(k*nums[i-1] <= j) {
                    dp[i][j] += dp[i-1][j-k*nums[i-1]];
                    k++;
                }

            }
        }
        return dp[nums.length][target];
    }
}
