package fun.sure.leetcode.common;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wangshuo on 2016/6/19.
 */
public class ListNode {
    public int val;
    public ListNode next;

    public ListNode(int x) {
        val = x;
        next = null;
    }

    public static ListNode createLinkListFromArray(int[] array) {
        ListNode dummy = new ListNode(-1);
        ListNode p = dummy;
        for (int value : array) {
            p.next = new ListNode(value);
            p  = p.next;
        }
        return dummy.next;
    }

    public static int[] link2Array(ListNode head) {
        if (head == null) {
            return null;
        }
        List<Integer> list = new ArrayList<>();
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }

        int[] array = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            array[i] = list.get(i);
        }
        return array;
    }
}
