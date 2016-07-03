package fun.sure.leetcode.medium;

/**
 * Created by wangshuo on 2016/6/27.
 */
public class BulbSwitcher {

    /**
     * There are n bulbs that are initially off. You first turn on all the bulbs. Then, you turn off
     * every second bulb. On the third round, you toggle every third bulb (turning on if it's off or
     * turning off if it's on). For the ith round, you toggle every i bulb. For the nth round, you
     * only toggle the last bulb. Find how many bulbs are on after n rounds.

     Example:

     Given n = 3.

     At first, the three bulbs are [off, off, off].
     After first round, the three bulbs are [on, on, on].
     After second round, the three bulbs are [on, off, on].
     After third round, the three bulbs are [on, off, off].

     So you should return 1, because there is only one bulb is on.
     */

    // 1. 对于质数，1点亮一回，自己关掉，所以最终的状态是关闭的
    // 2. 对于n, 将n拆分成a*b，a轮关闭，b轮点亮，第n轮又关闭；但是有一种特殊的情况就是a==b，最终的状态就是点亮
    // 1/4/9/16/25... 最终将是点亮的

    // [PASS]
    public int bulbSwitch(int n) {
        int on = 0;
        for (int i = 1; i * i <= n; i++) {
            on++;
        }
        return on;
    }
}
