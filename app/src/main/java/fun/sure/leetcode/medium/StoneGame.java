package fun.sure.leetcode.medium;

public class StoneGame {

    /**
     * Alex and Lee play a game with piles of stones.  There are an even number of piles arranged in a row, and each pile has a positive integer number of stones piles[i].
     *
     * The objective of the game is to end with the most stones.  The total number of stones is odd, so there are no ties.
     *
     * Alex and Lee take turns, with Alex starting first.  Each turn, a player takes the entire pile of stones from either the beginning or the end of the row.  This continues until there are no more piles left, at which point the person with the most stones wins.
     *
     * Assuming Alex and Lee play optimally, return True if and only if Alex wins the game.
     *
     *
     *
     * Example 1:
     *
     * Input: [5,3,4,5]
     * Output: true
     * Explanation:
     * Alex starts first, and can only take the first 5 or the last 5.
     * Say he takes the first 5, so that the row becomes [3, 4, 5].
     * If Lee takes 3, then the board is [4, 5], and Alex takes 5 to win with 10 points.
     * If Lee takes the last 5, then the board is [3, 4], and Alex takes 4 to win with 9 points.
     * This demonstrated that taking the first 5 was a winning move for Alex, so we return true.
     *
     *
     * Note:
     *
     * 2 <= piles.length <= 500
     * piles.length is even.
     * 1 <= piles[i] <= 500
     * sum(piles) is odd.
     */

    // [AC]
    public boolean stoneGame(int[] piles) {
        int len = piles.length;
        int[][] dic = new int[len + 1][len + 1]; // dic[x][y] 记录石头堆从第 x 开始，长度为 y 的情况下 Alex 赢的石子数
        // init gap 2
        for (int i = 0; i < len - 1; i++) {
            dic[i][0] = 0; // useless
            dic[i][1] = 0; // useless
            dic[i][2] = Math.abs(piles[i] - piles[i + 1]); // 2个时能赢几个
        }
        for (int gap = 4; gap <= len; gap += 2) {
            for (int i = 0; i + gap <= len; i++) {
                int latter2 = dic[i][gap - 2] + Math.abs(piles[i + gap - 2] - piles[i + gap - 1]); // 算上后面两个
                int former2 = dic[i + 2][gap - 2] + Math.abs(piles[i] - piles[i + 1]); // 算上全面两个
                int between = dic[i + 1][gap - 2] + Math.abs(piles[i] - piles[i + gap - 1]); // 前后一边一个
                dic[i][gap] = Math.max(between, Math.max(latter2, former2));
            }
        }
        return dic[0][len] > 0;
    }

    public static void main(String[] args) {
        System.out.println(new StoneGame().stoneGame(new int[] {5, 3, 4, 5}));
    }
}
