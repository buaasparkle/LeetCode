package fun.sure.leetcode.medium;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by wangshuo on 2021/10/18.
 */
public class CoinChangeTest {

    private CoinChange target = new CoinChange();

    @Test
    public void coinChange() {
//        assertEquals(3, target.coinChange(new int[]{1, 2, 5}, 11));
//        assertEquals(-1, target.coinChange(new int[]{2}, 3));
//        assertEquals(0, target.coinChange(new int[]{1}, 0));
//        assertEquals(1, target.coinChange(new int[]{1}, 1));
//        assertEquals(2, target.coinChange(new int[]{1}, 2));
        assertEquals(20, target.coinChange(new int[]{186,419,83,408}, 6249));
    }
}