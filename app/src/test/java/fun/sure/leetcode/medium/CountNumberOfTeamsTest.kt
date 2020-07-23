package `fun`.sure.leetcode.medium

import org.junit.Assert.*
import org.junit.Test

/**
 * Created by wangshuo on 2020/7/23.
 */
class CountNumberOfTeamsTest {

    private val solution = CountNumberOfTeams()

    @Test
    fun testcase1() {
        val rating = intArrayOf(2, 5, 3, 4, 1)
        assertEquals(3, solution.numTeams(rating))
    }

    @Test
    fun testcase2() {
        val rating = intArrayOf(2, 1, 3)
        assertEquals(0, solution.numTeams(rating))
    }

    @Test
    fun testcase3() {
        val rating = intArrayOf(1, 2, 3, 4)
        assertEquals(4, solution.numTeams(rating))
    }
}