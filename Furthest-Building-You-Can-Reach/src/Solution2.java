import java.util.PriorityQueue;
import java.util.Queue;

public class Solution2 {
    /**
     * 优先队列
     * Time Complexity: O(nlogL)
     * Space Complexity: O(L)
     */
    public int furthestBuilding(int[] heights, int bricks, int ladders) {
        int n = heights.length, sum = 0;
        Queue<Integer> queue = new PriorityQueue<>();
        for (int i = 1; i < heights.length; i++) {
            int diff = heights[i] - heights[i - 1];
            if (diff > 0) {
                queue.offer(diff); // 用梯子
                if (queue.size() > ladders)
                    sum += queue.poll(); // 改用砖块
                if (sum > bricks)
                    return i - 1;
            }
        }
        return n - 1;
    }

}
