import java.util.Arrays;

/**
 * Source : https://leetcode.cn/problems/valid-triangle-number/?utm_source=LCUS&utm_medium=ip_redirect&utm_campaign=transfer2china
 * Author : sunsunsun-java
 */
public class Solution1 {
    /**
     * 相向双指针
     * Time Complexity: O(n * n)
     * Space Complexity: O(1)
     */
    public int triangleNumber(int[] nums) {
        int n = nums.length, res = 0;
        if (n < 3)
            return res;

        Arrays.sort(nums);
        for (int i = n - 1; i >= 2; i--) {
            int left = 0, right = i - 1;
            while (left < right) {
                if (nums[left] + nums[right] > nums[i]) {
                    res += right - left;
                    right--;
                } else {
                    left++;
                }
            }
        }

        return res;
    }

    public static void main(String[] args) {
        int[] nums = {2, 2, 3, 4};
        System.out.println(new Solution1().triangleNumber(nums));
    }
}
