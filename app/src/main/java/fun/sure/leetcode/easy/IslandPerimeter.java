package fun.sure.leetcode.easy;

/**
 * Created by sure on 2017/2/19.
 */

public class IslandPerimeter {

    /**
     * You are given a map in form of a two-dimensional integer grid where 1 represents land and 0
     * represents water. Grid cells are connected horizontally/vertically (not diagonally).
     * The grid is completely surrounded by water, and there is exactly one island
     * (i.e., one or more connected land cells). The island doesn't have "lakes"
     * (water inside that isn't connected to the water around the island).
     * One cell is a square with side length 1. The grid is rectangular, width and height
     * don't exceed 100. Determine the perimeter of the island.

     Example:

     [[0,1,0,0],
     [1,1,1,0],
     [0,1,0,0],
     [1,1,0,0]]

     Answer: 16
     Explanation: The perimeter is the 16 yellow stripes in the image below:

     */

    // 因为只有一个连通的岛，并且岛中无湖，所以可以简单粗暴的遍历每一个点，并且判断临水的长度，从而得到岛的周长
    public int islandPerimeter(int[][] grid) {
        int perimeter = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (isLand(grid, i, j)) {
                    perimeter += getLandCellPerimeter(grid, i, j);
                }
            }
        }
        return perimeter;
    }

    private int getLandCellPerimeter(int[][] grid, int x, int y) {
        int perimeter = 0;
        perimeter += (isLand(grid, x - 1, y) ? 0 : 1); // Left
        perimeter += (isLand(grid, x + 1, y) ? 0 : 1); // Right
        perimeter += (isLand(grid, x, y - 1) ? 0 : 1); // Top
        perimeter += (isLand(grid, x, y + 1) ? 0 : 1); // Bottom
        return perimeter;
    }

    private boolean isLand(int[][] grid, int x, int y) {
        return !isEdge(grid, x, y) && grid[x][y] == 1;
    }

    private boolean isEdge(int[][] grid, int x, int y) {
        return x < 0 || x >= grid.length || y < 0 || y >= grid[0].length;
    }

    public static void main(String[] args) {
        int[][] grid = {
                {0, 1, 0, 0},
                {1, 1, 1, 0},
                {0, 1, 0, 0},
                {1, 1, 0, 0}
        };
        int ret = new IslandPerimeter().islandPerimeter(grid);
        System.out.println(ret);
    }
}
