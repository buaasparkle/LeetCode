package `fun`.sure.leetcode.medium

import org.junit.Test

import org.junit.Assert.*

/**
 * Created by wangshuo on 2020/7/18.
 */
class FindEventualSafeStatesTest {

    private val test = FindEventualSafeStates()

    @Test
    fun eventualSafeNodes1() {
        val testcase = arrayOf(
                intArrayOf(1, 2),
                intArrayOf(2, 3),
                intArrayOf(5),
                intArrayOf(0),
                intArrayOf(5),
                intArrayOf(),
                intArrayOf()
        )
        assertArrayEquals(arrayOf(2, 4, 5, 6), test.eventualSafeNodes(testcase).toTypedArray())
    }

    // [[0],[2,3,4],[3,4],[0,4],[]]
    @Test
    fun eventualSafeNodes2() {
        val testcase = arrayOf(
                intArrayOf(0),
                intArrayOf(2, 3, 4),
                intArrayOf(3, 4),
                intArrayOf(0, 4),
                intArrayOf()
        )
        assertArrayEquals(arrayOf(4), test.eventualSafeNodes(testcase).toTypedArray())
    }

    // [[1,2,3,4],[1,2,3,4],[3,4],[4],[]]
    @Test
    fun eventualSafeNodes3() {
        val testcase = arrayOf(
                intArrayOf(1, 2, 3, 4),
                intArrayOf(1, 2, 3, 4),
                intArrayOf(3, 4),
                intArrayOf(4),
                intArrayOf()
        )
        assertArrayEquals(arrayOf(2, 3, 4), test.eventualSafeNodes(testcase).toTypedArray())
    }
}