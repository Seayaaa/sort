package leetcode.dynamicprogramming;

import java.util.Arrays;

/**
 * @author lsy
 * @version 1.0
 * @date 2020/9/17 14:16
 * @site https://leetcode-cn.com/problems/coin-change/
 * @Desc 描述
 * 322. 零钱兑换
 * 给出不同面额的硬币以及一个总金额. 写一个方法来计算给出的总金额可以换取的最少的硬币数量. 如果已有硬币的任意组合均无法与总金额面额相等, 那么返回 -1.
 *
 * 样例
 *
 * 样例1
 *
 * 输入：
 * [1, 2, 5]
 * 11
 * 输出： 3
 * 解释： 11 = 5 + 5 + 1
 *
 *
 * 样例2
 *
 * 输入：
 * [2]
 * 3
 * 输出： -1
 */
public class LeetCode_699change_coin {
    // f(x) = min{f(x-2)+1, f(x-5)+1, f(x-7)+1}
    static class Solution {
        // 自底向上
        public int coinChange(int[] coins, int amount) {
            int max = amount + 10;
            int[] dp = new int[amount+1];
            Arrays.fill(dp, max);
            dp[0] = 0;
            for (int i=1;i<=amount;i++) {
                for (int j = 0;j<coins.length;j++) {
                    if (coins[j] <= i) {
                        dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                    }
                } }
            return dp[amount] > amount ? -1 : dp[amount];
        }



        // 自上到下
        public int sol(int[] coins, int amount) {
            if (amount < 1) {
                return 0;
            }
            int[] dp = new int[amount];
            return coinChange1(coins, amount, dp);
        }

        public int coinChange1(int[] coins, int restAmount, int[] dp) {
            if (restAmount < 0) {return -1;}
            if (restAmount == 0) {return 0;}
            if (dp[restAmount-1] != 0) {return  dp[restAmount-1];}
            int min = Integer.MAX_VALUE;
            for (int coin : coins) {
                int res = coinChange1(coins, restAmount - coin, dp);
                if (res >= 0 && res < min) {
                    min = res + 1;
                }
            }
            dp[restAmount - 1] = min == Integer.MAX_VALUE ? -1 : min;
            return dp[restAmount -1];
         }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int i = solution.coinChange(new int[]{1, 2, 5}, 22);
        System.out.println(i);
    }
}
