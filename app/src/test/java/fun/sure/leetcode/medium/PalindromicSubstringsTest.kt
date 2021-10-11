package `fun`.sure.leetcode.medium

import org.junit.Test

import org.junit.Assert.*

/**
 * Created by wangshuo on 2021/10/11.
 */
class PalindromicSubstringsTest {

    private val target = PalindromicSubstrings()

    @Test
    fun countSubstrings() {
        var ret = target.countSubstrings("abc")
        assertEquals(3, ret)

        ret = target.countSubstrings("aaa")
        assertEquals(6, ret)

        ret = target.countSubstrings("aba")
        assertEquals(4, ret)
    }

    @Test
    fun isPalindromicString() {
        val testcase1 = "aba"
        var ret = target.isPalindromicString(testcase1, 0, 0)
        assertEquals(true, ret)

        ret = target.isPalindromicString(testcase1, 0, 2)
        assertEquals(true, ret)

        ret = target.isPalindromicString(testcase1, 0, 1)
        assertEquals(false, ret)
    }
}