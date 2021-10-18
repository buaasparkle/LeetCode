package fun.sure.leetcode.medium;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by wangshuo on 2021/10/18.
 */
public class PerfectSquaresTest {

    private PerfectSquares target = new PerfectSquares();

    @Test
    public void numSquares() {
//        assertEquals(3, target.numSquares(12));
//        assertEquals(2, target.numSquares(13));
        assertEquals(1, target.numSquares(1));
    }
}