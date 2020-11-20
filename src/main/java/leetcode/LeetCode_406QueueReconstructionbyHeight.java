package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @author lsy
 * @version 1.0
 * @date 2020/11/20 16:48
 * @site https://leetcode-cn.com/problems/queue-reconstruction-by-height/
 * 假设有打乱顺序的一群人站成一个队列。 每个人由一个整数对 (h, k) 表示，其中 h 是这个人的身高，k 是应该排在这个人前面且身高大于或等于 h 的人数。 例如：[5,2] 表示前面应该有 2 个身高大于等于 5 的人，而 [5,0] 表示前面不应该存在身高大于等于 5 的人。
 *
 * 编写一个算法，根据每个人的身高 h 重建这个队列，使之满足每个整数对 (h, k) 中对人数 k 的要求。
 *
 * 示例：
 *
 * 输入：[[7,0], [4,4], [7,1], [5,0], [6,1], [5,2]]
 * 输出：[[5,0], [7,0], [5,2], [6,1], [4,4], [7,1]]
 *  
 *
 * 提示：
 *
 * 总人数少于 1100 人。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/queue-reconstruction-by-height
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode_406QueueReconstructionbyHeight {
    public static int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, new Comparator<int[]>() {
            @Override
            public int compare(int[] person1, int[] person2) {
                if (person1[0] != person2[0]) {
                    return person1[0] - person2[0];
                } else {
                    return person2[1] - person1[1];
                }
            }
        });
        int[][] res = new int[people.length][];
        for (int[] person : people) {
            int spaces = person[1]+1;
            for(int i=0;i<people.length;++i) {
                if (res[i] == null) {
                    --spaces;
                    if (spaces == 0) {
                        res[i] = person;
                        break;
                    }
                }
            }
        }
        return res;
    }

    public static int[][] reconstructQueue1(int[][] people) {
        Arrays.sort(people, new Comparator<int[]>() {
            @Override
            public int compare(int[] person1, int[] person2) {
                if (person1[0] != person2[0]) {
                    return person2[0] - person1[0];
                } else {
                    return person1[1] - person2[1];
                }
            }
        });
        for (int[] p : people) {
            for (int pp:p) {
                System.out.print(pp+"  ");
            }
            System.out.println();
        }
        List<int[]> ans = new ArrayList<int[]>();
        for (int[] person : people) {
            ans.add(person[1], person);
        }
        return ans.toArray(new int[ans.size()][]);
    }

    public static void main(String[] args) {
        int[][] r = new int[6][2];
        r[0] = new int[]{7,0};
        r[1] = new int[]{4,4};
        r[2] = new int[]{7,1};
        r[3] = new int[]{5,0};
        r[4] = new int[]{6,1};
        r[5] = new int[]{5,2};
        
        reconstructQueue(r);
    }
}

