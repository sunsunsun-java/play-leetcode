import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Source : https://leetcode.cn/problems/furthest-building-you-can-reach/
 * Author : sunsunsun-java
 */
public class Solution1 {
    /**
     * 二分
     * Time Complexity: O(Llog(L)log(n))
     * Space Complexity: O(L)
     */
    public int furthestBuilding(int[] heights, int bricks, int ladders) {
        int left = ladders, right = heights.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (check(heights, bricks, ladders, mid))
                left = mid + 1;
            else
                right = mid - 1;
        }
        return right;
    }

    private boolean check(int[] heights, int bricks, int ladders, int n) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++)
            if (heights[i + 1] - heights[i] > 0)
                list.add(heights[i + 1] - heights[i]);

        Collections.sort(list);
        int sum = 0;
        for (int i = 0; i < list.size() - ladders; i++) {
            sum += list.get(i);
            if (sum > bricks)
                return false;
        }
        return true;
    }
}
