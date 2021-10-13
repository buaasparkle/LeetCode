package `fun`.sure.leetcode.medium

import org.junit.Test

import org.junit.Assert.*

/**
 * Created by wangshuo on 2021/10/13.
 */
class SubarraySumEqualsKTest {

    private val target = SubarraySumEqualsK()

    @Test
    fun subarraySum() {
        var array = intArrayOf(1,1,1)
        assertEquals(2, target.subarraySum(array, 2))

        array = intArrayOf(1,2,3)
        assertEquals(2, target.subarraySum(array, 3))

        array = intArrayOf(1)
        assertEquals(0, target.subarraySum(array, 0))
    }
}