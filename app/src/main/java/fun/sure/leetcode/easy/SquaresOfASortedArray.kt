package `fun`.sure.leetcode.easy

import `fun`.sure.leetcode.Topics
import kotlin.math.abs

/**
 * Created by wangshuo on 2021/9/30.
 */
class SquaresOfASortedArray : Topics.Array, Topics.TwoPointers, Topics.Sorting {

    /**
     *
     * Given an integer array nums sorted in non-decreasing order, return an array of the squares of each number sorted in non-decreasing order.

    Example 1:

    Input: nums = [-4,-1,0,3,10]
    Output: [0,1,9,16,100]
    Explanation: After squaring, the array becomes [16,1,0,9,100].
    After sorting, it becomes [0,1,9,16,100].
    Example 2:

    Input: nums = [-7,-3,2,3,11]
    Output: [4,9,9,49,121]


    Constraints:

    1 <= nums.length <= 104
    -104 <= nums[i] <= 104
    nums is sorted in non-decreasing order.
     */

    fun sortedSquares(nums: IntArray): IntArray {
        val sortedSquaresArray = IntArray(nums.size)
        val minAbsIndex = findMinAbsIndex(nums)
        var i = 0
        var left = minAbsIndex - 1
        var right = minAbsIndex + 1
        sortedSquaresArray[i++] = square(nums[minAbsIndex])
        while (left >= 0 && right < nums.size) {
            val value = if (Math.abs(nums[left]) < Math.abs(nums[right])) {
                square(nums[left--])
            } else {
                square(nums[right++])
            }
            sortedSquaresArray[i++] = value
        }
        while (left >= 0) {
            sortedSquaresArray[i++] = square(nums[left--])
        }
        while (right < nums.size) {
            sortedSquaresArray[i++] = square(nums[right++])
        }
        return sortedSquaresArray
    }

    private fun square(num: Int): Int {
        return num * num
    }

    private fun findMinAbsIndex(nums: IntArray): Int {
        var minAbsIndex = 0
        var minAbsValue = Int.MAX_VALUE
        nums.forEachIndexed { index, value ->
            if (Math.abs(value) < minAbsValue) {
                minAbsValue = Math.abs(value)
                minAbsIndex = index
            }
        }
        return minAbsIndex
    }
}