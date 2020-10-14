package leetcode.dynamicprogramming;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author lsy
 * @version 1.0
 * @date 2020/10/12 15:19
 * @site https://www.lintcode.com/problem/rogue-knight-sven/description
 * @desc 描述
 * 在物质位面“现实”中，有n+1个星球，分别为星球0，星球1，……，星球n。
 *
 * 每一个星球都有一个传送门，通过传送门可以直接到达目标星球而不经过其他的星球。
 *
 * 不过传送门有两个缺点。
 *
 * 第一，从星球i通过传送门只能到达编号比i大，且与i的差不超过limit的星球。
 *
 * 第二，通过传送门到达星球j，需要cost[j]个金币。
 *
 * 现在，流浪剑客斯温到达星球0后身上有m个金币，请问他有多少种方法通过传送门到达星球n？
 *
 * 1 <= n <= 50, 0 <= m <= 100, 1 <= limit <= 50, 0 <= cost[i] <= 100。
 * 由于cost[0]没有意义，题目保证cost[0] = 0。
 * 您在真实的面试中是否遇到过这个题？  
 * 样例
 * 例1:
 *
 * 输入:
 * n = 1
 * m = 1, 
 * limit = 1
 * cost = [0, 1]
 * 输出:
 * 1
 * 解释:
 * 方案1：星球0→星球1
 * 例2:
 *
 * 输入:
 * n = 1
 * m = 1
 * limit = 1
 * cost = [0,2]
 * 输出:
 * 0
 * 解释:
 * 无合法方案
 */
public class RogueKnightSven {
    public static long getNumberOfWays(int n, int m, int limit, int[] cost) {
        // 
        int[][] dp = new int[n+1][m+1];
        dp[0][m] = 1;
        for (int i=1;i<=n;i++) {
            for (int j=0;j<=m;j++) {
                int le = Math.max(0,i-limit);
                for (int k=le;k<i;k++) {
                    if (j + cost[i-1] <= m) {
                        dp[i][j] += dp[k][j+cost[i-1]];
                    }
                }
            }
        }
        int res = 0;
        for (int num : dp[n]) {
            res += num;
        }
        return res;
    }

    public static void main(String[] args) {
        long numberOfWays = getNumberOfWays(1, 1, 1, new int[]{0, 2});
        System.out.println(numberOfWays);

    }
}
