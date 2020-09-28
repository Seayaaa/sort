package leetcode.dynamicprogramming;

import java.util.Arrays;

/**
 * @author lsy
 * @version 1.0
 * @date 2020/9/27 20:26
 * @site https://www.lintcode.com/problem/backpack/description
 * @desc 描述
 * 在n个物品中挑选若干物品装入背包，最多能装多满？假设背包的大小为m，每个物品的大小为A[i]
 *
 * 你不可以将物品进行切割。
 *
 * 样例
 * 样例 1:
 * 	输入:  [3,4,8,5], backpack size=10
 * 	输出:  9
 *
 * 样例 2:
 * 	输入:  [2,3,5,7], backpack size=12
 * 	输出:  12
 */
public class BagQuestion {

    public int backPack(int m, int[] a) {
        int[][] dp = new int[a.length+1][m+1];
        for (int i=1;i<dp.length;i++) {
            for (int j=1;j<dp[i].length;j++) {
                if (j >= a[i-1]) {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-a[i-1]] + a[i-1]);
                } else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[a.length][m];
    }

    public int backPack1(int m, int[] a) {
        int[] dp = new int[m+1];
        int[] temp = new int[m+1];
        for (int i=1;i<dp.length;i++) {
            if (i >= a[0]) {
                temp[i] = a[0];
            }
        }
        for (int i=2;i<=a.length;i++) {
            for (int j = 1;j<dp.length;j++) {
                if (j >= a[i-1]) {
                    dp[j] = Math.max(temp[j], temp[j - a[i - 1]] + a[i - 1]);
                } else {
                    dp[j] = temp[j];
                }
            }
            temp = Arrays.copyOf(dp,dp.length);
        }
        return dp[m];
    }
}
