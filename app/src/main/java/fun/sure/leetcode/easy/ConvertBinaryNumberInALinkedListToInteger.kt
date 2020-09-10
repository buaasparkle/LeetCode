package `fun`.sure.leetcode.easy

import `fun`.sure.leetcode.common.ListNode

/**
 * Created by wangshuo on 2020/9/10.
 */
class ConvertBinaryNumberInALinkedListToInteger {

    /**
    Given head which is a reference node to a singly-linked list. The value of each node in the linked list is either 0 or 1.
    The linked list holds the binary representation of a number.

    Return the decimal value of the number in the linked list.

    Example 1:


    Input: head = [1,0,1]
    Output: 5
    Explanation: (101) in base 2 = (5) in base 10
    Example 2:

    Input: head = [0]
    Output: 0
    Example 3:

    Input: head = [1]
    Output: 1
    Example 4:

    Input: head = [1,0,0,1,0,0,1,1,1,0,0,0,0,0,0]
    Output: 18880
    Example 5:

    Input: head = [0,0]
    Output: 0


    Constraints:

    The Linked List is not empty.
    Number of nodes will not exceed 30.
    Each node's value is either 0 or 1.
     */

    /**
     * Success
     * Runtime: 164 ms, faster than 45.24% of Kotlin online submissions for Convert Binary Number in a Linked List to Integer.
     * Memory Usage: 32.1 MB, less than 88.09% of Kotlin online submissions for Convert Binary Number in a Linked List to Integer.
     */
    fun getDecimalValue(head: ListNode?): Int {
        var sum = 0
        var p = head
        while (p != null) {
            sum = sum shl 1
            sum += p.`val`
            p = p.next
        }
        return sum
    }
}