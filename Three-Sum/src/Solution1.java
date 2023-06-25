import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Source : https://leetcode.cn/problems/3sum/
 * Author : sunsunsun-java
 */
public class Solution1 {
    /**
     * 相向双指针
     * Time Complexity: O(n * n)
     * Space Complexity: O(1)
     */
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        int n = nums.length;
        Arrays.sort(nums);

        for (int i = 0; i < n - 2; i++) {
            int x = nums[i];
            if (i > 0 && nums[i - 1] == x)
                continue;

            if (x + nums[i + 1] + nums[i + 2] > 0)
                break;
            if (x + nums[n - 2] + nums[n - 1] < 0)
                continue;

            int j = i + 1, k = n - 1;
            while (j < k) {
                int sum = x + nums[j] + nums[k];
                if (sum > 0)
                    k--;
                else if (sum < 0)
                    j++;
                else {
                    res.add(Arrays.asList(x, nums[j], nums[k]));
                    while (j < k && nums[j] == nums[j + 1])
                        j++;
                    while (j < k && nums[k] == nums[k - 1])
                        k--;
                    j++;
                    k--;
                }
            }
        }

        return res;
    }

    public static void main(String[] args) {
        int[] nums = {-1, 0, 1, 2, -1, -4};
        System.out.println(new Solution1().threeSum(nums));
    }
}
