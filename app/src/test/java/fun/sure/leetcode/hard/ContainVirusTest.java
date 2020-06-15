package fun.sure.leetcode.hard;

import org.junit.Before;

import static org.junit.Assert.*;

/**
 * Created by wangshuo on 2020/6/15.
 */
public class ContainVirusTest {

    private int[][] grid = {
            {1, 1, 1},
            {1, 0, 1},
            {1, 1, 1},
    };

    private ContainVirus containVirus;

    @Before
    public void setUp() throws Exception {
        containVirus = new ContainVirus();
    }

    @org.junit.Test
    public void containVirus() {
        assertEquals(0, containVirus.containVirus(grid));
    }
}