package fun.sure.leetcode.easy;

import fun.sure.leetcode.common.ListNode;

/**
 * Created by wangshuo on 2016/6/19.
 */
public class RemoveLinkedListElements {

    /**
     * Remove all elements from a linked list of integers that have value val.

     Example
     Given: 1 --> 2 --> 6 --> 3 --> 4 --> 5 --> 6, val = 6
     Return: 1 --> 2 --> 3 --> 4 --> 5
     */

    public ListNode removeElements(ListNode head, int val) {
        if (head == null) {
            return null;
        }
        ListNode result;
        ListNode p = head;
        while (p != null && p.val == val) {
            p = p.next;
        }
        result = p;
        while (p!= null && p.next != null) {
            if (p.next.val != val) {
                p = p.next;
            } else {
                p.next = removeElements(p.next, val);
            }
        }
        return result;
    }
}
