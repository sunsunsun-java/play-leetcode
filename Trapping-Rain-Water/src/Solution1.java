/**
 * Source : https://leetcode.cn/problems/trapping-rain-water/description/
 * Author : sunsunsun-java
 */
public class Solution1 {
    /**
     * 相向双指针
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */
    public int trap(int[] height) {
        int res = 0, left = 0, right = height.length - 1, preMax = 0, sufMax = 0;
        while (left < right) {
            preMax = Math.max(preMax, height[left]);
            sufMax = Math.max(sufMax, height[right]);
            res += preMax < sufMax ? preMax - height[left++] : sufMax - height[right--];
        }
        return res;
    }

    /**
     * 前后缀分解
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */
    public int trap2(int[] height) {
         int n = height.length;
         int[] preMax = new int[n], sufMax = new int[n];

         preMax[0] = height[0];
         for (int i = 1; i < n; i++)
             preMax[i] = Math.max(preMax[i - 1], height[i]);

         sufMax[n - 1] = height[n - 1];
         for (int i = n - 2; i >= 0; i--)
             sufMax[i] = Math.max(sufMax[i +1], height[i]);

         int res = 0;
         for (int i = 0; i < n; i++)
             res += Math.min(preMax[i], sufMax[i]) - height[i];

         return res;
    }

    public static void main(String[] args) {
        int[] height = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        System.out.println(new Solution1().trap2(height));
    }

}
