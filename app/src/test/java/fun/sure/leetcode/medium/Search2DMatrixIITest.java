package fun.sure.leetcode.medium;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by wangshuo on 2021/10/14.
 */
public class Search2DMatrixIITest {

    private Search2DMatrixII target = new Search2DMatrixII();

    @Test
    public void searchMatrix() {
        int[][] matrix = {
                {1, 4, 7, 11, 15},
                {2, 5, 8, 12, 19},
                {3, 6, 9, 16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30}
        };
        assertTrue(target.searchMatrix(matrix, 16));
    }
}