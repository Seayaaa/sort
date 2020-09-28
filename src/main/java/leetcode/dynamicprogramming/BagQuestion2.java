package leetcode.dynamicprogramming;

import java.util.Arrays;

/**
 * @author lsy
 * @version 1.0
 * @date 2020/9/28 11:39
 * @site https://www.lintcode.com/problem/backpack-ii/description
 * @desc 描述
 * 有 n 个物品和一个大小为 m 的背包. 给定数组 A 表示每个物品的大小和数组 V 表示每个物品的价值.
 *
 * 问最多能装入背包的总价值是多大?
 *
 * A[i], V[i], n, m 均为整数
 * 你不能将物品进行切分
 * 你所挑选的要装入背包的物品的总大小不能超过 m
 * 每个物品只能取一次
 * 样例
 * 样例 1:
 *
 * 输入: m = 10, A = [2, 3, 5, 7], V = [1, 5, 2, 4]
 * 输出: 9
 * 解释: 装入 A[1] 和 A[3] 可以得到最大价值, V[1] + V[3] = 9
 * 样例 2:
 *
 * 输入: m = 10, A = [2, 3, 8], V = [2, 5, 8]
 * 输出: 10
 * 解释: 装入 A[0] 和 A[2] 可以得到最大价值, V[0] + V[2] = 10
 */
public class BagQuestion2 {
    public int backPackII(int m, int[] a, int[] v) {
        int[][] dp = new int[a.length+1][m+1];
        for (int i=1;i<=a.length;i++) {
            for (int j=1;j<=m;j++) {
                if (j >= a[i-1]) {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-a[i-1]] + v[i-1]);
                } else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[a.length][m];
    }
    
    public int backPackII2(int m, int[] a, int[] v) {
        int[] dp = new int[m+1];
        int[] temp = new int[m+1];
        for (int i=1;i<=m;i++) {
            if (i >= a[0]) {
                temp[i] = v[0];
            }
        }
        for (int i=2;i<=a.length;i++) {
            for (int j=1;j<=m;j++) {
                if (j >= a[i-1]) {
                    dp[j] = Math.max(temp[j], temp[j-a[i-1]] + v[i-1]);
                } else {
                    dp[j] = temp[j];
                }
            }
            temp = Arrays.copyOf(dp, m+1);
        }
        return dp[m];
    }
}
