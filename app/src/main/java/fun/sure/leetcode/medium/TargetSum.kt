package `fun`.sure.leetcode.medium

import `fun`.sure.leetcode.Topics

/**
 * Created by wangshuo on 2021/10/13.
 */
class TargetSum: Topics.Array, Topics.DynamicProgramming, Topics.Backtracking {

    /**
     * You are given an integer array nums and an integer target.

    You want to build an expression out of nums by adding one of the symbols '+' and '-' before each integer in nums and then concatenate all the integers.

    For example, if nums = [2, 1], you can add a '+' before 2 and a '-' before 1 and concatenate them to build the expression "+2-1".
    Return the number of different expressions that you can build, which evaluates to target.



    Example 1:

    Input: nums = [1,1,1,1,1], target = 3
    Output: 5
    Explanation: There are 5 ways to assign symbols to make the sum of nums be target 3.
    -1 + 1 + 1 + 1 + 1 = 3
    +1 - 1 + 1 + 1 + 1 = 3
    +1 + 1 - 1 + 1 + 1 = 3
    +1 + 1 + 1 - 1 + 1 = 3
    +1 + 1 + 1 + 1 - 1 = 3
    Example 2:

    Input: nums = [1], target = 1
    Output: 1
     */

    /*
     * 思路
     * 回溯法
     */

    /*
    Success
    Runtime: 766 ms, faster than 20.45% of Kotlin online submissions for Target Sum.
    Memory Usage: 34.8 MB, less than 40.91% of Kotlin online submissions for Target Sum.
     */
    fun findTargetSumWays(nums: IntArray, target: Int): Int {
        val n = IntArray(1) { 0 }
        backtracking(nums, target, 0, 0, n)
        return n[0]
    }

    private fun backtracking(nums: IntArray, target: Int, index: Int, sum: Int, n: IntArray) {
        if (index == nums.size) {
            if (sum == target) {
                n[0]++
            }
            return
        }
        // +
        backtracking(nums, target, index + 1, sum + nums[index], n)

        // -
        backtracking(nums, target, index + 1, sum - nums[index], n)
    }
}