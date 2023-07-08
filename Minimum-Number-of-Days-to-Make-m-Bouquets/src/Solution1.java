/**
 * Source : https://leetcode.cn/problems/minimum-number-of-days-to-make-m-bouquets/
 * Author : sunsunsun-java
 */
public class Solution1 {
    /**
     * 二分
     * Time Complexity: O(n * logC)
     * Space Complexity: O(1)
     */
    public int minDays(int[] bloomDay, int m, int k) {
        if (m > bloomDay.length / k)
            return -1;

        int left = Integer.MAX_VALUE, right = 0;
        for (int day : bloomDay) {
            left = Math.min(left, day);
            right = Math.max(right, day);
        }

        while (left < right) {
            int mid = left + (right - left) / 2;
            if (canMake(bloomDay, mid, m, k))
                right = mid;
            else
                left = mid + 1;
        }

        return left;
    }

    private boolean canMake(int[] bloomDay, int days, int m, int k) {
        int bouquets = 0;
        int flowers = 0;
        int length = bloomDay.length;
        for (int i = 0; i < length && bouquets < m; i++) {
            if (bloomDay[i] <= days) {
                 flowers++;
                if (flowers == k) {
                    bouquets++;
                    flowers = 0;
                }
            } else {
                flowers = 0;
            }
        }
        return bouquets >= m;
    }

    public static void main(String[] args) {
        int[] bloomDay = {1, 10, 3, 10, 2};
        int m = 3, k = 1;
        System.out.println(new Solution1().minDays(bloomDay, m, k));

        m = 3;
        k = 2;
        System.out.println(new Solution1().minDays(bloomDay, m, k));

        bloomDay = new int[]{7, 7, 7, 7, 12, 7, 7};
        m = 2;
        k = 3;
        System.out.println(new Solution1().minDays(bloomDay, m, k));
    }
}
