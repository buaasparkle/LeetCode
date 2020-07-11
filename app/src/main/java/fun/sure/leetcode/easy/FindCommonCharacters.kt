package `fun`.sure.leetcode.easy

import java.util.ArrayList

/**
 * Created by wangshuo on 2020/7/11.
 */
class FindCommonCharacters {

    /**
     *  Given an array A of strings made only from lowercase letters,
     *  return a list of all characters that show up in all strings within the list (including duplicates).
     *  For example, if a character occurs 3 times in all strings but not 4 times,
     *  you need to include that character three times in the final answer.
     *
     *  You may return the answer in any order.
     *
     *  Example 1:
     *  Input: ["bella","label","roller"]
     *  Output: ["e","l","l"]
     *
     *  Example 2:
     *  Input: ["cool","lock","cook"]
     *  Output: ["c","o"]
     */

    // [wrong] 没有考虑每个 word 都要包含的场景
    fun commonChars0(A: Array<String>): List<String> {
        val wordCount = A.size
        val charMap = mutableMapOf<Char, Pair<Int, Int>>() // 记录每个字符的个数

        A.forEachIndexed { wordIndex, word ->
            word.toCharArray().forEach { c ->
                var idx = charMap[c]?.first ?: 0
                var count = charMap[c]?.second ?: 0
                if (idx == wordIndex) {
                    idx++
                }
                count += 1
                charMap[c] = idx to count
            }
        }

        val resArray = ArrayList<String>()
        charMap.entries.filter { it.value.first == wordCount }
                .forEach { entry ->
                    (0 until entry.value.second / wordCount).forEach { _ ->
                        resArray.add(entry.key.toString())
                    }
                }
        return resArray
    }

    /**
     * Success
     *
     * Runtime: 540 ms, faster than 5.88% of Kotlin online submissions for Find Common Characters.
     * Memory Usage: 49.4 MB, less than 20.00% of Kotlin online submissions for Find Common Characters.
     */
    fun commonChars(A: Array<String>): List<String> {
        return A.map { wordToCharCountMap(it) } // // 找出每个词中字符数量的 map
                .reduce(::mergeCharCountMaps) // 合并 map，保留公共部分
                .toList() // 转为 pair list
                .flatMap (::repeatCharToList) // repeatCharToList 将 （'a', 3) -> ["a", "a", "a"]
    }

    private fun wordToCharCountMap(word: String): Map<Char, Int> {
        val map = mutableMapOf<Char, Int>()
        word.toCharArray().forEach { c ->
            val count = map[c] ?: 0
            map[c] = count + 1
        }
        return map;
    }

    private fun mergeCharCountMaps(map1: Map<Char, Int>, map2: Map<Char, Int>): Map<Char, Int> {
        val keys1 = map1.filter { it.value > 0 }.map { it.key }
        val keys2 = map2.filter { it.value > 0 }.map { it.key }
        val commonKeys = keys1.intersect(keys2)

        var resMap = mutableMapOf<Char, Int>()
        if (commonKeys.isNotEmpty()) {
            resMap = commonKeys.fold(resMap) { acc, c ->
                acc[c] = Math.min(map1.getValue(c), map2.getValue(c))
                acc
            }
        }
        return resMap
    }

    private fun repeatCharToList(pair: Pair<Char, Int>): List<String> {
        return (0 until pair.second).fold(mutableListOf()) { acc, _ ->
            acc.add(pair.first.toString())
            acc
        }
    }
}