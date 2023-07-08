/**
 * Source : https://leetcode.cn/problems/maximum-number-of-removable-characters/
 * Author : sunsunsun-java
 */
public class Solution1 {

    public int maximumRemovals(String s, String p, int[] removable) {
        int left = 0, right = removable.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (!isSubsequence(s, p, mid, removable))
                right = mid - 1;
            else
                left = mid + 1;
        }
        return left;
    }

    private boolean isSubsequence(String s, String p, int k, int[] removable) {
        int m = s.length(), n = p.length(), i = 0, j = 0;
        boolean[] state = new boolean[m];
        for (int x = 0; x <= k; x++)
            state[removable[x]] = true;

        while (i < m && j < n) {
            if (s.charAt(i) == p.charAt(j) && !state[i])
                j++;
            i++;
        }

        return j == n;
    }

    public static void main(String[] args) {
        String s = "abcacb", p = "ab";
        int[] removable = {3, 1, 0};
        System.out.println(new Solution1().maximumRemovals(s, p, removable));

        s = "abcbddddd";
        p = "abcd";
        removable = new int[]{3, 2, 1, 4, 5, 6};
        System.out.println(new Solution1().maximumRemovals(s, p, removable));
    }
}
