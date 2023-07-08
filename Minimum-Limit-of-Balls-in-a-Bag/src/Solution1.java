/**
 * Source : https://leetcode.cn/problems/minimum-limit-of-balls-in-a-bag/
 * Author : sunsunsun-java
 */
public class Solution1 {
    /**
     * 二分
     * Time Complexity: O(n * logC)
     * Space Complexity: O(1)
     */
    public int minimumSize(int[] nums, int maxOperations) {
        int max = 0;
        for (int num : nums)
            max = Math.max(max, num);

        int left = 1, right = max;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (check(nums, maxOperations, mid))
                right = mid;
            else
                left = mid + 1;
        }

        return left;
    }

    private boolean check(int[] nums, int maxOperations, int k) {
        int count = 0;
        for (int num : nums)
            count += (num + k - 1) / k - 1;
        return count <= maxOperations;
    }

    public static void main(String[] args) {
        int[] nums = {9};
        int maxOperations = 2;
        System.out.println(new Solution1().minimumSize(nums, maxOperations));

        nums = new int[]{2, 4, 8, 2};
        maxOperations = 4;
        System.out.println(new Solution1().minimumSize(nums, maxOperations));
    }
}
