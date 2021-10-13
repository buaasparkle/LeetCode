package `fun`.sure.leetcode.easy

import `fun`.sure.leetcode.Topics

/**
 * Created by wangshuo on 2021/10/13.
 */
class MaximumSubarray: Topics.DynamicProgramming, Topics.Array {

    /**
     * Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.

    A subarray is a contiguous part of an array.



    Example 1:

    Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
    Output: 6
    Explanation: [4,-1,2,1] has the largest sum = 6.
    Example 2:

    Input: nums = [1]
    Output: 1
    Example 3:

    Input: nums = [5,4,-1,7,8]
    Output: 23


    Constraints:

    1 <= nums.length <= 105
    -104 <= nums[i] <= 104
     */


    /*
     * 思路：DP
     * dp[i] 表示以 i 为结尾的最大字串长
     * 状态转移方程：
     * dp[i] = max { dp[i-1] + nums[i], nums[i] }, i in [1, len-1]
     * dp[0] = 0
     */

    /*
      Success
      Runtime: 970 ms, faster than 5.09% of Kotlin online submissions for Maximum Subarray.
      Memory Usage: 101.1 MB, less than 5.09% of Kotlin online submissions for Maximum Subarray.
     */
    fun maxSubArray(nums: IntArray): Int {
        var max = Int.MIN_VALUE
        var dp_pre = 0
        var dp_cur: Int
        nums.forEach { num ->
            dp_cur = Math.max(dp_pre + num, num)
            max = Math.max(max, dp_cur)
            dp_pre = dp_cur
        }
        return max
    }
}