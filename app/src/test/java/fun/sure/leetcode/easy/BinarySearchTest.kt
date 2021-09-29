package `fun`.sure.leetcode.easy

import org.junit.Assert
import org.junit.Test

/**
 * Created by wangshuo on 2021/9/29.
 */
class BinarySearchTest {

    private val binarySearch = BinarySearch()

    @Test
    fun search_case_1() {
        val nums = intArrayOf(-1, 0, 3, 5, 9, 12)
        val target = 9
        val actual = binarySearch.search(nums, target)
        Assert.assertEquals(4, actual)
    }

    @Test
    fun search_case_2() {
        val nums = intArrayOf(-1, 0, 3, 5, 9, 12)
        val target = 2
        val actual = binarySearch.search(nums, target)
        Assert.assertEquals(-1, actual)
    }
}