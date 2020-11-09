package leetcode;

import java.util.*;

/**
 * @author lsy
 * @version 1.0
 * @date 2020/11/9 16:33
 */
public class LeetCode_973KClosestPointstoOrigin {
    public int[][] kClosest(int[][] points, int K) {
        int n = points.length;
        PriorityQueue<int[]> PriorityQueue = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o2[0] - o1[0];
            }
        });
        for (int i=0;i<K;i++) {
            PriorityQueue.offer(new int[]{points[i][0]*points[i][0] + points[i][1]*points[i][1], i});
        }
        for (int i=K;i<n;i++) {
            int num = points[i][0]*points[i][0] + points[i][1]*points[i][1];
            if (num < PriorityQueue.peek()[0]) {
                PriorityQueue.poll();
                PriorityQueue.offer(new int[]{num, i});
            }
        }
        int[][] res = new int[K][2];
        for (int i =0;i<K;i++) {
            res[i] = points[PriorityQueue.poll()[1]];
        }
        return res;
    }
}
