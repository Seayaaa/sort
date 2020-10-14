package leetcode.dynamicprogramming;

import java.util.List;

/**
 * @author lsy
 * @version 1.0
 * @date 2020/10/10 11:16
 * @site https://www.lintcode.com/problem/minimum-adjustment-cost/description
 * @desc 描述
 * 给一个整数数组，调整每个数的大小，使得相邻的两个数的差不大于一个给定的整数target，调整每个数的代价为调整前后的差的绝对值，求调整代价之和最小是多少。
 *
 * 你可以假设数组中每个整数都是正整数，且小于等于100。
 *
 * 您在真实的面试中是否遇到过这个题？  
 * 样例
 * 样例 1:
 * 	输入:  [1,4,2,3], target=1
 *   输出:  2
 *
 * 样例 2:
 * 	输入:  [3,5,4,7], target=2
 * 	输出:  1
 */
public class minimum_adjustment_cost {
    public int MinAdjustmentCost(List<Integer> a, int target) {
        /*
        dp[i][j]: 下标为 0 到 i 的前 i+1 个数满足条件，并且把 A[i] 调整为 j 时，所需最小的调整代价。

        思路：dp[i][j] 是把下标为 i 的数固定为 j，怎么由 dp[i-1][num] 推导出 dp[i][j] 呢?
        待考察的 num 区间是 [j - target, j + target] 与 [0, 100] 的交集，所以
        num_lower = max(j - target, 0),
        num_upper = min(j + target, 100)

        转移方程(使用python语法)：
        dp[i][j] = min(dp[i-1][num_lower: num_upper+1]) + abs(j - A[i])
        */
        // write your code here
        int[][] dp = new int[a.size() + 1][101];
        for (int i = 1; i <= a.size(); i++) {
            for (int j = 1; j <= 100; j++) {
                int le = Math.max(1, j - target);
                int ri = Math.min(100, j + target);
                dp[i][j] = Integer.MAX_VALUE;
                for (int k = le; k <= ri; k++) {
                    dp[i][j] = Math.min(dp[i][j], Math.abs(j - a.get(i - 1)) + dp[i - 1][k]);
                }
            }
        }
        int res = Integer.MAX_VALUE;
        for (int i = 1; i <= 100; i++) {
            res = res < dp[a.size()][i] ? res : dp[a.size()][i];
        }

        return res;
    }
}
