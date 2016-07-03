package fun.sure.leetcode.easy;

import fun.sure.leetcode.common.ListNode;

/**
 * Created by wangshuo on 2016/6/12.
 */
public class ReverseLinkedList {

    // [PASS]
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode p = null;
        ListNode q = head;
        ListNode r = q.next;
        while (r != null) {
            q.next = p;
            p = q;
            q = r;
            r = r.next;
        }
        q.next = p;
        return q;
    }
}
