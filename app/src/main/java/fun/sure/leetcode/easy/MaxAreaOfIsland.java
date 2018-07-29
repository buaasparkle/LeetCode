package fun.sure.leetcode.easy;

/**
 * Created by sure on 2018/7/29.
 */

public class MaxAreaOfIsland {

    /**
     * Given a non-empty 2D array grid of 0's and 1's, an island is a group of 1's (representing land) connected 4-directionally (horizontal or vertical.) You may assume all four edges of the grid are surrounded by water.

     Find the maximum area of an island in the given 2D array. (If there is no island, the maximum area is 0.)

     Example 1:
     [[0,0,1,0,0,0,0,1,0,0,0,0,0],
     [0,0,0,0,0,0,0,1,1,1,0,0,0],
     [0,1,1,0,1,0,0,0,0,0,0,0,0],
     [0,1,0,0,1,1,0,0,1,0,1,0,0],
     [0,1,0,0,1,1,0,0,1,1,1,0,0],
     [0,0,0,0,0,0,0,0,0,0,1,0,0],
     [0,0,0,0,0,0,0,1,1,1,0,0,0],
     [0,0,0,0,0,0,0,1,1,0,0,0,0]]
     Given the above grid, return 6. Note the answer is not 11, because the island must be connected 4-directionally.
     Example 2:
     [[0,0,0,0,0,0,0,0]]
     Given the above grid, return 0.
     Note: The length of each dimension in the given grid does not exceed 50.
     */

    // [ACCEPTED]
    private int row;
    private int column;
    private boolean[][] flag;

    public int maxAreaOfIsland(int[][] grid) {
        row = grid.length;
        column = grid[0].length;
        initFlagGrid();
        int max = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                max = Math.max(max, searchIslandInGrid(grid, i, j));
            }
        }
        return max;
    }

    private void initFlagGrid() {
        flag = new boolean[row][column];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                flag[i][j] = false;
            }
        }
    }

    private boolean isValid(int i, int j) {
        return i >= 0 && i < row && j >= 0 && j< column;
    }

    private boolean isVisited(int i, int j) {
        return isValid(i, j) && flag[i][j];
    }

    private void setVisited(int i, int j) {
        if (isValid(i, j)) {
            flag[i][j] = true;
        }
    }

    private boolean isIsland(int[][] grid, int i, int j) {
        return isValid(i, j) && grid[i][j] == 1;
    }

    private int searchIslandInGrid(int[][] grid, int i, int j) {
        int count = 0;
        if (isIsland(grid, i, j) && !isVisited(i, j)) {
            setVisited(i, j);
            count++;
            // search left
            count += searchIslandInGrid(grid, i, j - 1);
            // search top
            count += searchIslandInGrid(grid, i - 1, j);
            // search right
            count += searchIslandInGrid(grid, i, j + 1);
            // search bottom
            count += searchIslandInGrid(grid, i + 1, j);
        }
        return count;
    }
}
