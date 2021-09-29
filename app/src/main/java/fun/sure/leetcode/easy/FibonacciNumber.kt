package `fun`.sure.leetcode.easy

import `fun`.sure.leetcode.Topics

/**
 * Created by wangshuo on 2021/9/29.
 */
class FibonacciNumber : Topics.DynamicProgramming, Topics.Math, Topics.Recursion, Topics.Memorization {

    /**
     * The Fibonacci numbers, commonly denoted F(n) form a sequence, called the Fibonacci sequence,
     * such that each number is the sum of the two preceding ones, starting from 0 and 1. That is,

    F(0) = 0, F(1) = 1
    F(n) = F(n - 1) + F(n - 2), for n > 1.
    Given n, calculate F(n).



    Example 1:

    Input: n = 2
    Output: 1
    Explanation: F(2) = F(1) + F(0) = 1 + 0 = 1.
    Example 2:

    Input: n = 3
    Output: 2
    Explanation: F(3) = F(2) + F(1) = 1 + 1 = 2.
    Example 3:

    Input: n = 4
    Output: 3
    Explanation: F(4) = F(3) + F(2) = 2 + 1 = 3.


    Constraints:

    0 <= n <= 30
     */

    /*
    Success
    Runtime: 120 ms, faster than 91.05% of Kotlin online submissions for Fibonacci Number.
    Memory Usage: 33.1 MB, less than 45.53% of Kotlin online submissions for Fibonacci Number.
     */
    fun fib(n: Int): Int {
        return when (n) {
            0 -> {
                0
            }
            1 -> {
                1
            }
            else -> {
                var pre_1 = 0
                var pre_2 = 1
                var acc = 0
                for (i in 2..n) {
                    acc = pre_1 + pre_2
                    pre_1 = pre_2
                    pre_2 = acc
                }
                acc
            }
        }
    }
}