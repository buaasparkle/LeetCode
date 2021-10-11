package `fun`.sure.leetcode.medium

import `fun`.sure.leetcode.Topics
import java.util.*

/**
 * Created by wangshuo on 2021/10/11.
 */
class DailyTemperatures: Topics.Array, Topics.Stack, Topics.MonotonicStack {

    /**
     * Given an array of integers temperatures represents the daily temperatures, return an array answer such that answer[i] is the number of days you have to wait after the ith day to get a warmer temperature. If there is no future day for which this is possible, keep answer[i] == 0 instead.



    Example 1:

    Input: temperatures = [73,74,75,71,69,72,76,73]
    Output: [1,1,4,2,1,1,0,0]
    Example 2:

    Input: temperatures = [30,40,50,60]
    Output: [1,1,1,0]
    Example 3:

    Input: temperatures = [30,60,90]
    Output: [1,1,0]


    Constraints:

    1 <= temperatures.length <= 105
    30 <= temperatures[i] <= 100

     */

    /*
     * 思路：单调栈
     * https://labuladong.gitee.io/algo/2/21/46/
     * 单调栈用途不太广泛，只处理一种典型的问题，叫做 Next Greater Element
     */

    /*
    Success
    Runtime: 1034 ms, faster than 35.42% of Kotlin online submissions for Daily Temperatures.
    Memory Usage: 107.8 MB, less than 8.33% of Kotlin online submissions for Daily Temperatures.
     */
    fun dailyTemperatures(temperatures: IntArray): IntArray {
        val ret = IntArray(temperatures.size) { 0 }
        val stack = Stack<Int>()
        for (index in temperatures.size - 1 downTo 0) {
            val temperature = temperatures[index]
            while (stack.isNotEmpty() && temperatures[stack.peek()] <= temperature) {
                stack.pop()
            }
            ret[index] = if (stack.isEmpty()) 0 else stack.peek() - index
            stack.push(index)
        }
        return ret
    }
}