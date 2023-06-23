/**
 * Source : https://leetcode.cn/problems/subarray-product-less-than-k/description/
 * Author : sunsunsun-java
 */
public class Solution1 {
    /**
     * 同向双指针
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if (k <= 1)
            return 0;

        int n = nums.length, left = 0, prod = 1, ans = 0;
        for (int right = 0; right < n; right++) {
            prod *= nums[right];
            while (prod >= k)
                prod /= nums[left++];
            ans += right - left + 1;
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {10, 5, 2, 6};
        int k = 100;
        System.out.println(new Solution1().numSubarrayProductLessThanK(nums, k));
    }
}
