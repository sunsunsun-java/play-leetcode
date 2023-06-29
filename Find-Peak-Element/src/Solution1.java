/**
 * Source : https://leetcode.cn/problems/find-peak-element/description/
 * Author : sunsunsun-java
 */
public class Solution1 {
    /**
     * [1, 2, 1, 2, 4, 3, 6]
     * 红色 - false : 目标峰顶左侧
     * 蓝色 - true : 目标峰顶 或 目标峰顶右侧
     * 白色 - 表示不确定
     *
     * => 6 必然是蓝色
     * 然后通过比较 M 和 M + 1 指向的元素大小，来判断目标峰顶的位置
     *
     *
     * Time Complexity: O(logn)
     * Space Complexity: O(1)
     */
    public int findPeakElement(int[] nums) {
        int left = -1, right = nums.length - 1; // (-1, n - 1)
        while (left + 1 < right) { // 开区间不为空
            int mid = left + (right - left) / 2;
            if (nums[mid] > nums[mid + 1])
                right = mid; // 蓝色
            else
                left = mid; // 红色
        }

        return right;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 1, 2, 4, 3, 6};
        System.out.println(new Solution1().findPeakElement(nums));
    }
}
