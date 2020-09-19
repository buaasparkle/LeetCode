package `fun`.sure.leetcode.medium

import `fun`.sure.leetcode.common.ListNode

/**
 * Created by wangshuo on 2020/9/19.
 */
class LinkedListComponents {

    /**
     * We are given head, the head node of a linked list containing unique integer values.

    We are also given the list G, a subset of the values in the linked list.

    Return the number of connected components in G, where two values are connected if they appear consecutively in the linked list.

    Example 1:

    Input:
    head: 0->1->2->3
    G = [0, 1, 3]
    Output: 2
    Explanation:
    0 and 1 are connected, so [0, 1] and [3] are the two connected components.
    Example 2:

    Input:
    head: 0->1->2->3->4
    G = [0, 3, 1, 4]
    Output: 2
    Explanation:
    0 and 1 are connected, 3 and 4 are connected, so [0, 1] and [3, 4] are the two connected components.
    Note:

    If N is the length of the linked list given by head, 1 <= N <= 10000.
    The value of each node in the linked list will be in the range [0, N - 1].
    1 <= G.length <= 10000.
    G is a subset of all values in the linked list.
     */

    /*
     * 思路
     * 遍历链表，找到可能的最长的连接节点（满足值在 G 中），直到遇到不满足的情况，此时连接数 +1
     *
     * 如果每次遍历节点查值，时间复杂度应该是 O(N2)，考虑先排序 G，再二分找？能降低到 O(NlogN)
     */

    /*
     * Success
     * Runtime: 248 ms, faster than 100.00% of Kotlin online submissions for Linked List Components.
     * Memory Usage: 38 MB, less than 50.00% of Kotlin online submissions for Linked List Components.
     */
    fun numComponents(head: ListNode?, G: IntArray): Int {
        var num = 0
        val sortedG = G.sortedArray()
        var cur = head
        var continuesFound = false
        while (cur != null) {
            if (sortedG.binarySearch(cur.`val`, 0, sortedG.size) < 0) {
                if (continuesFound) {
                    num += 1
                }
                continuesFound = false
            } else {
                continuesFound = true
            }
            cur = cur.next
        }
        if (continuesFound) {
            num += 1
        }
        return num
    }


    /* 思路
     * 遍历链表
     * 1. 看链表相邻节点是否在 G 中出现
     *    - 如果有，从 G 中 remove 对应值
     *    - 如果只匹配了一个，遍历节点跳到匹配的那个节点之后继续
     *    - 如果没有匹配，跳到后面继续
     * 2. 如果无法构造出相邻，看单个
     * 直到遍历链表结束
     *
     * !!!!!
     * 题目理解错了，不是一对儿判断 connected，而是可以连接的最长情况
     * !!!!!
     */
    fun numComponents0(head: ListNode?, G: IntArray): Int {
        var cur: ListNode? = head
        var next: ListNode?
        val listG = G.toMutableList()
        var num = 0
        while (cur != null) {
            next = cur.next
            val result = checkConnected(cur, next, listG)
            when(result.resultType) {
                ConnectedResult.ALL -> {
                    num += 1
                    listG.remove(cur.`val`)
                    listG.remove(next.`val`)
                    cur = next.next
                }
                ConnectedResult.PRE -> {
                    num += 1
                    listG.remove(cur.`val`)
                    cur = next?.next
                }
                ConnectedResult.POST -> {
                    // 移动到 next，因为后面可能会有连续的配对
                    cur = next
                }
                ConnectedResult.NONE -> {
                    cur = next?.next
                }
                else -> {}
            }
        }
        return num
    }

    private fun checkConnected(pre: ListNode?, cur: ListNode?, G: List<Int>): ConnectedResult {
        val preContains = checkValueInArray(pre, G)
        val curContains = checkValueInArray(cur, G)
        return when {
            preContains && curContains -> ConnectedResult(ConnectedResult.ALL)
            preContains -> ConnectedResult(ConnectedResult.PRE)
            curContains -> ConnectedResult(ConnectedResult.POST)
            else -> ConnectedResult(ConnectedResult.NONE)
        }
    }

    private fun checkValueInArray(node: ListNode?, G: List<Int>): Boolean {
        return node?.let { G.contains(it.`val`) } ?: false
    }

    private class ConnectedResult(
            val resultType: Int // 匹配结果类型
    ) {
        companion object {
            const val NONE = 0  // 未匹配
            const val ALL = 1   // 全匹配
            const val PRE = 2 // 只匹配前一个
            const val POST = 3 // 只匹配后一个
        }
    }
}