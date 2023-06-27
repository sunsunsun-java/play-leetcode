/**
 * Source : https://leetcode.cn/problems/container-with-most-water/description/
 * Author : sunsunsun-java
 */
public class Solution1 {
    /**
     * 相向双指针
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */
    public int maxArea(int[] height) {
        int res = 0, left = 0, right = height.length - 1;
        while (left < right) {
            int area = Math.min(height[left], height[right]) * (right - left);
            res = Math.max(res, area);
            if (height[left] < height[right])
                left++;
            else
                right--;
        }

        return res;
    }

    public static void main(String[] args) {
        int[] height = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println(new Solution1().maxArea(height));
    }
}
