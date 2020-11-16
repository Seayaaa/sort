package longestPalindrome;

/**
 * @author lsy
 * @version 1.0
 * @date 2020/11/13 14:33
 * 最长回文子字符串，中间扩散解法 时间复杂度O(n^2)   空间复杂度O(n)
 * @site https://leetcode-cn.com/problems/longest-palindromic-substring/
 */
public class Solution1_easy {
    public static String longestPalindrome(String s) {
        StringBuilder sb = new StringBuilder();
        for (char c:s.toCharArray()) {
            sb.append("#").append(c);
        }
        sb.append("#");
        String str = sb.toString();
        
        
        int maxLength = 1;
        int l = 0;
        for (int i=0;i<str.length();i++) {
            int left = i - 1;
            int right = i + 1;
            int max = 0;
            while (left >= 0 && right < str.length() && str.charAt(left) == str.charAt(right)) {
                left--;
                right++;
                max++;
            }
            if (maxLength < max) {
                maxLength = max;
                l = (i - maxLength) /2;
            }
        }
        return s.substring(l, l+maxLength);
    }

    public static void main(String[] args) {
        String babad = longestPalindrome("cbbd");
        // return bb
        System.out.println(babad);
    }
}
