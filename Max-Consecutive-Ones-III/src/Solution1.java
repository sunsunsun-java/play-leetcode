/**
 * Source : https://leetcode.cn/problems/max-consecutive-ones-iii/description/
 * Author : sunsunsun-java
 */
public class Solution1 {
    /**
     * 同向双指针
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */
    public int longestOnes(int[] nums, int k) {
        int ans = 0, left = 0, cnt0 = 0, n = nums.length;
        for (int right = 0; right < n; right++) {
            cnt0 += 1 - nums[right];
            while (cnt0 > k)
                cnt0 -= 1 - nums[left++];
            ans = Math.max(ans, right - left + 1);
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0};
        int k = 2;
        System.out.println(new Solution1().longestOnes(nums, k));
    }
}
