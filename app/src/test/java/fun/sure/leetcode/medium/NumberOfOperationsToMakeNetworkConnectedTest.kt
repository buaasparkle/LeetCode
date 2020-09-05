package `fun`.sure.leetcode.medium

import org.junit.Assert.*
import org.junit.Test

/**
 * Created by wangshuo on 2020/9/5.
 */
class NumberOfOperationsToMakeNetworkConnectedTest {

    private val solution = NumberOfOperationsToMakeNetworkConnected()

    @Test
    fun testcase() {
        assertEquals(1, solution.makeConnected(4,
                arrayOf(
                        intArrayOf(0, 1),
                        intArrayOf(0, 2),
                        intArrayOf(1, 2))
        ))
        assertEquals(2, solution.makeConnected(6,
                arrayOf(
                        intArrayOf(0, 1),
                        intArrayOf(0, 2),
                        intArrayOf(0, 3),
                        intArrayOf(1, 2),
                        intArrayOf(1, 3))
        ))
        assertEquals(-1, solution.makeConnected(6,
                arrayOf(
                        intArrayOf(0, 1),
                        intArrayOf(0, 2),
                        intArrayOf(0, 3),
                        intArrayOf(1, 2))
        ))
        assertEquals(0, solution.makeConnected(5,
                arrayOf(
                        intArrayOf(0, 1),
                        intArrayOf(0, 2),
                        intArrayOf(3, 4),
                        intArrayOf(2, 3))
        ))
    }

    @Test
    fun testcase_fail_1() {
        assertEquals(4, solution.makeConnected(12,
                arrayOf(
                        intArrayOf(1, 5),
                        intArrayOf(1, 7),
                        intArrayOf(1, 2),
                        intArrayOf(1, 4),
                        intArrayOf(3, 7),
                        intArrayOf(4, 7),
                        intArrayOf(3, 5),
                        intArrayOf(0, 6),
                        intArrayOf(0, 1),
                        intArrayOf(0, 4),
                        intArrayOf(2, 6),
                        intArrayOf(0, 3),
                        intArrayOf(0, 2))
        ))
    }

    @Test
    fun testcase_fail_2() {
        assertEquals(3, solution.makeConnected(11,
                arrayOf(
                        intArrayOf(3, 4),
                        intArrayOf(5, 6),
                        intArrayOf(0, 3),
                        intArrayOf(0, 5),
                        intArrayOf(1, 7),
                        intArrayOf(0, 4),
                        intArrayOf(2, 6),
                        intArrayOf(1, 6),
                        intArrayOf(1, 3),
                        intArrayOf(3, 7),
                        intArrayOf(4, 5),
                        intArrayOf(3, 5))
        ))
    }

    @Test
    fun testcase_fail_3() {
        assertEquals(2, solution.makeConnected(17,
                arrayOf(
                        intArrayOf(3, 5),
                        intArrayOf(8, 12),
                        intArrayOf(10, 13),
                        intArrayOf(2, 4),
                        intArrayOf(1, 7),
                        intArrayOf(6, 11),
                        intArrayOf(0, 2),
                        intArrayOf(1, 5),
                        intArrayOf(5, 9),
                        intArrayOf(1, 3),
                        intArrayOf(9, 11),
                        intArrayOf(2, 12),
                        intArrayOf(6, 12),
                        intArrayOf(4, 10),
                        intArrayOf(12, 14),
                        intArrayOf(3, 6),
                        intArrayOf(3, 8))
        ))
    }
}