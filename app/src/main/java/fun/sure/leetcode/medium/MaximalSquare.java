package fun.sure.leetcode.medium;

import fun.sure.leetcode.Topics;

/**
 * Created by wangshuo on 2021/10/18.
 */
class MaximalSquare implements Topics.Array, Topics.Matrix, Topics.DynamicProgramming {

    /**
     * Given an m x n binary matrix filled with 0's and 1's, find the largest square containing only 1's and return its area.
     * <p>
     * <p>
     * <p>
     * Example 1:
     * <p>
     * <p>
     * Input: matrix = [["1","0","1","0","0"],["1","0","1","1","1"],["1","1","1","1","1"],["1","0","0","1","0"]]
     * Output: 4
     * Example 2:
     * <p>
     * <p>
     * Input: matrix = [["0","1"],["1","0"]]
     * Output: 1
     * Example 3:
     * <p>
     * Input: matrix = [["0"]]
     * Output: 0
     * <p>
     * <p>
     * Constraints:
     * <p>
     * m == matrix.length
     * n == matrix[i].length
     * 1 <= m, n <= 300
     * matrix[i][j] is '0' or '1'.
     */

    /*
     * dp(i,j) represents the side length of the maximum square whose bottom right corner is the cell with index (i,j) in the original matrix.
     *
     * Starting from index (0,0), for every 1 found in the original matrix, we update the value of the current element as
     *
     * dp(i, j) = min(dp(i - 1,j), dp(i, j - 1), dp(i - 1, j - 1)) + 1
     *
     */

    // 这个没想到状态转移方程应该怎么推，之间抄答案提交的
    public int maximalSquare(char[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] dp = new int[m + 1][n + 1];
        int maxsqlen = 0;
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (matrix[i - 1][j - 1] == '1') {
                    dp[i][j] = Math.min(dp[i - 1][j], Math.min(dp[i][j - 1], dp[i - 1][j - 1])) + 1;
                    maxsqlen = Math.max(maxsqlen, dp[i][j]);
                }
            }
        }
        return maxsqlen * maxsqlen;
    }
}
