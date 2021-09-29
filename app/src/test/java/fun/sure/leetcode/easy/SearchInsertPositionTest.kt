package `fun`.sure.leetcode.easy

import org.junit.Assert
import org.junit.Test

/**
 * Created by wangshuo on 2021/9/29.
 */
class SearchInsertPositionTest {

    private val searchInsertPosition = SearchInsertPosition()

    @Test
    fun searchInsert() {
        val nums = intArrayOf(1, 3, 5, 6)
        val targets = intArrayOf(5, 2, 7, 0)
        val expects = intArrayOf(2, 1, 4, 0)
        targets.forEachIndexed { index, target ->
            Assert.assertEquals(expects[index], searchInsertPosition.searchInsert(nums, target))
        }
    }

    @Test
    fun searchInsert_2() {
        val nums = intArrayOf(1)
        var target = 0
        Assert.assertEquals(0, searchInsertPosition.searchInsert(nums, target))
    }
}