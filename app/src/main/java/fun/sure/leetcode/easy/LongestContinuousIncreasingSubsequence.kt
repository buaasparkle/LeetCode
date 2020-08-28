package `fun`.sure.leetcode.easy

/**
 * Created by wangshuo on 2020/8/28.
 */
class LongestContinuousIncreasingSubsequence {

    /**
     * Given an unsorted array of integers, find the length of longest continuous increasing subsequence (subarray).

    Example 1:
    Input: [1,3,5,4,7]
    Output: 3
    Explanation: The longest continuous increasing subsequence is [1,3,5], its length is 3.
    Even though [1,3,5,7] is also an increasing subsequence, it's not a continuous one where 5 and 7 are separated by 4.
    Example 2:
    Input: [2,2,2,2,2]
    Output: 1
    Explanation: The longest continuous increasing subsequence is [2], its length is 1.
    Note: Length of the array will not exceed 10,000.
     */

    /**
     * Success
     * Details
     * Runtime: 188 ms, faster than 96.77% of Kotlin online submissions for Longest Continuous Increasing Subsequence.
     * Memory Usage: 35.3 MB, less than 96.77% of Kotlin online submissions for Longest Continuous Increasing Subsequence.
     */
    fun findLengthOfLCIS(nums: IntArray): Int {
        var pre = Int.MIN_VALUE
        var count = 0
        var maxCount = 0
        for (num in nums) {
            if (num > pre) {
                count++
            } else {
                maxCount = Math.max(maxCount, count)
                count = 1
            }
            pre = num
        }
        return Math.max(maxCount, count)
    }
}