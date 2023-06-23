/**
 * Source : https://leetcode.cn/problems/minimum-size-subarray-sum/description/
 * Author : sunsunsun-java
 */
public class Solution1 {
    /**
     * 同向双指针
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */
    public int minSubArrayLen(int target, int[] nums) {
        int n = nums.length, left = 0, ans = n + 1, sum = 0;
        for (int right = 0; right < n; right++) {
            sum += nums[right];
            while (sum >= target) {
                ans = Math.min(ans, right - left + 1);
                sum -= nums[left++];
            }
        }

        return ans != n + 1 ? ans : 0;
    }

    public static void main(String[] args) {
        int target = 7;
        int[] nums = {2, 3, 1, 2, 4, 3};
        System.out.println(new Solution1().minSubArrayLen(7, nums));
    }
}
