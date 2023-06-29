/**
 * Source : https://leetcode.cn/problems/search-in-rotated-sorted-array/description/
 * Author : sunsunsun-java
 */
public class Solution1 {
    /**
     * 红色 - false : target左侧
     * 蓝色 - true : target 或 target右侧
     * 白色 - 表示不确定
     *
     * => n - 1 必然是蓝色
     * 然后通过比较 M 和 n - 1 指向的元素大小，来判断最小值的位置
     *
     *
     * Time Complexity: O(logn)
     * Space Complexity: O(1)
     */
    public int search(int[] nums, int target) {
        int n = nums.length, i = findMin(nums);
        if (target > nums[n - 1])
            return lowerBound(nums, -1, i, target); // 左段
        return lowerBound(nums, i - 1, n, target); // 右端
    }

    private int findMin(int[] nums) {
        int n = nums.length;
        int left = -1, right = n - 1;
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < nums[n - 1])
                right = mid;
            else
                left = mid;
        }
        return right;
    }

    // nums[left] < target
    // nums[right] >= target
    private int lowerBound(int[] nums, int left, int right, int target) {
        int r0 = right;
        while (left + 1 < right) { // 开区间不为空
            int mid = left + (right - left) / 2;
            if (nums[mid] < target)
                left = mid; // (mid, right)
            else
                right = mid; // (left, mid)
        }
        return right < r0 && nums[right] == target ? right : -1;
    }

    public static void main(String[] args) {
        int[] nums = {4, 5, 6, 7, 0, 1, 2};
        int target = 0;
        System.out.println(new Solution1().search(nums, target));
    }
}
