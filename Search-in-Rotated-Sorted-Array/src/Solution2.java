public class Solution2 {
    /**
     * 蓝色（nums[mid] 在 target 或 target 的右侧）：
     * 1.nums[mid] 在左端递增段，如果 target 也在左侧且 nums[mid] >= target => 蓝色
     * 2.nums[mid] 在右侧递增段，如果 target 在左侧递增段 => 蓝色
     * 3.nums[mid] 在右侧递增段（或者 nums 只有一个递增段），如果第二中情况不成立，说明 target 也在右侧递增段，如果 nums[mid] >= target => 蓝色
     */
    public int search(int[] nums, int target) {
        int left = -1, right = nums.length; // (-1, n)
        while (left + 1 < right) { // 开区间不为空
            int mid = left + (right - left) / 2;
            if (isBlue(nums, target, mid))
                right = mid; // 蓝色
            else
                left = mid; // 红色
        }
        return right < nums.length && nums[right] == target ? right : -1;
    }

    private boolean isBlue(int[] nums, int target, int mid) {
        int end = nums[nums.length - 1];
        if (nums[mid] > end) // 1.
            return target > end && nums[mid] >= target;
        else // 2. / 3.
            return target > end || nums[mid] >= target;
    }

    public static void main(String[] args) {
        int[] nums = {4, 5, 6, 7, 0, 1, 2};
        int target = 0;
        System.out.println(new Solution2().search(nums, target));

        nums = new int[]{4, 5, 6, 7, 0, 1, 2};
        target = 3;
        System.out.println(new Solution2().search(nums, target));
    }

}
