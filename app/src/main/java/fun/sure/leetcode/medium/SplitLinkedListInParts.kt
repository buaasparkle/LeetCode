package `fun`.sure.leetcode.medium

import `fun`.sure.leetcode.common.ListNode

/**
 * Created by wangshuo on 2020/9/10.
 */
class SplitLinkedListInParts {

    /**
     * Given a (singly) linked list with head node root, write a function to split the linked list into k consecutive linked list "parts".

    The length of each part should be as equal as possible: no two parts should have a size differing by more than 1. This may lead to some parts being null.

    The parts should be in order of occurrence in the input list, and parts occurring earlier should always have a size greater than or equal parts occurring later.

    Return a List of ListNode's representing the linked list parts that are formed.

    Examples 1->2->3->4, k = 5 // 5 equal parts [ [1], [2], [3], [4], null ]
    Example 1:
    Input:
    root = [1, 2, 3], k = 5
    Output: [[1],[2],[3],[],[]]
    Explanation:
    The input and each element of the output are ListNodes, not arrays.
    For example, the input root has root.val = 1, root.next.val = 2, \root.next.next.val = 3, and root.next.next.next = null.
    The first element output[0] has output[0].val = 1, output[0].next = null.
    The last element output[4] is null, but it's string representation as a ListNode is [].
    Example 2:
    Input:
    root = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10], k = 3
    Output: [[1, 2, 3, 4], [5, 6, 7], [8, 9, 10]]
    Explanation:
    The input has been split into consecutive parts with size difference at most 1, and earlier parts are a larger size than the later parts.
    Note:

    The length of root will be in the range [0, 1000].
    Each value of a node in the input will be an integer in the range [0, 999].
    k will be an integer in the range [1, 50].
     */

    /**
     * Success
     * Runtime: 196 ms, faster than 13.33% of Kotlin online submissions for Split Linked List in Parts.
     * Memory Usage: 34.4 MB, less than 26.67% of Kotlin online submissions for Split Linked List in Parts.
     */
    fun splitListToParts(root: ListNode?, k: Int): Array<ListNode?> {
        val len = listLength(root)
        val avg = len / k
        val remainder = len % k

        val countArray = IntArray(k) { avg }
        (0 until remainder).forEach { countArray[it] += 1 }

        val splitArray = mutableListOf<ListNode?>()
        var p = root
        countArray.forEach { count ->
            val dummy = ListNode(0)
            var q = dummy
            (0 until count).forEach { _ ->
                p = p?.let {
                    q.next = ListNode(it.`val`)
                    q = q.next
                    it.next
                }
            }
            splitArray.add(dummy.next)
        }
        return splitArray.toTypedArray()
    }

    private fun listLength(root: ListNode?): Int {
        var len = 0
        var p = root
        while (p != null) {
            p = p.next
            len++
        }
        return len
    }
}