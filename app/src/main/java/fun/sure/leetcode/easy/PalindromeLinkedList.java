package fun.sure.leetcode.easy;

import fun.sure.leetcode.common.ListNode;

/**
 * Created by wangshuo on 2016/6/19.
 */
public class PalindromeLinkedList {

    /**
     * Given a singly linked list, determine if it is a palindrome.

     Follow up:
     Could you do it in O(n) time and O(1) space?
     */

    // [PASS] 还可以考虑找到mid后，前半段进栈，后半段同出站逐个比较，可以不破坏listnode的结构
    public boolean isPalindrome(ListNode head) {
        int length = getLinkLength(head);
        if (length == 0) {
            return false;
        } else if (length == 1) {
            return true;
        } else {
            int mid = length / 2;
            ListNode p = head;
            int count = 1;
            while (count < mid) {
                p = p.next;
                count++;
            }
            ListNode q = p;
            p = length % 2 == 0 ? p.next : p.next.next;
            q.next = null;
            return isSameLink(reverseLink(head), p);
        }
    }

    private int getLinkLength(ListNode head) {
        int count = 0;
        ListNode p = head;
        while (p != null) {
            p = p.next;
            count++;
        }
        return count;
    }

    private ListNode reverseLink(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode p = head;
        ListNode q = null;
        ListNode tmp;
        while (p.next != null) {
            tmp = p.next;
            p.next = q;
            q = p;
            p = tmp;
        }
        p.next = q;
        return p;
    }

    private boolean isSameLink(ListNode link1, ListNode link2) {
        if (link1 == null && link2 == null) {
            return true;
        } else if (link1 == null || link2 == null) {
            return false;
        } else {
            ListNode p = link1;
            ListNode q = link2;
            while (p != null && q != null) {
                if (p.val != q.val) {
                    return false;
                }
                p = p.next;
                q = q.next;
            }
            return p == null && q == null;
        }
    }
}
