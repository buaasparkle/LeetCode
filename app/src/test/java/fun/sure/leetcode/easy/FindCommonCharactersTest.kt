package `fun`.sure.leetcode.easy

import org.junit.Assert.*
import org.junit.Test

/**
 * Created by wangshuo on 2020/7/11.
 */
class FindCommonCharactersTest {

    private val findCommonChar = FindCommonCharacters()

    @Test
    fun test1() {
        val testcase = arrayOf(
                "bella",
                "label",
                "roller"
        )
        val res = findCommonChar.commonChars(testcase)
        assertEquals(3, res.size)
        assertArrayEquals(arrayOf("e", "l", "l"), res.toTypedArray())
    }

    @Test
    fun test2() {
        val testcase = arrayOf(
                "cool",
                "lock",
                "cook"
        )
        val res = findCommonChar.commonChars(testcase)
        assertEquals(2, res.size)
        assertArrayEquals(arrayOf("c", "o"), res.toTypedArray())
    }

    @Test
    fun test3() {
        val testcase = arrayOf(
                "acabcddd",
                "bcbdbcbd",
                "baddbadb",
                "cbdddcac",
                "aacbcccd",
                "ccccddda",
                "cababaab",
                "addcaccd"
        )
        val res = findCommonChar.commonChars(testcase)
        assertEquals(0, res.size)
        assertArrayEquals(arrayOf(), res.toTypedArray())
    }

    @Test
    fun test4() {
        val testcase = arrayOf(
                "bbddabab", "cbcddbdd", "bbcadcab", "dabcacad", "cddcacbc", "ccbdbcba", "cbddaccc", "accdcdbb"
        )
        val res = findCommonChar.commonChars(testcase)
        assertArrayEquals(arrayOf("b", "d"), res.toTypedArray())
    }
}