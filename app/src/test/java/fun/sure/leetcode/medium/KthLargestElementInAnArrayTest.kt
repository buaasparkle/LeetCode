package `fun`.sure.leetcode.medium

import org.junit.Assert.*
import org.junit.Test

/**
 * Created by wangshuo on 2020/8/13.
 */
class KthLargestElementInAnArrayTest {

    @Test
    fun testcase() {
        val solution = KthLargestElementInAnArray()
//        assertEquals(5, solution.findKthLargest(intArrayOf(3, 2, 1, 5, 6, 4), 2))
//        assertEquals(4, solution.findKthLargest(intArrayOf(3, 2, 3, 1, 2, 4, 5, 5, 6), 4))
//        assertEquals(2, solution.findKthLargest(intArrayOf(2, 1), 1))
//        assertEquals(3, solution.findKthLargest(intArrayOf(3, 3, 3, 3, 3, 3, 3, 3), 1))
        assertEquals(10, solution.findKthLargest(intArrayOf(3, 2, 3, 1, 2, 4, 5, 5, 6, 7, 7, 8, 2, 3, 1, 1, 1, 10, 11, 5, 6, 2, 4, 7, 8, 5, 6), 2))
    }
}