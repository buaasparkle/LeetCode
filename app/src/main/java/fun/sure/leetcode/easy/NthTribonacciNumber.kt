package `fun`.sure.leetcode.easy

/**
 * Created by wangshuo on 2021/9/29.
 */
class NthTribonacciNumber {

    /**
     * The Tribonacci sequence Tn is defined as follows:

    T0 = 0, T1 = 1, T2 = 1, and Tn+3 = Tn + Tn+1 + Tn+2 for n >= 0.

    Given n, return the value of Tn.



    Example 1:

    Input: n = 4
    Output: 4
    Explanation:
    T_3 = 0 + 1 + 1 = 2
    T_4 = 1 + 1 + 2 = 4
    Example 2:

    Input: n = 25
    Output: 1389537
     */

    /*
    Success
    Runtime: 116 ms, faster than 95.43% of Kotlin online submissions for N-th Tribonacci Number.
    Memory Usage: 32.9 MB, less than 53.81% of Kotlin online submissions for N-th Tribonacci Number.
     */
    fun tribonacci(n: Int): Int {
        return when (n) {
            0 -> {
                0
            }
            1 -> {
                1
            }
            2 -> {
                1
            }
            else -> {
                var pre_1 = 0
                var pre_2 = 1
                var pre_3 = 1
                var acc = 0
                for (i in 3..n) {
                    acc = pre_1 + pre_2 + pre_3
                    pre_1 = pre_2
                    pre_2 = pre_3
                    pre_3 = acc
                }
                acc
            }
        }
    }
}