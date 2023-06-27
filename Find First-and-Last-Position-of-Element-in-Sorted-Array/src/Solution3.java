import java.util.Arrays;

public class Solution3 {

    // lowerBound 返回最小的满足 nums[i] >= target 的 i
    // 如果数组为空，或者所有数都 < target，则返回 nums.length
    // 要求 nums 是非递减的，即 nums[i] <= nums[i + 1]

    // 循环不变量：
    // nums[left - 1] < target
    // nums[right + 1] >= target

    public int[] searchRange(int[] nums, int target) {
        int start = lowerBound(nums, target);
        if (start == nums.length || nums[start] != target)
            return new int[]{-1, -1};

        int end = lowerBound(nums, target + 1) - 1;
        return new int[]{start, end};
    }

    // 开区间写法
    private int lowerBound(int[] nums, int target) {
        int left = -1, right = nums.length; // (left, right)
        while (left + 1 < right) { // 区间不为空
            int mid = left + (right - left) / 2;
            if (nums[mid] < target)
                left = mid; // (mid, right)
            else
                right = mid; // (left, mid)
        }
        return left + 1; // right
    }

    public static void main(String[] args) {
        int[] nums = {5, 7, 7, 8, 8, 10};
        int target = 8;
        System.out.println(Arrays.toString(new Solution3().searchRange(nums, target)));
    }
}
