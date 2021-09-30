package `fun`.sure.leetcode.easy

import `fun`.sure.leetcode.Topics

/**
 * Created by wangshuo on 2021/9/30.
 */
class ClimbingStairs : Topics.Math, Topics.DynamicProgramming, Topics.Memorization {

    /**
     * You are climbing a staircase. It takes n steps to reach the top.

    Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?



    Example 1:

    Input: n = 2
    Output: 2
    Explanation: There are two ways to climb to the top.
    1. 1 step + 1 step
    2. 2 steps
    Example 2:

    Input: n = 3
    Output: 3
    Explanation: There are three ways to climb to the top.
    1. 1 step + 1 step + 1 step
    2. 1 step + 2 steps
    3. 2 steps + 1 step


    Constraints:

    1 <= n <= 45

     */

    /*
    Success
    Runtime: 120 ms, faster than 86.98% of Kotlin online submissions for Climbing Stairs.
    Memory Usage: 32.8 MB, less than 62.25% of Kotlin online submissions for Climbing Stairs.
     */
    fun climbStairs(n: Int): Int {
        val mem = IntArray(n + 1)
        mem[0] = 0
        mem[1] = 1
        for (i in 2..n) {
            mem[i] = mem[i - 1] + mem[i - 2]
        }
        return mem[n]
    }
}