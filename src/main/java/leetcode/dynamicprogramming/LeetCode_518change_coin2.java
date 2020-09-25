package leetcode.dynamicprogramming;

import java.util.Arrays;

/**
 * @author lsy
 * @version 1.0
 * @date 2020/9/21 17:37
 * @site https://leetcode-cn.com/problems/coin-change-2/
 * @desc 给定不同面额的硬币和一个总金额。写出函数来计算可以凑成总金额的硬币组合数。假设每一种面额的硬币有无限个。 
 *
 *  
 *
 * 示例 1:
 *
 * 输入: amount = 5, coins = [1, 2, 5]
 * 输出: 4
 * 解释: 有四种方式可以凑成总金额:
 * 5=5
 * 5=2+2+1
 * 5=2+1+1+1
 * 5=1+1+1+1+1
 * 示例 2:
 *
 * 输入: amount = 3, coins = [2]
 * 输出: 0
 * 解释: 只用面额2的硬币不能凑成总金额3。
 * 示例 3:
 *
 * 输入: amount = 10, coins = [10]
 * 输出: 1
 *  
 *
 * 注意:
 *
 * 你可以假设：
 *
 * 0 <= amount (总金额) <= 5000
 * 1 <= coin (硬币面额) <= 5000
 * 硬币种类不超过 500 种
 * 结果符合 32 位符号整数
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/coin-change-2
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode_518change_coin2 {
    class Solution {
         public int change(int amount, int[] coins) {
             int[] dp = new int[amount+1];
             Arrays.fill(dp,0);
             dp[0] = 1;
             for(int i=0;i<coins.length;i++) {
                 for (int j=1;j<=amount;j++) {
                     if (j >= coins[i]) {
                         dp[j] = dp[j] + dp[j-coins[i]];
                     }
                 }
             }
             return dp[amount];
         }
    }

    class Solution1 {
        public int change(int amount, int[] coins) {
            int[][] dp = new int[coins.length+1][amount+1];
            for (int i=0;i<dp.length;i++) {
                for (int j=0;j<dp[i].length;j++) {
                    dp[i][j] = 0;
                }
            }
            for (int i=0;i<dp.length;i++) {
                dp[i][0] = 1;
            }
            for(int i=1;i<=coins.length;i++) {
                for (int j=1;j<=amount;j++) {
                    if (j >= coins[i-1]) {
                        dp[i][j] = dp[i-1][j] + dp[i][j-coins[i-1]];
                    } else {
                        dp[i][j] = dp[i-1][j];
                    }
                }
            }
            return dp[coins.length][amount];
        }
    }
}
