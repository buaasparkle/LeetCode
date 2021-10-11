package `fun`.sure.leetcode.medium

import `fun`.sure.leetcode.Topics

/**
 * Created by wangshuo on 2021/10/11.
 */
class Trie : Topics.Trie, Topics.String, Topics.HashTable, Topics.Design {

    /**
     * A trie (pronounced as "try") or prefix tree is a tree data structure used to efficiently store and retrieve keys in a dataset of strings. There are various applications of this data structure, such as autocomplete and spellchecker.

    Implement the Trie class:

    Trie() Initializes the trie object.
    void insert(String word) Inserts the string word into the trie.
    boolean search(String word) Returns true if the string word is in the trie (i.e., was inserted before), and false otherwise.
    boolean startsWith(String prefix) Returns true if there is a previously inserted string word that has the prefix prefix, and false otherwise.


    Example 1:

    Input
    ["Trie", "insert", "search", "search", "startsWith", "insert", "search"]
    [[], ["apple"], ["apple"], ["app"], ["app"], ["app"], ["app"]]
    Output
    [null, null, true, false, true, null, true]

    Explanation
    Trie trie = new Trie();
    trie.insert("apple");
    trie.search("apple");   // return True
    trie.search("app");     // return False
    trie.startsWith("app"); // return True
    trie.insert("app");
    trie.search("app");     // return True


    Constraints:

    1 <= word.length, prefix.length <= 2000
    word and prefix consist only of lowercase English letters.
    At most 3 * 104 calls in total will be made to insert, search, and startsWith.
     */

    /*
    Success
    Runtime: 348 ms, faster than 83.38% of Kotlin online submissions for Implement Trie (Prefix Tree).
    Memory Usage: 57.5 MB, less than 59.44% of Kotlin online submissions for Implement Trie (Prefix Tree).
     */
    private val root = TrieNode(' ')

    fun insert(word: String) {
        var node: TrieNode = root
        word.forEach { c ->
            var next = node.children[c - 'a']
            if (next == null) {
                next = TrieNode(c)
                node.children[c - 'a'] = next
            }
            node = next
        }
        node.increaseCount()
    }

    fun search(word: String): Boolean {
        var node: TrieNode = root
        word.forEach { c ->
            val next = node.children[c - 'a']
            if (next != null) {
                node = next
            } else {
                return false
            }
        }
        return node.count() > 0 // 该节点需要是包含完整 word 的
    }

    fun startsWith(prefix: String): Boolean {
        var node: TrieNode = root
        prefix.forEach { c ->
            val next = node.children[c - 'a']
            if (next != null) {
                node = next
            } else {
                return false
            }
        }
        return true
    }

    inner class TrieNode(val prefix: Char) {
        val children = Array<TrieNode?>(26) { null }
        private var count: Int = 0 // 以该节点为结尾的单词数量

        fun increaseCount() {
            count++
        }

        fun count(): Int {
            return count
        }
    }
}