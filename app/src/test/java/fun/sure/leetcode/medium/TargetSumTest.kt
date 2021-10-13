package `fun`.sure.leetcode.medium

import org.junit.Test

import org.junit.Assert.*

/**
 * Created by wangshuo on 2021/10/13.
 */
class TargetSumTest {

    private val target = TargetSum()

    @Test
    fun findTargetSumWays() {
        var array = intArrayOf(1, 1, 1, 1, 1)
        assertEquals(5, target.findTargetSumWays(array, 3))

        array = intArrayOf(1)
        assertEquals(1, target.findTargetSumWays(array, 1))
    }
}