import java.util.Arrays;

/**
 * Source : https://leetcode.cn/problems/3sum-closest/
 * Author : sunsunsun-java
 */
public class Solution1 {
    /**
     * 相向双指针
     * Time Complexity: O(n * n)
     * Space Complexity: O(1)
     */
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int n = nums.length;
        int res = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            if (i > 0 && nums[i] == nums[i - 1])
                continue;

            int j = i + 1, k = n - 1;
            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                if (sum == target)
                    return target;
                if (Math.abs(sum - target) < Math.abs(res - target))
                    res = sum;
                if (sum > target) {
                    while (j < k && nums[k - 1] == nums[k])
                        k--;
                    k--;
                } else {
                    while (j < k && nums[j + 1] == nums[j])
                        j++;
                    j++;
                }
            }
        }

        return res;
    }

    public static void main(String[] args) {
        int[] nums = {-1, 2, 1, -4};
        int target = 1;
        System.out.println(new Solution1().threeSumClosest(nums, target));
    }
}
