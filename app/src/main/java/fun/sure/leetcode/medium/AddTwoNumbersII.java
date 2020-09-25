package fun.sure.leetcode.medium;

import fun.sure.leetcode.common.ListNode;

/**
 * Created by wangshuo on 2020/9/25.
 */
class AddTwoNumbersII {

    /**
     * You are given two non-empty linked lists representing two non-negative integers.
     * The most significant digit comes first and each of their nodes contain a single digit.
     * Add the two numbers and return it as a linked list.
     * <p>
     * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
     * <p>
     * Follow up:
     * What if you cannot modify the input lists? In other words, reversing the lists is not allowed.
     * <p>
     * Example:
     * Input: (7 -> 2 -> 4 -> 3) + (5 -> 6 -> 4)
     * Output: 7 -> 8 -> 0 -> 7
     */

    /*
     * 思路：
     * 先按照从高位到低位的顺序相加，需要空出"长"出来的高位，记录累加和到节点，构造出新的链表
     * 对新的链表逆序，从低位算进位相加
     * 最后再逆序返回
     */

    /*
    Success
    Runtime: 2 ms, faster than 98.96% of Java online submissions for Add Two Numbers II.
    Memory Usage: 39.7 MB, less than 63.35% of Java online submissions for Add Two Numbers II.
     */

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int len1 = linkLength(l1);
        int len2 = linkLength(l2);
        ListNode longLink = len1 >= len2 ? l1 : l2;
        ListNode shortLink = len1 < len2 ? l1 : l2;
        int delta = Math.abs(len1 - len2);

        ListNode dummyNode = new ListNode(-1);
        ListNode longP = longLink;
        ListNode shortP = shortLink;
        ListNode resultP = dummyNode;

        for (int i = 0; i < delta; i++) {
            ListNode node = new ListNode(longP.val);
            resultP.next = node;
            resultP = node;
            longP = longP.next;
        }
        while (shortP != null && longP != null) {
            resultP.next = new ListNode(longP.val + shortP.val);
            resultP = resultP.next;
            shortP = shortP.next;
            longP = longP.next;
        }
        ListNode reversed = reverse(dummyNode.next);
        int carry = 0;
        resultP = reversed;
        ListNode tail = null;
        while (resultP != null) {
            int value = resultP.val + carry;
            carry = value / 10;
            resultP.val = value % 10;
            tail = resultP;
            resultP = resultP.next;
        }
        if (carry > 0) {
            tail.next = new ListNode(carry);
        }
        return reverse(reversed);
    }

    private int linkLength(ListNode p) {
        int len = 0;
        while (p != null) {
            p = p.next;
            len++;
        }
        return len;
    }

    private ListNode reverse(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }
}
