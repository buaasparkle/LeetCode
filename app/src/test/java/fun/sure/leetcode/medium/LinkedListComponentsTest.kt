package `fun`.sure.leetcode.medium

import `fun`.sure.leetcode.common.ListNode
import org.junit.Assert.*
import org.junit.Test

/**
 * Created by wangshuo on 2020/9/19.
 */
class LinkedListComponentsTest {

    private val solution = LinkedListComponents()

    @Test
    fun testcase1() {
        // head: 0->1->2->3
        // G = [0, 1, 3]
        // Output: 2
        val dummy = ListNode(-1)
        (0..3).fold(dummy, { node: ListNode, value: Int ->
            val newNode = ListNode(value)
            node.next = newNode
            newNode
        })
        val G = intArrayOf(0, 1, 3)
        assertEquals(2, solution.numComponents(dummy.next, G))
    }

    @Test
    fun testcase2() {
        // head: 0->1->2->3->4
        // G = [0, 3, 1, 4]
        // Output: 2
        val dummy = ListNode(-1)
        (0..4).fold(dummy, { node: ListNode, value: Int ->
            val newNode = ListNode(value)
            node.next = newNode
            newNode
        })
        val G = intArrayOf(0, 3, 1, 4)
        assertEquals(2, solution.numComponents(dummy.next, G))
    }

    @Test
    fun testcase3() {
        // head: 1->2->0->4->3
        // G = [3,4,0,2,1]
        // Output: 1
        val dummy = ListNode(-1)
        intArrayOf(1, 2, 0, 4, 3).fold(dummy, { node: ListNode, value: Int ->
            val newNode = ListNode(value)
            node.next = newNode
            newNode
        })
        val G = intArrayOf(3, 4, 0, 2, 1)
        assertEquals(1, solution.numComponents(dummy.next, G))
    }
}