/**
 * Source : https://leetcode.cn/problems/replace-the-substring-for-balanced-string/description/
 * Author : sunsunsun-java
 */
public class Solution1 {
    /**
     * 同向双指针
     * Time Complexity: O(nC)
     * Space Complexity: O(C)
     */
    public int balancedString(String s) {
        char[] charArray = s.toCharArray();
        int[] cnt = new int[256];
        for (char c : charArray)
                cnt[c]++;
        int n = s.length(), m = n / 4;
        if (cnt['Q'] == m && cnt['W'] == m && cnt['E'] == m && cnt['R'] == m)
            return 0;

        int ans = n, left = 0;
        for (int right = 0; right < n; right++) {
            cnt[charArray[right]]--;
            while (cnt['Q'] <= m && cnt['W'] <= m && cnt['E'] <= m && cnt['R'] <= m) {
                ans = Math.min(ans, right - left + 1);
                cnt[charArray[left++]]++;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        String s = "QWER";
        System.out.println(new Solution1().balancedString(s));
    }
}
