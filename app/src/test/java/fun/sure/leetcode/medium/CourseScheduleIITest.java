package fun.sure.leetcode.medium;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by wangshuo on 2021/10/15.
 */
public class CourseScheduleIITest {

    private CourseScheduleII target = new CourseScheduleII();

    @Test
    public void findOrder() {
        assertArrayEquals(new int[]{0, 1},
                target.findOrder(2, new int[][]{
                        {1, 0}
                }));
        assertArrayEquals(new int[]{0, 1, 2, 3},
                target.findOrder(4, new int[][]{
                        {1, 0}, {2, 0}, {3, 1}, {3, 2}
                }));
        assertArrayEquals(new int[]{0},
                target.findOrder(1, new int[][]{}));
        assertArrayEquals(new int[]{6, 5, 4, 2, 3, 0, 1},
                target.findOrder(7, new int[][]{
                        {1, 0}, {0, 3}, {0, 2}, {3, 2}, {2, 5}, {4, 5}, {5, 6}, {2, 4}
                }));
    }
}