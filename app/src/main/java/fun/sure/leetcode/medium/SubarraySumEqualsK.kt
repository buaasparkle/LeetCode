package `fun`.sure.leetcode.medium

import `fun`.sure.leetcode.Topics

/**
 * Created by wangshuo on 2021/10/13.
 */
class SubarraySumEqualsK: Topics.Array, Topics.HashTable, Topics.PrefixSum {

    /**
     * Given an array of integers nums and an integer k, return the total number of continuous subarrays whose sum equals to k.



    Example 1:

    Input: nums = [1,1,1], k = 2
    Output: 2
    Example 2:

    Input: nums = [1,2,3], k = 3
    Output: 2


    Constraints:

    1 <= nums.length <= 2 * 104
    -1000 <= nums[i] <= 1000
    -107 <= k <= 107
     */

    /*
     * 思路：前缀和
     */

    /*
    Success
    Runtime: 1337 ms, faster than 9.83% of Kotlin online submissions for Subarray Sum Equals K.
    Memory Usage: 56.4 MB, less than 28.32% of Kotlin online submissions for Subarray Sum Equals K.
     */
    fun subarraySum(nums: IntArray, k: Int): Int {
        val prefixSumArray = IntArray(nums.size + 1) { 0 }
        nums.forEachIndexed { index, num ->
            prefixSumArray[index + 1] = prefixSumArray[index] + num
        }
        var sum = 0
        for (i in nums.indices) {
            for (j in i + 1 until prefixSumArray.size) {
                if (prefixSumArray[j] - prefixSumArray[i] == k) {
                    sum++
                }
            }
        }
        return sum
    }
}