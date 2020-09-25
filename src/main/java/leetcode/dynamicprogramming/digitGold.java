package leetcode.dynamicprogramming;

import java.util.ArrayList;
//分析见http://www.cnblogs.com/SDJL/archive/2008/08/22/1274312.html
public class digitGold {
    public int n;
    int max_n = 5;//总金矿数
    int max_people = 10;//总人数
    int peopleNeed[] = {5, 5, 3, 4, 3};
    int gold[] = {400,500,200,300,350};
    //maxGold[i][j]保存了i个人挖前j个金矿能够得到的最大金子数，
    public int[][] maxGold = new int[max_n+1][max_people+1];

    public void init() {
        for (int i = 0; i <= max_n; i++) {
            for (int j = 0; j <= max_people; j++) {
                maxGold[i][j] = 0;
            }
        }
    }

    public int getMaxGold() {
        for (int i=1;i<=max_n;i++) {

            for (int j=1;j<=max_people;j++) {
                if (j >= peopleNeed[i-1]) {
                    maxGold[i][j] = Math.max(maxGold[i-1][j], maxGold[i-1][j-peopleNeed[i-1]]+gold[i-1]);
                } else {
                    maxGold[i][j] = maxGold[i-1][j];
                }
            }
        }
        for (int i = 0; i <= max_n; i++) {
            for (int j = 0; j <= max_people; j++) {
                System.out.print(maxGold[i][j]+"   ");
            }
            System.out.println();

        }

        return maxGold[max_n][max_people];
    }

    public static void main(String[] args) {
        digitGold d = new digitGold();
        d.init();
        int s = d.getMaxGold();
        System.out.println(s);
    }
}
