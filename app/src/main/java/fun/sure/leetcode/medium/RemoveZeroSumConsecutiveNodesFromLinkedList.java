package fun.sure.leetcode.medium;

import android.util.Pair;

import java.util.ArrayList;
import java.util.List;

import fun.sure.leetcode.common.ListNode;

/**
 * Created by wangshuo on 2020/10/11.
 */
class RemoveZeroSumConsecutiveNodesFromLinkedList {
    /**
     * Given the head of a linked list, we repeatedly delete consecutive sequences of nodes that sum to 0 until there are no such sequences.
     *
     * After doing so, return the head of the final linked list.  You may return any such answer.
     *
     *
     *
     * (Note that in the examples below, all sequences are serializations of ListNode objects.)
     *
     * Example 1:
     *
     * Input: head = [1,2,-3,3,1]
     * Output: [3,1]
     * Note: The answer [1,2,1] would also be accepted.
     * Example 2:
     *
     * Input: head = [1,2,3,-3,4]
     * Output: [1,2,4]
     * Example 3:
     *
     * Input: head = [1,2,3,-3,-2]
     * Output: [1]
     *
     *
     * Constraints:
     *
     * The given linked list will contain between 1 and 1000 nodes.
     * Each node in the linked list has -1000 <= node.val <= 1000.
     */

    /*
     * 思路
     * 从头开始遍历，每遍历一次
     * - 检查当前值是否可以和已遍历得到的结果相抵消
     * - 如果不能抵消，则更新组合值
     * - 如果可以抵消，标记去掉对应的节点，更新组合值
     *
     * 举例：
     * 1，2，4，3，-7，1
     * it 表示遍历数，set 记录组合值
     * it0 : set = 1
     * it1 : set = 2, 3
     * it2 : set = 4, 6, 7
     * it3 : set = 3, 7, 9, 10
     * it4 : -7 和 set 中元素对应，可消除，移除 3，7，对应 [i-2, i) 的元素标记清除，组合更新为 set = 2,3 (9 - 7, 10 - 7)
     * it5 : set = 1, 3, 4
     *
     * 重新遍历数组，标记删除的点略过，组成新的数组返回
     */

    /*
     * Success
     *
     * Runtime: 20 ms, faster than 5.17% of Java online submissions for Remove Zero Sum Consecutive Nodes from Linked List.
     * Memory Usage: 38.8 MB, less than 14.13% of Java online submissions for Remove Zero Sum Consecutive Nodes from Linked List.
     */
    public ListNode removeZeroSumSublists(ListNode head) {
        List<Boolean> markList = new ArrayList<>();
        List<ValueGap> valueGapList = new ArrayList<>();
        ListNode p = head;
        while (p != null) {
            int value = p.val;
            if (value == 0) {
                markList.add(false);
                for (ValueGap valueGap : valueGapList) {
                    valueGap.gap += 1;
                }
            } else {
                markList.add(true);
                int matchedIndex = findZeroSumIndex(valueGapList, value);
                if (matchedIndex >= 0) {
                    markList.set(markList.size() - 1, false);
                    for (int i = 0; i <= matchedIndex; i++) {
                        ValueGap vp = valueGapList.remove(0);
                        markList.set(markList.size() - 2 - i - vp.gap, false);
                    }
                    int gap = matchedIndex + 2; // matchedIndex 因为是从 0 记的所以实际数量要 +1，再加上当前消除的元素，及 + 2
                    for (ValueGap valueGap : valueGapList) {
                        valueGap.value += value;
                        valueGap.gap += gap;
                    }
                } else {
                    for (int i = 0; i < valueGapList.size(); i++) {
                        ValueGap vp = valueGapList.get(i);
                        vp.value += value;
                    }
                    valueGapList.add(0, new ValueGap(value));
                }
            }
            p = p.next;
        }

        ListNode dummy = new ListNode(-1);
        ListNode r = dummy;
        p = head;
        for (int i = 0; i < markList.size(); i++) {
            if (markList.get(i)) {
                r.next = p;
                r = r.next;
            }
            p = p.next;
        }
        r.next = null;
        return dummy.next;
    }

    private int findZeroSumIndex(List<ValueGap> valueList, int target) {
        for (int i = 0; i < valueList.size(); i++) {
            if (valueList.get(i).value + target == 0) {
                return i;
            }
        }
        return -1;
    }

    private static class ValueGap {
        public int value;
        public int gap;

        public ValueGap(int value) {
            this(value, 0);
        }

        public ValueGap(int value, int gap) {
            this.value = value;
            this.gap = gap;
        }
    }
}
