package sort;

/**
 * @author lsy
 * @version 1.0
 * @date 2020/9/17 11:16
 */
public class QuickSort {
//    private static void quick(int[] nums, int l, int r) {
//
//        if (l < r) {
//            int i = l;
//            int j = r;
//            int x = nums[l];
//            while (i < j) {
//                while (i < j && nums[j] >= x) {
//                    j--;
//                }
//                if (i < j) {
//                    nums[i] = nums[j];
//                    i++;
//                }
//                while (i < j && nums[i] < x) {
//                    i++;
//                }
//                if (i < j) {
//                    nums[j] = nums[i];
//                    j--;
//                }
//            }
//
//            nums[i] = x;
//            quick(nums, l, i - 1);
//            quick(nums, i + 1, r);
//        }
//    }
//
//
//
//    static void quick_sort(int s[], int l, int r)
//    {
//        if (l < r)
//        {
//            //Swap(s[l], s[(l + r) / 2]); //将中间的这个数和第一个数交换 参见注1
//            int i = l, j = r, x = s[l];
//            while (i < j)
//            {
//                while(i < j && s[j] >= x) // 从右向左找第一个小于x的数
//                    j--;
//                if(i < j)
//                    s[i++] = s[j];
//
//                while(i < j && s[i] < x) // 从左向右找第一个大于等于x的数
//                    i++;
//                if(i < j)
//                    s[j--] = s[i];
//            }
//            s[i] = x;
//            quick_sort(s, l, i - 1); // 递归调用
//            quick_sort(s, i + 1, r);
//        }
//    }
    public static void main(String[] args) {
        int[] nums = new int[]{1,2,10,20,98,10,24};
        quickly(nums, 0 ,nums.length-1);
        for (int i=0;i<nums.length;i++) {
            System.out.println(nums[i]);
        }
    }
    private static void quickly(int[] nums, int left, int right) {
        if (left < right) {
            int i = left;
            int j = right;
            int x = nums[left];
            while (i < j) {
                while (i < j && nums[j] >= x) {
                    j--;
                }
                if (i < j) {
                    nums[i] = nums[j];
                    i++;
                }
                while (i < j && nums[i] < x) {
                    i++;
                }
                if (i < j) {
                    nums[j] = nums[i];
                    j--;
                }
            }
            nums[i] = x;

            quickly(nums, left, i - 1);
            quickly(nums, i + 1, right);
        }
    }
}
