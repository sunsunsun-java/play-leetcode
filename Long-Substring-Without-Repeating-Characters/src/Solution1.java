/**
 * Source : https://leetcode.cn/problems/longest-substring-without-repeating-characters/description/
 * Author : sunsunsun-java
 */
public class Solution1 {
    /**
     * 同向双指针
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */
    public int lengthOfLongestSubstring(String s) {
        char[] charArray = s.toCharArray();
        int n = s.length(), ans = 0, left = 0;
        int[] memo = new int[128];

        for (int right = 0; right < n; right++) {
            char c = charArray[right];
            memo[c]++;
            while (memo[c] > 1)
                memo[charArray[left++]]--;
            ans = Math.max(ans, right - left + 1);
        }

        return ans;
    }

    public static void main(String[] args) {
        String s = "abcabcbb";
        System.out.println(new Solution1().lengthOfLongestSubstring(s));
    }
}
