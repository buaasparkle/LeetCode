package `fun`.sure.leetcode.easy

import org.junit.Assert.*
import org.junit.Test

/**
 * Created by wangshuo on 2020/8/28.
 */
class LongestContinuousIncreasingSubsequenceTest {

    private val solution = LongestContinuousIncreasingSubsequence()

    @Test
    fun testcase() {
        assertEquals(3, solution.findLengthOfLCIS(intArrayOf(1, 3, 5, 4, 7)))
        assertEquals(1, solution.findLengthOfLCIS(intArrayOf(2, 2, 2, 2, 2)))
        assertEquals(2, solution.findLengthOfLCIS(intArrayOf(2, 1, 3)))
    }
}