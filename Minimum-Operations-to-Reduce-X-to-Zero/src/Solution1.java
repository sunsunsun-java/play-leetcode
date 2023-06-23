/**
 * Source : https://leetcode.cn/problems/minimum-operations-to-reduce-x-to-zero/description/
 * Author : sunsunsun-java
 */
public class Solution1 {
    /**
     * 同向双指针
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */
    public int minOperations(int[] nums, int x) {
        int target = -x;
        for (int num : nums)
            target += num;
        if (target < 0)
            return -1;

        int ans = -1, left = 0, sum = 0, n = nums.length;
        for (int right = 0; right < n; right++) {
            sum += nums[right];
            while (sum > target)
                sum -= nums[left++];
            if (sum == target)
                ans = Math.max(ans, right - left + 1);
        }

        return ans < 0 ? -1 : n - ans;
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 4, 2, 3};
        int x = 5;
        System.out.println(new Solution1().minOperations(nums, x));

        nums = new int[]{5, 6, 7, 8, 9};
        x = 4;
        System.out.println(new Solution1().minOperations(nums, x));
    }
}
