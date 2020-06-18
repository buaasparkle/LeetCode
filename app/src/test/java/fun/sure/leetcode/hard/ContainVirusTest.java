package fun.sure.leetcode.hard;

import android.util.Pair;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by wangshuo on 2020/6/15.
 */
public class ContainVirusTest {

    private int[][] grid1 = {
            {1, 1, 1},
            {1, 0, 1},
            {1, 1, 1},
    };

    private int[][] grid2 = {
            {0, 1, 0, 0, 0, 0, 0, 1},
            {0, 1, 0, 0, 0, 0, 0, 1},
            {0, 0, 0, 0, 0, 0, 0, 1},
            {0, 0, 0, 0, 0, 0, 0, 0}
    };

    private int[][] grid3 = {
            {1, 1, 1, 0, 0, 0, 0, 0, 0},
            {1, 0, 1, 0, 1, 1, 1, 1, 1},
            {1, 1, 1, 0, 0, 0, 0, 0, 0}
    };

    private ContainVirus containVirus;

    @Before
    public void setUp() throws Exception {
        containVirus = new ContainVirus();
    }

    @Test
    public void containVirus() {
        assertEquals(4, containVirus.containVirus(grid1));
        assertEquals(10, containVirus.containVirus(grid2));
        assertEquals(13, containVirus.containVirus(grid3));
    }

    @Test
    public void queryInfectedAreas() {
        ContainVirus.FlagGrid controlledGrid = new ContainVirus.FlagGrid(grid1);
        List<ContainVirus.InfectedArea> areaList = containVirus.queryInfectedAreas(grid1, controlledGrid);
        System.out.println(Arrays.toString(areaList.toArray()));
    }
}