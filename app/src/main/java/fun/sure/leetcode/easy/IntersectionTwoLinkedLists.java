package fun.sure.leetcode.easy;

import fun.sure.leetcode.common.ListNode;

/**
 * Created by wangshuo on 2016/6/13.
 */
public class IntersectionTwoLinkedLists {

    /**
     * Write a program to find the node at which the intersection of two singly linked lists begins.


     For example, the following two linked lists:

     A:          a1 → a2
     ↘
     c1 → c2 → c3
     ↗
     B:     b1 → b2 → b3
     begin to intersect at node c1.


     Notes:

     If the two linked lists have no intersection at all, return null.
     The linked lists must retain their original structure after the function returns.
     You may assume there are no cycles anywhere in the entire linked structure.
     Your code should preferably run in O(n) time and use only O(1) memory.

     */

    // [PASS]
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lengthA = getLinkLength(headA);
        int lengthB = getLinkLength(headB);
        if (lengthA == 0 || lengthB == 0) {
            return null;
        }
        ListNode nodeLong = lengthA >= lengthB ? headA : headB;
        ListNode nodeShort = lengthA >= lengthB ? headB : headA;
        int delta = Math.abs(lengthA - lengthB);
        while (delta > 0) {
            nodeLong = nodeLong.next;
            delta--;
        }
        while (nodeLong != null) {
            if (nodeLong.val == nodeShort.val) {
                return nodeLong;
            }
            nodeLong = nodeLong.next;
            nodeShort = nodeShort.next;
        }
        return null;
    }

    private int getLinkLength(ListNode node) {
        int length = 0;
        ListNode p = node;
        while (p != null) {
            p = p.next;
            length++;
        }
        return length;
    }
}
