package fun.sure.leetcode.easy;

public class MinCostClimbingStairs {

    /**
     * On a staircase, the i-th step has some non-negative cost cost[i] assigned (0 indexed).
     *
     * Once you pay the cost, you can either climb one or two steps. You need to find minimum cost to reach the top of the floor, and you can either start from the step with index 0, or the step with index 1.
     *
     * Example 1:
     * Input: cost = [10, 15, 20]
     * Output: 15
     * Explanation: Cheapest is start on cost[1], pay that cost and go to the top.
     * Example 2:
     * Input: cost = [1, 100, 1, 1, 1, 100, 1, 1, 100, 1]
     * Output: 6
     * Explanation: Cheapest is start on cost[0], and only step on 1s, skipping cost[3].
     * Note:
     * cost will have a length in the range [2, 1000].
     * Every cost[i] will be an integer in the range [0, 999].
     */

    // [AC]
    // Dynamic Programming
    public int minCostClimbingStairs(int[] cost) {
        int N = cost.length;
        int[] stair = new int[N + 1];
        stair[0] = stair[1] = 0;
        for (int i = 2; i <= N; i++) {
            stair[i] = Math.min(stair[i - 2] + cost[i - 2], stair[i - 1] + cost[i - 1]);
        }
        return stair[N];
    }
}
