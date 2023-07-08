/**
 * Source : https://leetcode.cn/problems/minimized-maximum-of-products-distributed-to-any-store/
 * Author : sunsunsun-java
 */
public class Solution1 {
    /**
     * 二分
     * Time Complexity: O(n * logC)
     * Space Complexity: O(1)
     */
    public int minimizedMaximum(int n, int[] quantities) {
        int max = 0;
        for (int q : quantities)
            max = Math.max(max, q);

        int left = 1, right = max;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (check(quantities, n, mid))
                right = mid;
            else
                left = mid + 1;
        }

        return left;
    }

    private boolean check(int[] quantities, int n, int k) {
        int count = 0;
        for (int q : quantities)
            count += (q + k - 1) / k;
        return count <= n;
    }

    public static void main(String[] args) {
        int n = 6;
        int[] quantities = {11, 6};
        System.out.println(new Solution1().minimizedMaximum(n, quantities));

        n = 7;
        quantities = new int[]{15, 10, 10};
        System.out.println(new Solution1().minimizedMaximum(n, quantities));

        n = 1;
        quantities = new int[]{100000};
        System.out.println(new Solution1().minimizedMaximum(n, quantities));
    }
}
