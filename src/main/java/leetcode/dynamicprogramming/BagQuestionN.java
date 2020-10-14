package leetcode.dynamicprogramming;

/**
 * @author lsy
 * @version 1.0
 * @date 2020/10/9 17:05
 * @site https://www.lintcode.com/problem/backpack-ix/description
 * @desc 描述
 * 你总共有n 万元，希望申请国外的大学，要申请的话需要交一定的申请费用，给出每个大学的申请费用以及你得到这个大学offer的成功概率，大学的数量是 m。如果经济条件允许，你可以申请多所大学。找到获得至少一份工作的最高可能性。
 *
 * 0<=n<=10000,0<=m<=10000
 *
 * 您在真实的面试中是否遇到过这个题？  
 * 样例
 * 样例 1:
 * 	输入:  
 * 		n = 10
 * 		prices = [4,4,5]
 * 		probability = [0.1,0.2,0.3]    
 * 	输出:  0.440          (1-0.8*0.7)
 *
 * 	解释：
 * 	选择第2和第3个学校。
 *
 * 样例 2:
 * 	输入: 
 * 		n = 10
 * 		prices = [4,5,6]
 * 		probability = [0.1,0.2,0.3]
 * 	输出:  0.370           (1-0.9*0.7)
 *
 * 	解释:
 * 	选择第1和第3个学校。
 *
 */
public class BagQuestionN {
    public double backpackIX(int n, int[] prices, double[] probability) {
        // write your code here
        double[][] dp = new double[prices.length+1][n+1];
        for (int i=1;i<=prices.length;i++) {
            for (int j=0;j<=n;j++) {
                if (j >= prices[i-1]) {
                    dp[i][j] = Math.max(1-(1-dp[i-1][j-prices[i-1]])*(1-probability[i-1]), dp[i-1][j]);
                } else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[prices.length][n];
    }
}
