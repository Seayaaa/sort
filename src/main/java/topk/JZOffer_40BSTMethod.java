package topk;

import java.util.Map;
import java.util.TreeMap;

/**
 * @author lsy
 * @version 1.0
 * @date 2020/11/12 14:37
 * topk 二叉搜索树解法
 * @site https://leetcode-cn.com/problems/zui-xiao-de-kge-shu-lcof/
 */
public class JZOffer_40BSTMethod {
    public int[] getLeastNumbers(int[] arr, int k) {
        if (k == 0 || arr.length == 0) {
            return new int[0];
        }
        // TreeMap的key是数字, value是该数字的个数。
        // cnt表示当前map总共存了多少个数字。
        TreeMap<Integer, Integer> map = new TreeMap<>();
        int cnt = 0;
        for (int num: arr) {
            // 1. 遍历数组，若当前map中的数字个数小于k，则map中当前数字对应个数+1
            if (cnt < k) {
                map.put(num, map.getOrDefault(num, 0) + 1);
                cnt++;
                continue;
            }
            // 2. 否则，取出map中最大的Key（即最大的数字), 判断当前数字与map中最大数字的大小关系：
            //    若当前数字比map中最大的数字还大，就直接忽略；
            //    若当前数字比map中最大的数字小，则将当前数字加入map中，并将map中的最大数字的个数-1。
            Map.Entry<Integer, Integer> entry = map.lastEntry();
            if (entry.getKey() > num) {
                map.put(num, map.getOrDefault(num, 0) + 1);
                if (entry.getValue() == 1) {
                    map.pollLastEntry();
                } else {
                    map.put(entry.getKey(), entry.getValue() - 1);
                }
            }

        }

        // 最后返回map中的元素
        int[] res = new int[k];
        int idx = 0;
        for (Map.Entry<Integer, Integer> entry: map.entrySet()) {
            int freq = entry.getValue();
            while (freq-- > 0) {
                res[idx++] = entry.getKey();
            }
        }
        return res;
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    public int[] getLeastNumbers1(int[] arr, int k) {
        if (arr.length == 0 || k == 0) {
            return new int[]{};
        }
        TreeMap<Integer,Integer> map = new TreeMap<>();
        int count = 0;
        for (int num : arr) {
            if (count < k) {
                map.put(num, map.getOrDefault(num, 0) + 1);
                count++;
                continue;
            }
            Map.Entry<Integer, Integer> entry = map.lastEntry();
            if (num < entry.getKey()) {
                map.put(num, map.getOrDefault(num, 0) + 1);
                if (entry.getValue() == 1) {
                    map.pollLastEntry();
                } else {
                    map.put(entry.getKey(), entry.getValue() -1);
                }
            }
        }
        int[] res = new int[k];
        int idx = 0;
        for (Map.Entry<Integer,Integer> entry: map.entrySet()) {
            int length = entry.getValue();
            while(length-- > 0) {
                res[idx++] = entry.getKey();
            }
        }
        return res;
    }
}
