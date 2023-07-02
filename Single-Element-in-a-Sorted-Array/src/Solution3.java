/**
 * Source : https://leetcode.cn/problems/single-element-in-a-sorted-array/
 * Author : sunsunsun-java
 */
public class Solution3 {
    /**
     * 二分(异或)
     * Time Complexity: O(logn)
     * Space Complexity: O(1)
     */
    public int singleNonDuplicate(int[] nums) {
        int n = nums.length;
        int left = 0, right = n - 1;
        while (left < right) {
            int mid = left + right >> 1;
            if (nums[mid] == nums[mid ^ 1])
                left = mid + 1;
            else
                right = mid;
        }
        return nums[left];
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 2, 3, 3, 4, 4, 8, 8};
        System.out.println(new Solution3().singleNonDuplicate(nums));
    }
}
