/**
 * Source: https://leetcode.cn/problems/capacity-to-ship-packages-within-d-days/
 * Author : sunsunsun-java
 */
public class Solution1 {
    /**
     * 二分
     * Time Complexity: O(n * logC)
     * Space Complexity: O(1)
     */
    public int shipWithinDays(int[] weights, int days) {
        int max = 0, sum = 0;
        for (int weight : weights) {
            max = Math.max(max, weight);
            sum += weight;
        }

        int left = max, right = sum;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (check(weights, mid, days))
                right = mid;
            else
                left = mid + 1;
        }

        return left;
    }

    private boolean check(int[] weights, int capacity, int days) {
        int n = weights.length;
        int count = 1;
        for (int i = 1, sum = weights[0]; i < n; sum = 0, count++) {
            while (i < n && sum + weights[i] <= capacity) {
                sum += weights[i];
                i++;
            }
        }
        return count - 1 <= days;
    }

    public static void main(String[] args) {
        int[] weights = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int days = 5;
        System.out.println(new Solution1().shipWithinDays(weights, days));
    }
}
