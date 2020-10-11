package fun.sure.leetcode.medium;

import org.junit.Assert;
import org.junit.Test;

import fun.sure.leetcode.common.ListNode;

/**
 * Created by wangshuo on 2020/10/11.
 */
public class RemoveZeroSumConsecutiveNodesFromLinkedListTest {

    private RemoveZeroSumConsecutiveNodesFromLinkedList solution = new RemoveZeroSumConsecutiveNodesFromLinkedList();

    @Test
    public void testcase1() {
        ListNode head = ListNode.createLinkListFromArray(new int[]{1, 2, -3, 3, 1});
        ListNode result = solution.removeZeroSumSublists(head);
        int[] resultList = ListNode.link2Array(result);
        Assert.assertArrayEquals(new int[]{3, 1}, resultList);
    }

    @Test
    public void testcase2() {
        ListNode head = ListNode.createLinkListFromArray(new int[]{1, 2, 3, -3, 4});
        ListNode result = solution.removeZeroSumSublists(head);
        int[] resultList = ListNode.link2Array(result);
        Assert.assertArrayEquals(new int[]{1, 2, 4}, resultList);
    }

    @Test
    public void testcase3() {
        ListNode head = ListNode.createLinkListFromArray(new int[]{1, 2, 3, -3, -2});
        ListNode result = solution.removeZeroSumSublists(head);
        int[] resultList = ListNode.link2Array(result);
        Assert.assertArrayEquals(new int[]{1}, resultList);
    }

    @Test
    public void testcase4() {
        // [1,3,2,-3,-2,5,5,-5,1]
        ListNode head = ListNode.createLinkListFromArray(new int[]{1, 3, 2, -3, -2, 5, 5, -5, 1});
        ListNode result = solution.removeZeroSumSublists(head);
        int[] resultList = ListNode.link2Array(result);
        Assert.assertArrayEquals(new int[]{1, 5, 1}, resultList);
    }

    @Test
    public void testcase5() {
        // [0]
        ListNode head = ListNode.createLinkListFromArray(new int[]{0});
        ListNode result = solution.removeZeroSumSublists(head);
        Assert.assertNull(result);
    }

    @Test
    public void testcase6() {
        // [1,0,2,-3]
        ListNode head = ListNode.createLinkListFromArray(new int[]{1, 0, 2, -3});
        ListNode result = solution.removeZeroSumSublists(head);
        Assert.assertNull(result);
    }
}