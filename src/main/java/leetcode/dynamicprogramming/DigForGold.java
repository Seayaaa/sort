package leetcode.dynamicprogramming;

import java.util.Arrays;

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
    // result[j] = Math.max(preResult[j], preResult[j-p[i-1]] + g[i-1]);

    public static int mostGold(int n, int w, int[] g, int[] p) {
        // 数组下标即代表，当前可用人数
        int[] preResult = new int[w+1];
        int[] result = new int[w+1];
        for (int i=1;i<=w;i++) {
            if (i < p[0]) {
                preResult[i] = 0;
            } else {
                preResult[i] = g[0];
            }
        }
        System.out.println(Arrays.toString(preResult));
        // 第一座金矿已赋值完毕
        // 从2座金矿开始
        for (int i=2;i<=n;i++) {

            for (int j=1;j<=w;j++) {
                // 当前人数足够去挖该金矿
                if (j >= p[i-1]) {
                    // 取，挖该金矿和不挖该金矿，最大值
                    result[j] = Math.max(preResult[j], preResult[j-p[i-1]] + g[i-1]);
                } else {
                    // 人手不够，只能选择不挖该金矿
                    result[j] = preResult[j];
                }
            }
            System.out.println("res:"+Arrays.toString(result));
            // 将当前金矿数所能挖取最大金子的值，保存到preResult里面，下次循环再去计算i++金矿数所能挖取最大金子的值
            preResult = Arrays.copyOf(result,11);
        }
        // 取最后5金矿10人数的结果，即最大采金量
        return result[w];
    }

    public static void main(String[] args) {
        int i = mostGold(5, 10, new int[]{400,500,200,300,350}, new int[]{5,5,3,4,3});
        System.out.println(i);
    }
}
