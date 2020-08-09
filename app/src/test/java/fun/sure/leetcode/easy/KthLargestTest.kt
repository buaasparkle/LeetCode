package `fun`.sure.leetcode.easy

import org.junit.Test

import org.junit.Assert.*

/**
 * Created by wangshuo on 2020/8/9.
 */
class KthLargestTest {

    @Test
    fun testcase1() {
        val kthLargest = KthLargest(3, intArrayOf(4, 5, 8, 2))
        assertEquals(4, kthLargest.add(3))
        assertEquals(5, kthLargest.add(5))
        assertEquals(5, kthLargest.add(10))
        assertEquals(8, kthLargest.add(9))
        assertEquals(8, kthLargest.add(4))
    }
}