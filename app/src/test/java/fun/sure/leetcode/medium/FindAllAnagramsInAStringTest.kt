package `fun`.sure.leetcode.medium

import org.junit.Test

import org.junit.Assert.*

/**
 * Created by wangshuo on 2021/10/13.
 */
class FindAllAnagramsInAStringTest {

    private val target = FindAllAnagramsInAString()

    @Test
    fun findAnagrams() {
        assertEquals(intArrayOf(0, 6).asList(), target.findAnagrams("cbaebabacd", "abc"))
        assertEquals(intArrayOf(0, 1, 2).asList(), target.findAnagrams("abab", "ab"))
        assertEquals(intArrayOf(1, 3, 6, 7).asList(), target.findAnagrams("acdcaeccde", "c"))
        assertEquals(intArrayOf(0, 2, 4, 6).asList(), target.findAnagrams("ababababab", "aab"))
    }
}