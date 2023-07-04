/**
 * Source: https://leetcode.cn/problems/minimum-speed-to-arrive-on-time/
 * Author : sunsunsun-java
 */
public class Solution1 {
    /**
     * 二分
     * Time Complexity: O(n * logC)
     * Space Complexity: O(1)
     */
    public int minSpeedOnTime(int[] dist, double hour) {
        if (dist.length > Math.ceil(hour))
            return -1;

        int left = 1, right = Integer.MAX_VALUE;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (check(dist, mid, hour))
                right = mid;
            else
                left = mid + 1;
        }
        return left;
    }

    private boolean check(int[] dist, int speed, double hour) {
        double count = 0.0;
        for (int i = 0; i < dist.length - 1; i++)
            count += (dist[i] + speed - 1) / speed;
        count += (double) dist[dist.length - 1] / speed;
        return count <= hour;
    }

    public static void main(String[] args) {
        int[] dist = {1, 3, 2};
        double hour = 6;
        System.out.println(new Solution1().minSpeedOnTime(dist, hour));

        dist = new int[]{1, 3, 2};
        hour = 2.7;
        System.out.println(new Solution1().minSpeedOnTime(dist, hour));
    }
}
