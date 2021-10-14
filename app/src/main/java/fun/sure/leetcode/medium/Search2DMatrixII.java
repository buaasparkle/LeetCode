package fun.sure.leetcode.medium;

import fun.sure.leetcode.Topics;

/**
 * Created by wangshuo on 2021/10/14.
 */
class Search2DMatrixII implements Topics.Array, Topics.BinarySearch, Topics.Matrix, Topics.DivideAndConquer {

    /**
     * Write an efficient algorithm that searches for a target value in an m x n integer matrix. The matrix has the following properties:
     * <p>
     * Integers in each row are sorted in ascending from left to right.
     * Integers in each column are sorted in ascending from top to bottom.
     * <p>
     * <p>
     * Example 1:
     * <p>
     * <p>
     * Input: matrix = [[1,4,7,11,15],[2,5,8,12,19],[3,6,9,16,22],[10,13,14,17,24],[18,21,23,26,30]], target = 5
     * Output: true
     * Example 2:
     * <p>
     * <p>
     * Input: matrix = [[1,4,7,11,15],[2,5,8,12,19],[3,6,9,16,22],[10,13,14,17,24],[18,21,23,26,30]], target = 20
     * Output: false
     * <p>
     * <p>
     * Constraints:
     * <p>
     * m == matrix.length
     * n == matrix[i].length
     * 1 <= n, m <= 300
     * -109 <= matrix[i][j] <= 109
     * All the integers in each row are sorted in ascending order.
     * All the integers in each column are sorted in ascending order.
     * -109 <= target <= 109
     */

    /*
     * 思路
     * 把 matrix 分成 4 块，分别处理
     * 左上角是最小值，右下角是最大值
     * base case 是以 行/列 为单位的 二分查找
     */
    /*
    Success
    Runtime: 13 ms, faster than 18.73% of Java online submissions for Search a 2D Matrix II.
    Memory Usage: 51.7 MB, less than 9.18% of Java online submissions for Search a 2D Matrix II.
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        return searchMatrixWithRowColumn(matrix, target, 0, matrix.length - 1,
                0, matrix[0].length - 1);
    }

    private boolean searchMatrixWithRowColumn(int[][] matrix, int target,
                                              int startRow, int endRow,
                                              int startColumn, int endColumn) {
        if (!verifyRowAndColumn(matrix, startRow, startColumn)
                || !verifyRowAndColumn(matrix, endRow, endColumn)) {
            return false;
        }
        if (matrix[startRow][startColumn] > target || matrix[endRow][endColumn] < target) {
            return false;
        }
        if (startRow == endRow || startColumn == endColumn) {
            return binarySearchArray(matrix, target, startRow, endRow, startColumn, endColumn);
        }
        int midRow = startRow + (endRow - startRow) / 2;
        int midColumn = startColumn + (endColumn - startColumn) / 2;
        return searchMatrixWithRowColumn(matrix, target, startRow, midRow, startColumn, midColumn)
                || searchMatrixWithRowColumn(matrix, target, midRow + 1, endRow, startColumn, midColumn)
                || searchMatrixWithRowColumn(matrix, target, startRow, midRow, midColumn + 1, endColumn)
                || searchMatrixWithRowColumn(matrix, target, midRow + 1, endRow, midColumn + 1, endColumn);
    }

    private boolean binarySearchArray(int[][] matrix, int target,
                                      int startRow, int endRow,
                                      int startColumn, int endColumn) {
        if (matrix[startRow][startColumn] > target || matrix[endRow][endColumn] < target) {
            return false;
        }
        boolean inRow = startRow == endRow;
        int i = inRow ? startColumn : startRow;
        int j = inRow ? endColumn : endRow;
        while (i <= j) {
            int mid = i + (j - i) / 2;
            int value = inRow ? matrix[startRow][mid] : matrix[mid][startColumn];
            if (value == target) {
                return true;
            } else if (value < target) {
                i = mid + 1;
            } else {
                j = mid - 1;
            }
        }
        return false;
    }

    private boolean verifyRowAndColumn(int[][] matrix, int i, int j) {
        int row = matrix.length;
        int column = matrix[0].length;
        return i >= 0 && i < row && j >= 0 && j < column;
    }
}
