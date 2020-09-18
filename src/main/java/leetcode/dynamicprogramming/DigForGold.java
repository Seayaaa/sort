package leetcode.dynamicprogramming;

/**
 * @author lsy
 * @version 1.0
 * @date 2020/9/18 11:43
 * @site https://zhuanlan.zhihu.com/p/31628866
 * @desc 有一个国家发现了5座金矿，每座金矿的黄金储量不同，需要参与挖掘的工人数也不同。
 * 参与挖矿工人的总数是10人。每座金矿要么全挖，要么不挖，不能派出一半人挖取一半金矿。
 * 要求用程序求解出，要想得到尽可能多的黄金，应该选择挖取哪几座金矿？
 */
public class DigForGold {

    // n:金矿个数
    // w:人数
    // int[] g:金矿可得金钱数组
    // int[] p:金矿所需人力数组
    // f(n,w) = 0                  (n<=1 & w<p[0])
    // f(n,w) = g[0]               (n==1 & w>=p[0])
    // f(n,w) = f(n-1,w)           (n>1  & w<p[n])
    // f(n,w) = max(f(n-1,w), f(n-1,w-p[n]) + g[n])     (n>1 & w=>p[n])

    public int mostGold(int n, int w, int[] g, int[] p) {
        int[] preResult = new int[w];
        int[] result = new int[w];
        for (int i=0;i<p.length;i++) {
            if (i < p[0]) {
                preResult[i] = 0;
            } else {
                preResult[i] = g[0];
            }
        }
        for (int i=0;i<n;i++) {
            for (int j=0;j<w;j++) {
                if (j < p[i]) {
                    result[j] = preResult[j];
                } else {
                    result[j] = Math.max(preResult[j], preResult[j-p[i]] + g[i]);
                }
            }
            preResult = result;
        }
        return result[n];
//        if (n <= 1 && w < p[n-1]) {
//            return  0;
//        }
//        if (n == 1 && w > p[n-1]) {
//            return g[n-1];
//        }
//        if (n > 1 && w < p[n-1]) {
//            return mostGold(n-1, w, g, p);
//        }
//        if (n > 1 && w >= p[n-1]) {
//            return Math.max(mostGold(n-1, w, g, p), mostGold(n-1, w - p[n-1], g, p) + g[n-1]);
//        }
//        return 0;
    }
}
