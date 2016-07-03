package fun.sure.leetcode.easy;

import fun.sure.leetcode.common.ListNode;

/**
 * Created by wangshuo on 2016/6/7.
 */
public class DeleteNodeInALinkedList {

    /**
     * Write a function to delete a node (except the tail) in a singly linked list, given only access to that node.
     * Supposed the linked list is 1 -> 2 -> 3 -> 4 and you are given the third node with value 3,
     * the linked list should become 1 -> 2 -> 4 after calling your function.
     *
     */

    // [PASS] 坑点：不用非得知道node的前一个节点是啥，只要把node下一个节点的值copy到node上，并且指向下下个节点就好了
    public void deleteNode(ListNode node) {
        ListNode next = node.next;
        node.val = next.val;
        node.next = next.next;
    }
}
