package `fun`.sure.leetcode.medium

import org.junit.Test

import org.junit.Assert.*

/**
 * Created by wangshuo on 2021/10/11.
 */
class NumberOfIslandsTest {

    private val target = NumberOfIslands()

    @Test
    fun numIslands() {
        val grid = arrayOf(
                charArrayOf('1', '1', '1', '1', '0'),
                charArrayOf('1', '1', '0', '1', '0'),
                charArrayOf('1', '1', '0', '0', '0'),
                charArrayOf('0', '0', '0', '0', '0')
        )
        var ret = target.numIslands(grid)
        assertEquals(1, ret)

        val grid2 = arrayOf(
                charArrayOf('1', '1', '0', '0', '0'),
                charArrayOf('1', '1', '0', '0', '0'),
                charArrayOf('0', '0', '1', '0', '0'),
                charArrayOf('0', '0', '0', '1', '1')
        )
        ret = target.numIslands(grid2)
        assertEquals(3, ret)
    }
}