package fun.sure.leetcode.medium;

import fun.sure.leetcode.Topics;

/**
 * Created by wangshuo on 2021/10/18.
 */
class PerfectSquares implements Topics.BFS, Topics.DynamicProgramming, Topics.Math {

    /**
     * Given an integer n, return the least number of perfect square numbers that sum to n.
     *
     * A perfect square is an integer that is the square of an integer; in other words, it is the product of some integer with itself. For example, 1, 4, 9, and 16 are perfect squares while 3 and 11 are not.
     *
     *
     *
     * Example 1:
     *
     * Input: n = 12
     * Output: 3
     * Explanation: 12 = 4 + 4 + 4.
     * Example 2:
     *
     * Input: n = 13
     * Output: 2
     * Explanation: 13 = 4 + 9.
     *
     *
     * Constraints:
     *
     * 1 <= n <= 10^4
     */

    /*
     * 思路：DP
     * f(x) = min { f(x - t^2), x - t^2 >=1 } + 1
     *      = 1, x is perfect number
     */

    /*
    Success
    Runtime: 41 ms, faster than 62.56% of Java online submissions for Perfect Squares.
    Memory Usage: 40.3 MB, less than 26.04% of Java online submissions for Perfect Squares.
     */
    public int numSquares(int n) {
        final int maxLen = 101; // 根据 n 的取值范围
        int len = (int) Math.min(101, Math.sqrt(n) + 1); // 漏掉 + 1
        int[] perfectNumBase = new int[len];
        int[] dp = new int[n + 1];
        for (int i = 1; i < len; i++) {
            perfectNumBase[i] = i * i;
            if (perfectNumBase[i] == n) {
                return 1;
            }
            dp[i * i] = 1;
        }
        for (int i = 1; i <= n; i++) {
            if (dp[i] == 0) {
                int min = Integer.MAX_VALUE;
                for (int j = 1; j < len && i - perfectNumBase[j] >= 1; j++) {
                    if (dp[i - perfectNumBase[j]] < min) {
                        min = dp[i - perfectNumBase[j]];
                    }
                }
                dp[i] = min + 1;
            }
        }
        return dp[n];
    }
}
