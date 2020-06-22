package fun.sure.leetcode.easy;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by wangshuo on 2020/6/22.
 */
public class RunningSumOf1dArrayTest {

    private RunningSumOf1dArray solution = new RunningSumOf1dArray();

    @Test
    public void runningSum() {
        Assert.assertArrayEquals("only 1 item array",
                new int[]{1},
                solution.runningSum(new int[]{1})
        );

        Assert.assertArrayEquals("5 items array",
                new int[]{1, 2, 3, 4, 5},
                solution.runningSum(new int[]{1, 1, 1, 1, 1})
        );

        Assert.assertArrayEquals("+/- items array",
                new int[]{1, -1, -1, -5, 1},
                solution.runningSum(new int[]{1, -2, 0, -4, 6})
        );
    }
}