package `fun`.sure.leetcode.easy

import `fun`.sure.leetcode.Topics

/**
 * Created by wangshuo on 2021/9/29.
 */
class SearchInsertPosition : Topics.Array, Topics.BinarySearch {

    /**
     * Given a sorted array of distinct integers and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.

    You must write an algorithm with O(log n) runtime complexity.



    Example 1:

    Input: nums = [1,3,5,6], target = 5
    Output: 2
    Example 2:

    Input: nums = [1,3,5,6], target = 2
    Output: 1
    Example 3:

    Input: nums = [1,3,5,6], target = 7
    Output: 4
    Example 4:

    Input: nums = [1,3,5,6], target = 0
    Output: 0
    Example 5:

    Input: nums = [1], target = 0
    Output: 0
     */

    /*
    Success
    Runtime: 168 ms, faster than 84.80% of Kotlin online submissions for Search Insert Position.
    Memory Usage: 36.3 MB, less than 86.72% of Kotlin online submissions for Search Insert Position.
     */
    fun searchInsert(nums: IntArray, target: Int): Int {
        var left = 0
        var right = nums.size - 1
        while (left <= right) {
            val middle = left + (right - left) / 2
            when {
                nums[middle] < target -> left = middle + 1
                nums[middle] > target -> right = middle - 1
                else -> return middle
            }
        }
        return left
    }
}