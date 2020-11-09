package leetcode;

/**
 * @author lsy
 * @version 1.0
 * @date 2020/11/3 15:43
 * @site https://leetcode-cn.com/problems/valid-mountain-array/
 * @desc 给定一个整数数组 A，如果它是有效的山脉数组就返回 true，否则返回 false。
 *
 * 让我们回顾一下，如果 A 满足下述条件，那么它是一个山脉数组：
 *
 * A.length >= 3
 * 在 0 < i < A.length - 1 条件下，存在 i 使得：
 * A[0] < A[1] < ... A[i-1] < A[i]
 * A[i] > A[i+1] > ... > A[A.length - 1]
 *  
 *
 *
 *
 *  
 *
 * 示例 1：
 *
 * 输入：[2,1]
 * 输出：false
 * 示例 2：
 *
 * 输入：[3,5,5]
 * 输出：false
 * 示例 3：
 *
 * 输入：[0,3,2,1]
 * 输出：true
 *  
 *
 * 提示：
 *
 * 0 <= A.length <= 10000
 * 0 <= A[i] <= 10000 
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/valid-mountain-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode_941ValidMountainArray {
    // 双指针解法
    public boolean validMountainArray(int[] a) {
        int index1 = 0;
        int index2 = a.length-1;
        if (a.length<3) {
            return false;
        }
        while (index1+1 < a.length-1 && a[index1] < a[index1+1]) {
            index1++;
        }
        while (index2-1 >= 0 && a[index2] < a[index2-1]) {
            index2--;
        }
        if (index1 == 0 || index2 == a.length-1) {
            return false;
        }
        return index1 == index2;
    }
    
    // 正向线性解法
    public boolean validMountainArray1(int[] a) {
        int index = 0;
        if (a.length <3) {
            return false;
        }
        while(index+1 <= a.length-1 && a[index]<a[index+1]) {
            index++;
        }
        if (index==0 || index==a.length) {
            return false;
        }
        while(index+1 <= a.length-1 && a[index]>a[index+1]) {
            index++;
        }
        return index == a.length-1;
    }
}
