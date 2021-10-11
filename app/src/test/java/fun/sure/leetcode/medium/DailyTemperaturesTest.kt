package `fun`.sure.leetcode.medium

import org.junit.Test

import org.junit.Assert.*

/**
 * Created by wangshuo on 2021/10/11.
 */
class DailyTemperaturesTest {

    private val target = DailyTemperatures()

    @Test
    fun dailyTemperatures() {
        var temperatures = intArrayOf(73, 74, 75, 71, 69, 72, 76, 73)
        assertArrayEquals(intArrayOf(1, 1, 4, 2, 1, 1, 0, 0), target.dailyTemperatures(temperatures))

        temperatures = intArrayOf(30, 40, 50, 60)
        assertArrayEquals(intArrayOf(1, 1, 1, 0), target.dailyTemperatures(temperatures))
    }
}