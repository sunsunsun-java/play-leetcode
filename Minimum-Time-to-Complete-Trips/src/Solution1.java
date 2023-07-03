/**
 * Source: https://leetcode.cn/problems/minimum-time-to-complete-trips/
 * Author : sunsunsun-java
 */
public class Solution1 {
    /**
     * 二分
     * Time Complexity: O(n * logC)
     * Space Complexity: O(1)
     */
    public long minimumTime(int[] time, int totalTrips) {
        long left = 1, right = (long) 1e8 + 5;
        while (left < right) {
            long mid = left + (right - left) / 2;
            if (numOfTrips(time, mid, totalTrips) >= totalTrips)
                right = mid;
            else
                left = mid + 1;
        }
        return left;
    }

    private long numOfTrips(int[] time, long totalTime, int totalTrips) {
        long sum = 0;
        for (int t : time) {
            sum += totalTime / t;
            if (sum >= totalTrips)
                return (long) totalTrips;
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] time = {1,2 ,3};
        int totalTrips = 5;
        System.out.println(new Solution1().minimumTime(time, totalTrips));
    }
}
