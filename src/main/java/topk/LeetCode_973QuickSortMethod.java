package topk;

import java.util.Arrays;
import java.util.Random;

/**
 * @author lsy
 * @version 1.0
 * @date 2020/11/11 16:39
 * topk 快排解法变形解法
 * @
 */
public class LeetCode_973QuickSortMethod {
    static Random rand = new Random();

    public static int[][] kClosest(int[][] points, int K) {
        int n = points.length;
        random_select(points, 0, n - 1, K);
        return Arrays.copyOfRange(points, 0, K);
    }

    public static void random_select(int[][] points, int left, int right, int K) {
        int pivotId = left + rand.nextInt(right - left + 1);
        int pivot = points[pivotId][0] * points[pivotId][0] + points[pivotId][1] * points[pivotId][1];
        swap(points, right, pivotId);
        int i = left - 1;
        for (int j = left; j < right; ++j) {
            int dist = points[j][0] * points[j][0] + points[j][1] * points[j][1];
            if (dist <= pivot) {
                ++i;
                swap(points, i, j);
            }
        }
        ++i;
        swap(points, i, right);
        // [left, i-1] 都小于等于 pivot, [i+1, right] 都大于 pivot
        if (K < i - left + 1) {
            random_select(points, left, i - 1, K);
        } else if (K > i - left + 1) {
            random_select(points, i + 1, right, K - (i - left + 1));
        }
    }

    public static void swap(int[][] points, int index1, int index2) {
        int[] temp = points[index1];
        points[index1] = points[index2];
        points[index2] = temp;
    }

    public static void main(String[] args) {
        int[][] points = new int[][]{new int[]{1,3},new int[]{-2,2}};
        int K = 1;
        int[][] ints = kClosest(points, K);
        for (int[] i:ints) {
            for (int a:i) {
                System.out.print(a);
                System.out.print("  ");
            }
            System.out.println();
        }
    }
}