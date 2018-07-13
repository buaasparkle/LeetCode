package fun.sure.leetcode.easy;

/**
 * Created by sure on 2018/7/13.
 */

public class ReshapeTheMatrix {
    /**
     * In MATLAB, there is a very useful function called 'reshape', which can reshape a matrix into a new one with different size but keep its original data.
     * <p>
     * You're given a matrix represented by a two-dimensional array, and two positive integers r and c representing the row number and column number of the wanted reshaped matrix, respectively.
     * <p>
     * The reshaped matrix need to be filled with all the elements of the original matrix in the same row-traversing order as they were.
     * <p>
     * If the 'reshape' operation with given parameters is possible and legal, output the new reshaped matrix; Otherwise, output the original matrix.
     * <p>
     * Example 1:
     * Input:
     * nums =
     * [[1,2],
     * [3,4]]
     * r = 1, c = 4
     * Output:
     * [[1,2,3,4]]
     * Explanation:
     * The row-traversing of nums is [1,2,3,4]. The new reshaped matrix is a 1 * 4 matrix, fill it row by row by using the previous list.
     * Example 2:
     * Input:
     * nums =
     * [[1,2],
     * [3,4]]
     * r = 2, c = 4
     * Output:
     * [[1,2],
     * [3,4]]
     * Explanation:
     * There is no way to reshape a 2 * 2 matrix to a 2 * 4 matrix. So output the original matrix.
     * Note:
     * The height and width of the given matrix is in range [1, 100].
     * The given r and c are all positive.
     */

    public int[][] matrixReshape(int[][] nums, int r, int c) {
        int row = nums.length;
        int column = nums[0].length;
        if (row * column != r * c) {
            return nums;
        }
        int[][] result = new int[r][c];
        for (int i = 0; i < r * c; i++) {
            result[i / r][i % c] = nums[i / row][i % column];
        }
        return result;
    }
}
