package fun.sure.leetcode.medium;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by wangshuo on 2020/6/24.
 */
public class MatchsticksToSquareTest {

    private MatchsticksToSquare solution = new MatchsticksToSquare();

    @Test
    public void makesquare() {
//        int[] test1 = {1, 1, 2, 2, 2};
//        Assert.assertEquals(true, solution.makesquare(test1));

//        int[] test2 = {3, 3, 3, 3, 4};
//        Assert.assertEquals(false, solution.makesquare(test2));

        int[] test3 = {5, 5, 5, 5, 4, 4, 4, 4, 3, 3, 3, 3};
        Assert.assertEquals(true, solution.makesquare(test3));

//        int[] test4 = {6035753,3826635,922363,6104805,1189018,6365253,364948,2725801,5577769,7857734,2860709,9554210,4883540,8712121,3545089};
//        Assert.assertEquals(true, solution.makesquare(test4));
    }
}