package fun.sure.leetcode.medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import fun.sure.leetcode.Topics;

/**
 * Created by wangshuo on 2021/10/18.
 */
class CoinChange implements Topics.Array, Topics.BFS, Topics.DynamicProgramming {

    /**
     * You are given an integer array coins representing coins of different denominations and an integer amount representing a total amount of money.
     * <p>
     * Return the fewest number of coins that you need to make up that amount. If that amount of money cannot be made up by any combination of the coins, return -1.
     * <p>
     * You may assume that you have an infinite number of each kind of coin.
     * <p>
     * <p>
     * <p>
     * Example 1:
     * <p>
     * Input: coins = [1,2,5], amount = 11
     * Output: 3
     * Explanation: 11 = 5 + 5 + 1
     * Example 2:
     * <p>
     * Input: coins = [2], amount = 3
     * Output: -1
     * Example 3:
     * <p>
     * Input: coins = [1], amount = 0
     * Output: 0
     * Example 4:
     * <p>
     * Input: coins = [1], amount = 1
     * Output: 1
     * Example 5:
     * <p>
     * Input: coins = [1], amount = 2
     * Output: 2
     * <p>
     * <p>
     * Constraints:
     * <p>
     * 1 <= coins.length <= 12
     * 1 <= coins[i] <= 2^31 - 1
     * 0 <= amount <= 10^4
     */

    /*
    Success
    Runtime: 83 ms, faster than 10.34% of Java online submissions for Coin Change.
    Memory Usage: 55.1 MB, less than 5.01% of Java online submissions for Coin Change.
     */
    public int coinChange(int[] coins, int amount) {
        if (amount == 0) {
            return 0;
        }
        if (amount < 0 || coins == null || coins.length == 0) {
            return -1;
        }
        // sort coin list
        List<Integer> coinList = new ArrayList<>();
        for (int coin : coins) {
            coinList.add(coin);
        }
        Collections.sort(coinList);

        // verify min
        int minCoin = coinList.get(0);
        if (amount < minCoin) {
            return -1;
        }

        // dp, setup
        int[] dp = new int[amount + 1];
        for (Integer coin : coinList) {
            if (coin >= 0 && coin <= amount) {
                dp[coin] = 1;
            }
        }
        for (int i = 1; i < minCoin; i++) {
            dp[i] = -1;
        }
        // dp, traverse
        for (int i = minCoin; i <= amount; i++) {
            if (dp[i] == 0) {
                int min = Integer.MAX_VALUE;
                for (Integer coin : coinList) {
                    if (i - coin > 0) {
                        if (dp[i - coin] != -1) {
                            int count = dp[i - coin] + 1;
                            min = Math.min(min, count);
                        }
                    } else {
                        break;
                    }
                }
                if (min == Integer.MAX_VALUE) {
                    dp[i] = -1;
                } else {
                    dp[i] = min;
                }
            }
        }
        return dp[amount];
    }
}
