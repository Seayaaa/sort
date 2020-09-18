package leetcode.dynamicprogramming;

import java.util.HashMap;
import java.util.Map;

/**
 * @author lsy
 * @version 1.0
 * @date 2020/9/17 20:12
 * @Desc 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 *
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 *
 * 注意：给定 n 是一个正整数。
 *
 * 示例 1：
 *
 * 输入： 2
 * 输出： 2
 * 解释： 有两种方法可以爬到楼顶。
 * 1.  1 阶 + 1 阶
 * 2.  2 阶
 * 示例 2：
 *
 * 输入： 3
 * 输出： 3
 * 解释： 有三种方法可以爬到楼顶。
 * 1.  1 阶 + 1 阶 + 1 阶
 * 2.  1 阶 + 2 阶
 * 3.  2 阶 + 1 阶
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/climbing-stairs
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode_70climbStairs {
    Map<Integer,Integer> map = new HashMap<>();
    // 循环
    public int climbStairs(int n) {
        if (n < 1) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        int p = 1;
        int q = 2;
        int r = 3;
        for (int i=3;i<=n;i++) {
            p = q;
            q = r;
            r = p + q;
        }
        return r;
    }

    public int climbStairs1(int n) {
        return climb(n);
    }

    // 以空间换时间，替代递归
    public int climb(int n) {
        if(n == 2) {return 2;}
        if(n == 1) {return 1;}
        if(n == 0) {return 0;}
        int num1;
        int num2;
        if (map.get(n-2) != null) {
            num1 = map.get(n-2);
        } else {
            num1 = climb(n-2);
        }
        if (map.get(n-1) != null) {
            num2 = map.get(n-1);
        } else {
            num2 = climb(n-1);
        }
        map.put(n-2,num1);
        map.put(n-1,num2);
        return num1+num2;

    }
}
