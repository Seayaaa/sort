package leetcode.dynamicprogramming;

/**
 * @author lsy
 * @version 1.0
 * @date 2020/10/9 15:04
 * @site https://www.lintcode.com/problem/backpack-v/description
 * @desc 描述
 * 给出 n 个物品, 以及一个数组, nums[i] 代表第i个物品的大小, 保证大小均为正数, 正整数 target 表示背包的大小, 找到能填满背包的方案数。
 * 每一个物品只能使用一次
 *
 * 您在真实的面试中是否遇到过这个题？  
 * 样例
 * 给出候选物品集合 [1,2,3,3,7] 以及 target 7
 *
 * 结果的集合为:
 * [7]
 * [1,3,3]
 * 返回 2
 */
public class BagQuestion5 {
    public int backPackV(int[] nums, int target) {
        // write your code here
        int[][] dp = new int[nums.length+1][target+1];
        dp[0][0] = 1;
        for (int i=1;i<=nums.length;i++) {
            for (int j=0;j<=target;j++) {
                // 截至到i满足target相等的方案自然在i+1位置上也满足，故相加
                dp[i][j] += dp[i-1][j];
                // 再去考虑如果使用当前物品。
                if (j >= nums[i-1]) {
                    dp[i][j] += dp[i-1][j-nums[i-1]];
                }
            }
        }
        return dp[nums.length][target];
    }
}
