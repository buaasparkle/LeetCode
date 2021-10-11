package `fun`.sure.leetcode.medium

import `fun`.sure.leetcode.Topics

/**
 * Created by wangshuo on 2021/10/11.
 */
class PalindromicSubstrings: Topics.DynamicProgramming, Topics.String {

    /**
     * Given a string s, return the number of palindromic substrings in it.

    A string is a palindrome when it reads the same backward as forward.

    A substring is a contiguous sequence of characters within the string.



    Example 1:

    Input: s = "abc"
    Output: 3
    Explanation: Three palindromic strings: "a", "b", "c".
    Example 2:

    Input: s = "aaa"
    Output: 6
    Explanation: Six palindromic strings: "a", "a", "a", "aa", "aa", "aaa".


    Constraints:

    1 <= s.length <= 1000
    s consists of lowercase English letters.
     */

    /* 思路
     *
     * 以 i 为起点，长度为 j (举例，s = "abc", i = 0, j = 0 时表示元素 a，j 为 1 时表示 ab) 的表格中记录了
     * [i,j] 表示的字符串中回文的数量，则状态转移关系为(长度为 j 的结果由 j - 1 的结果中推导出)：
     *
     * i i+1, ...,i+(j-1), i+j
     * |______________|        + left j-1
     *     |_________________| + right j-1
     *     |__________|        - 重叠部分
     * |_____________________| + 如果整体是回文 +1，否则为 0
     *
     * table[i][j] = table[i][j-1] + table[i+1][j-1] - table[i+1][j-2] + isPalindromicSubString(i,j) ? 1 : 0
     */

    /*
    Success
    Runtime: 569 ms, faster than 24.53% of Kotlin online submissions for Palindromic Substrings.
    Memory Usage: 44 MB, less than 26.41% of Kotlin online submissions for Palindromic Substrings.
     */
    fun countSubstrings(s: String): Int {
        val length = s.length
        val table = Array<IntArray>(s.length) { IntArray(s.length) }
        for (i in 0 until length) {
            table[i][0] = 1
        }
        for (len in 1 until length) {
            for (i in 0 until length - len) {
                val intersection = if (len - 2 >= 0) table[i + 1][len - 2] else 0
                table[i][len] = table[i][len - 1] + table[i + 1][len - 1] - intersection +
                        if (isPalindromicString(s, i, len)) 1 else 0
            }
        }
        return table[0][length - 1]
    }

    fun isPalindromicString(s: String, start: Int, len: Int): Boolean {
        if (start + len >= s.length) {
            return false
        }
        var i = start
        var j = start + len
        while (i < j) {
            if (s[i] == s[j]) {
                i++
                j--
            } else {
                return false
            }
        }
        return true
    }


    /*
     * 参考：【高效】解法
     * 从中心往外延伸判断：区分奇偶的情况
     */
    fun countSubstrings2(s: String): Int {
        var total = 0
        for (i in 0 until s.length) {
            total += countSubstrings(s, i, i)
            total += countSubstrings(s, i, i + 1)
        }
        return total
    }

    fun countSubstrings(s: String, centerStartIndex: Int, centerEndIndex: Int): Int {
        var total = 0
        var start = centerStartIndex
        var end = centerEndIndex
        while (start > -1 && end < s.length && s[start] == s[end]) {
            total += 1
            start -= 1
            end += 1
        }
        return total
    }
}