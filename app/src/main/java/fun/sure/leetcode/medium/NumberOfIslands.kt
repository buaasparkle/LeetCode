package `fun`.sure.leetcode.medium

import `fun`.sure.leetcode.Topics

/**
 * Created by wangshuo on 2021/10/11.
 */
class NumberOfIslands: Topics.Array, Topics.DFS, Topics.Matrix, Topics.UnionFind {

    /**
     * Given an m x n 2D binary grid grid which represents a map of '1's (land) and '0's (water),
     * return the number of islands.
     *
     * An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically.
     * You may assume all four edges of the grid are all surrounded by water.

    Example 1:

    Input: grid = [
    ["1","1","1","1","0"],
    ["1","1","0","1","0"],
    ["1","1","0","0","0"],
    ["0","0","0","0","0"]
    ]
    Output: 1
    Example 2:

    Input: grid = [
    ["1","1","0","0","0"],
    ["1","1","0","0","0"],
    ["0","0","1","0","0"],
    ["0","0","0","1","1"]
    ]
    Output: 3


    Constraints:

    m == grid.length
    n == grid[i].length
    1 <= m, n <= 300
    grid[i][j] is '0' or '1'.
     */

    /*
    Success
    Runtime: 414 ms, faster than 21.97% of Kotlin online submissions for Number of Islands.
    Memory Usage: 70.5 MB, less than 6.73% of Kotlin online submissions for Number of Islands.
     */
    fun numIslands(grid: Array<CharArray>): Int {
        val (row, column) = rowColumn(grid)
        val markGrid = Array(row) { BooleanArray(column) }
        var num = 0
        grid.indices.forEach { i ->
            grid[i].indices.forEach { j ->
                if (!markGrid[i][j] && isIsland(grid, i, j)) {
                    dfs(grid, i, j, markGrid)
                    num++
                }
            }
        }
        return num
    }

    private fun rowColumn(grid: Array<CharArray>): Pair<Int, Int> {
        val row = grid.size
        val column = grid[0].size
        return row to column
    }

    private fun isIsland(grid: Array<CharArray>, i: Int, j: Int): Boolean {
        if (isValidPosition(grid, i, j)) {
            return grid[i][j] == '1'
        }
        return false
    }

    private fun isValidPosition(grid: Array<CharArray>, i: Int, j: Int): Boolean {
        val (row, column) = rowColumn(grid)
        return i in 0 until row && j in 0 until column
    }

    private fun dfs(grid: Array<CharArray>, i: Int, j: Int, markGrid: Array<BooleanArray>) {
        if (isIsland(grid, i, j) && !markGrid[i][j]) {
            markGrid[i][j] = true
            dfs(grid, i, j - 1, markGrid)
            dfs(grid, i - 1, j, markGrid)
            dfs(grid, i, j + 1, markGrid)
            dfs(grid, i + 1, j, markGrid)
        }
    }
}