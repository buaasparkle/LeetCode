package fun.sure.leetcode.medium;

import fun.sure.leetcode.common.DoublyNodeWithChild;

/**
 * Created by sure on 2018/9/13.
 */

public class FlattenMultilevelDoublyLinkedList {

    /**
     * You are given a doubly linked list which in addition to the next and previous pointers, it could have a child pointer, which may or may not point to a separate doubly linked list. These child lists may have one or more children of their own, and so on, to produce a multilevel data structure, as shown in the example below.

     Flatten the list so that all the nodes appear in a single-level, doubly linked list. You are given the head of the first level of the list.

     Example:

     Input:
     1---2---3---4---5---6--NULL
     |
     7---8---9---10--NULL
     |
     11--12--NULL

     Output:
     1-2-3-7-8-11-12-9-10-4-5-6-NULL
     */

    // [AC]
    public DoublyNodeWithChild flatten(DoublyNodeWithChild head) {
        if (head == null) {
            return null;
        }
        DoublyNodeWithChild headStart = head;
        while (head != null) {
            if (head.child != null) {
                DoublyNodeWithChild flatChildStart = flatten(head.child);
                DoublyNodeWithChild p = flatChildStart;
                while(p != null && p.next != null) {
                    p = p.next;
                }
                if (p != null) {
                    p.next = head.next;
                    if (head.next != null) {
                        head.next.prev = p;
                    }
                }
                if (flatChildStart != null) {
                    flatChildStart.prev = head;
                    head.next = flatChildStart;
                }
                head.child = null;
            }
            head = head.next;
        }
        return headStart;
    }
}
