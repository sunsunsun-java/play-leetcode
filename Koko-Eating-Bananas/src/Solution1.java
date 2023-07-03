/**
 * Source: https://leetcode.cn/problems/koko-eating-bananas/
 * Author : sunsunsun-java
 */
public class Solution1 {
    /**
     * 二分
     * Time Complexity: O(n * logC)
     * Space Complexity: O(1)
     */
    public int minEatingSpeed(int[] piles, int h) {
        int maxVal = 1;
        for (int pile : piles)
            maxVal = Math.max(maxVal, pile);

        int left = 1, right = maxVal;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (calculateSum(piles, mid) > h)
                left = mid + 1;
            else
                right = mid;
        }
        return left;
    }

    private int calculateSum(int[] piles, int speed) {
        int sum = 0;
        for (int pile : piles)
            sum += (pile + speed - 1) / speed;
        return sum;
    }

    public static void main(String[] args) {
        int[] piles = {3, 6, 7, 11};
        int h = 8;
        System.out.println(new Solution1().minEatingSpeed(piles, h));

        piles = new int[]{30, 11, 23, 4, 20};
        h = 5;
        System.out.println(new Solution1().minEatingSpeed(piles, h));
    }
}
