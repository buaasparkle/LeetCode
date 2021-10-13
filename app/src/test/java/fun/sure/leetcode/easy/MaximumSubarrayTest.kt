package `fun`.sure.leetcode.easy

import org.junit.Test

import org.junit.Assert.*

/**
 * Created by wangshuo on 2021/10/13.
 */
class MaximumSubarrayTest {

    private val target = MaximumSubarray()

    @Test
    fun maxSubArray() {
        var testcase = intArrayOf(-2, 1, -3, 4, -1, 2, 1, -5, 4)
        var ret = target.maxSubArray(testcase)
        assertEquals(6, ret)

        testcase = intArrayOf(1)
        ret = target.maxSubArray(testcase)
        assertEquals(1, ret)

        testcase = intArrayOf(5, 4, -1, 7, 8)
        ret = target.maxSubArray(testcase)
        assertEquals(23, ret)
    }
}