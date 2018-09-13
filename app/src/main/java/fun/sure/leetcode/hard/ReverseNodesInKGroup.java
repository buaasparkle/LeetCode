package fun.sure.leetcode.hard;

import fun.sure.leetcode.common.ListNode;

/**
 * Created by sure on 2018/9/13.
 */

public class ReverseNodesInKGroup {

    /**
     * Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.

     k is a positive integer and is less than or equal to the length of the linked list. If the number of nodes is not a multiple of k then left-out nodes in the end should remain as it is.

     Example:

     Given this linked list: 1->2->3->4->5

     For k = 2, you should return: 2->1->4->3->5

     For k = 3, you should return: 3->2->1->4->5

     Note:

     Only constant extra memory is allowed.
     You may not alter the values in the list's nodes, only nodes itself may be changed.
     */

    // [AC]
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || k <= 1) {
            return head;
        }
        int listLen = listLength(head);

        ListNode reversedHead = null;
        ListNode pre = null;
        ListNode cur = head;
        ListNode next;
        while (cur != null) {
            NodePair pair = reverseLink(cur, listLen, k);
            if (reversedHead == null) {
                reversedHead = pair.node;
            }
            if (pre != null) {
                pre.next = pair.node;
            }
            next = pair.nextNode;
            if (pair.reversed) {
                cur.next = next;
            }
            pre = cur;
            cur = next;
            listLen -= k;
        }
        return reversedHead;
    }

    // NodePair 返回两个结点
    // node 表示 逆序之后的头结点
    // nextNode 表示 逆序到最后一个结点时的下一个结点
    // reversed 表示 是否逆序了
    private NodePair reverseLink(ListNode head, int listLen, int lenLimit) {
        NodePair pair = new NodePair(head, null, false);
        if (head == null || listLen < lenLimit) {
            return pair;
        }
        ListNode pre = null;
        ListNode cur = head;
        ListNode next;
        int len = 0;
        while (cur != null && len < lenLimit) {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
            len++;

            pair.node = pre;
            pair.nextNode = cur;
            pair.reversed = true;
        }
        return pair;
    }

    private int listLength(ListNode head) {
        int len = 0;
        ListNode p = head;
        while (p != null) {
            len++;
            p = p.next;
        }
        return len;
    }

    private static class NodePair {
        ListNode node;
        ListNode nextNode;
        boolean reversed;

        NodePair(ListNode node, ListNode nextNode, boolean reversed) {
            this.node = node;
            this.nextNode = nextNode;
            this.reversed = reversed;
        }
    }
}
