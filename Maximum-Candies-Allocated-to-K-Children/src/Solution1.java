/**
 * Source: https://leetcode.cn/problems/maximum-candies-allocated-to-k-children/
 * Author : sunsunsun-java
 */
public class Solution1 {
    /**
     * 二分
     * Time Complexity: O(n * logC) => n : candies 的长度，C max(candies)，即上界
     * Space Complexity: O(1)
     */
    public int maximumCandies(int[] candies, long k) {
        int max = candies[0];
        long sum = 0;
        for (int candy : candies) {
            max = Math.max(max, candy);
            sum += candy;
        }
        if (sum < k)
            return 0;

        int left = 0, right = max;
        while (left < right) {
            int mid = left + (right - left + 1) / 2;
            if (check(candies, mid, k))
                right = mid - 1;
            else
                left = mid;
        }

        return left;
    }

    private boolean check(int[] candies, int candiesNum, long k) {
        long count = 0;
        for (int candy : candies)
            count += candy / candiesNum;
        return count < k;
    }

    public static void main(String[] args) {
        int[] candies = {5, 8, 6};
        int k = 3;
        System.out.println(new Solution1().maximumCandies(candies, k));

        candies = new int[]{2, 5};
        k = 11;
        System.out.println(new Solution1().maximumCandies(candies, k));
    }
}
