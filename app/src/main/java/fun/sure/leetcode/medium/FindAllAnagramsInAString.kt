package `fun`.sure.leetcode.medium

import `fun`.sure.leetcode.Topics
import android.os.Build
import android.support.annotation.RequiresApi

/**
 * Created by wangshuo on 2021/10/13.
 */
class FindAllAnagramsInAString : Topics.Array, Topics.HashTable, Topics.SlidingWindow {

    /**
     * Given two strings s and p, return an array of all the start indices of p's anagrams in s.
     * You may return the answer in any order.

    An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase,
    typically using all the original letters exactly once.

    Example 1:

    Input: s = "cbaebabacd", p = "abc"
    Output: [0,6]
    Explanation:
    The substring with start index = 0 is "cba", which is an anagram of "abc".
    The substring with start index = 6 is "bac", which is an anagram of "abc".
    Example 2:

    Input: s = "abab", p = "ab"
    Output: [0,1,2]
    Explanation:
    The substring with start index = 0 is "ab", which is an anagram of "ab".
    The substring with start index = 1 is "ba", which is an anagram of "ab".
    The substring with start index = 2 is "ab", which is an anagram of "ab".


    Constraints:

    1 <= s.length, p.length <= 3 * 104
    s and p consist of lowercase English letters.

     */

    /*
     * 思路
     * 滑动窗口
     * 但是我的实现并没有体现滑动窗口。。。
     */

    /*
    Success
    Runtime: 2624 ms, faster than 15.11% of Kotlin online submissions for Find All Anagrams in a String.
    Memory Usage: 45 MB, less than 38.85% of Kotlin online submissions for Find All Anagrams in a String.
     */
    @RequiresApi(Build.VERSION_CODES.N)
    fun findAnagrams(s: String, p: String): List<Int> {
        val result = ArrayList<Int>()
        val needsMap = HashMap<Char, Int>()
        p.forEach {
            needsMap[it] = needsMap.getOrDefault(it, 0) + 1
        }
        val curMap = HashMap<Char, Int>()
        var left = 0
        val leftMax = s.length - p.length

        while (left <= leftMax) {
            while (left <= leftMax && !needsMap.containsKey(s[left])) {
                left++
            }
            if (left > leftMax) {
                break
            }
            var anyNotInNeeds = false
            for (i in left until left + p.length) {
                if (needsMap.containsKey(s[i])) {
                    curMap[s[i]] = curMap.getOrDefault(s[i], 0) + 1
                } else {
                    left = i + 1
                    anyNotInNeeds = true
                    break
                }
            }
            if (equalMaps(needsMap, curMap)) {
                result.add(left)
                left++
            } else if (!anyNotInNeeds){
                left++
            }
            curMap.clear()
        }
        return result
    }

    private fun equalMaps(a: HashMap<Char, Int>, b: HashMap<Char, Int>): Boolean {
        a.entries.forEach { (key, value) ->
            if (!b.containsKey(key) || value != b[key]) {
                return false
            }
        }
        b.entries.forEach { (key, value) ->
            if (!a.containsKey(key) || value != b[key]) {
                return false
            }
        }
        return true
    }
}