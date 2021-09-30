package `fun`.sure.leetcode.easy

import org.junit.Assert.assertArrayEquals
import org.junit.Test

/**
 * Created by wangshuo on 2021/9/30.
 */
class SquaresOfASortedArrayTest {

    private val squaresOfASortedArray = SquaresOfASortedArray()

    @Test
    fun sortedSquares() {
        var nums = intArrayOf(-4, -1, 0, 3, 10)
        assertArrayEquals(intArrayOf(0, 1, 9, 16, 100), squaresOfASortedArray.sortedSquares(nums))

        nums = intArrayOf(-7, -3, 2, 3, 11)
        assertArrayEquals(intArrayOf(4, 9, 9, 49, 121), squaresOfASortedArray.sortedSquares(nums))
    }
}