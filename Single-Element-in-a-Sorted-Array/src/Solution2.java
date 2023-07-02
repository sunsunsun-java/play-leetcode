/**
 * Source : https://leetcode.cn/problems/single-element-in-a-sorted-array/
 * Author : sunsunsun-java
 */
public class Solution2 {
    /**
     * 二分
     * Time Complexity: O(logn)
     * Space Complexity: O(1)
     */
    public int singleNonDuplicate(int[] nums) {
        int n = nums.length;
        int left = 0, right = n - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (mid % 2 == 0)
                if (mid + 1 < n && nums[mid] == nums[mid + 1])
                    left = mid + 1;
                else
                    right = mid;
            else
            if (mid - 1 >= 0 && nums[mid - 1] == nums[mid])
                left = mid + 1;
            else
                right = mid;
        }
        return nums[left]; // nums[right]
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 2, 3, 3, 4, 4, 8, 8};
        System.out.println(new Solution2().singleNonDuplicate(nums));
    }
}
