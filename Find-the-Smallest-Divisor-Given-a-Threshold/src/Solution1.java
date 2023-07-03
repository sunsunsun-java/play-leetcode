/**
 * Source: https://leetcode.cn/problems/find-the-smallest-divisor-given-a-threshold/
 * Author : sunsunsun-java
 */
public class Solution1 {
    /**
     * 二分
     * Time Complexity: O(n * logC)
     * Space Complexity: O(1)
     */
    public int smallestDivisor(int[] nums, int threshold) {
        int left = 1, right = 1_000_000;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (notPossible(nums, mid, threshold))
                right = mid;
            else
                left = mid + 1;
        }
        return left;
    }

    private boolean notPossible(int[] nums, int divisor, int threshold) {
        int sum = 0;
        for (int num : nums)
            sum += (num - 1) / divisor + 1; // 向上取整 : (num + divisor - 1) / divisor
        return sum <= threshold;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 5, 9};
        int threshold = 6;
        System.out.println(new Solution1().smallestDivisor(nums, threshold));

        nums = new int[]{44, 22, 33, 11, 1};
        threshold = 5;
        System.out.println(new Solution1().smallestDivisor(nums, threshold));
    }
}
