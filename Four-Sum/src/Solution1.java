import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Source : https://leetcode.cn/problems/4sum/
 * Author : sunsunsun-java
 */
public class Solution1 {
    /**
     * 相向双指针
     * Time Complexity: O(n * n * n)
     * Space Complexity: O(1)
     */
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length < 4)
            return res;

        int n = nums.length;
        Arrays.sort(nums);

        for (int i = 0; i < n - 3; i++) {
            if (i > 0 && nums[i] == nums[i - 1])
                continue;

            if ((long) nums[i] + nums[i + 1] + nums[i + 2] + nums[i + 3] > target)
                break;
            if ((long) nums[i] + nums[n - 3] + nums[n - 2] + nums[n - 1] < target)
                continue;

            for (int j = i + 1; j < n - 2; j++) {
                if (j > 0 && nums[j] == nums[j - 1])
                    continue;

                if ((long) nums[i] + nums[j] + nums[j + 1] + nums[j + 2] > target)
                    break;
                if ((long) nums[i] + nums[j] + nums[n - 2] + nums[n - 1] < target)
                    continue;

                int k = j + 1, m = n - 1;
                while (k < m) {
                    long sum = (long) nums[i] + nums[j] + nums[k] + nums[m];
                    if (sum > target)
                        m--;
                    else if (sum < target)
                        k++;
                    else {
                        res.add(Arrays.asList(nums[i], nums[j], nums[k], nums[m]));
                        while (k < m && nums[k + 1] == nums[k])
                            k++;
                        while (k < m && nums[m - 1] == nums[m])
                            m--;
                        k++;
                        m--;
                    }
                }
            }
        }

        return res;
    }

    public static void main(String[] args) {
        int[] nums = {1, 0, -1, 0, -2, 2};
        int target = 0;
        System.out.println(new Solution1().fourSum(nums, target));
    }
}
