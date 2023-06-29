/**
 * Source : https://leetcode.cn/problems/find-minimum-in-rotated-sorted-array/description/
 * Author : sunsunsun-java
 */
public class Solution1 {
    /**
     * 红色 - false : 最小值左侧
     * 蓝色 - true : 最小值 或 最小值右侧
     * 白色 - 表示不确定
     *
     * => n - 1 必然是蓝色
     * 然后通过比较 M 和 n - 1 指向的元素大小，来判断最小值的位置
     *
     *
     * Time Complexity: O(logn)
     * Space Complexity: O(1)
     */
    public int findMin(int[] nums) {
        int n = nums.length;
        int left = -1, right = n - 1; // (-1, n - 1)
        while (left + 1 < right) { // 开区间不为空
            int mid = left + (right - left) / 2;
            if (nums[mid] < nums[n - 1])
                right = mid; // 蓝色
            else
                left = mid; // 红色
        }

        return nums[right];
    }

    public static void main(String[] args) {
        int[] nums = {3, 4, 5, 1, 2};
        System.out.println(new Solution1().findMin(nums));
    }
}
