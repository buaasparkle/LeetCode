package fun.sure.leetcode.easy;

public class DivisorGame {

    /**
     * Alice and Bob take turns playing a game, with Alice starting first.
     *
     * Initially, there is a number N on the chalkboard.  On each player's turn, that player makes a move consisting of:
     *
     * Choosing any x with 0 < x < N and N % x == 0.
     * Replacing the number N on the chalkboard with N - x.
     * Also, if a player cannot make a move, they lose the game.
     *
     * Return True if and only if Alice wins the game, assuming both players play optimally.
     *
     *
     *
     * Example 1:
     *
     * Input: 2
     * Output: true
     * Explanation: Alice chooses 1, and Bob has no more moves.
     * Example 2:
     *
     * Input: 3
     * Output: false
     * Explanation: Alice chooses 1, Bob chooses 1, and Alice has no more moves.
     *
     *
     * Note:
     *
     * 1 <= N <= 1000
     */

    // [AC]
    // dic[i] 数组存储第 N == i 时 Alice 是赢(true) 还是输（false）
    public boolean divisorGame(int N) {
        boolean[] dic = new boolean[N+1+1]; // 预留出来一个1处理 N==1 的情况，防止 dic[2] 越界
        dic[0] = dic[1] = false;
        dic[2] = true;
        for (int i = 3; i <= N; i++) {
            boolean res = false;
            for (int x = 1; x < i; x++) {
                // 如果有取值 x 能满足 Alice 赢，基于足够明智选择的前提，dic[i] 就是能赢的，除非无论怎么取都输
                if (N % x == 0 && dic[x]) {
                    res = true;
                    break;
                }
            }
            dic[i] = res;
        }
        return dic[N];
    }
}
