package fun.sure.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

import fun.sure.leetcode.common.ListNode;
import fun.sure.leetcode.common.TreeNode;

/**
 * Created by wangshuo on 2020/10/13.
 */
class LinkedListInBinaryTree {

    /**
     * Given a binary tree root and a linked list with head as the first node.
     *
     * Return True if all the elements in the linked list starting from the head correspond to some downward path connected in the binary tree otherwise return False.
     *
     * In this context downward path means a path that starts at some node and goes downwards.
     *
     * Constraints:
     *
     * 1 <= node.val <= 100 for each node in the linked list and binary tree.
     * The given linked list will contain between 1 and 100 nodes.
     * The given binary tree will contain between 1 and 2500 nodes.
     */

    /*
     * 思路
     * 遍历 Tree，值和链表头相同的节点加入到待检查队列中，然后从头检查是否有匹配的，有就返回
     */

    /*
     * Success
     * Runtime: 2 ms, faster than 35.77% of Java online submissions for Linked List in Binary Tree.
     * Memory Usage: 39.1 MB, less than 12.64% of Java online submissions for Linked List in Binary Tree.
     */
    public boolean isSubPath(ListNode head, TreeNode root) {
        List<TreeNode> startNodeList = new ArrayList<>();
        traverseTree(root, startNodeList, head.val);
        for (TreeNode treeNode : startNodeList) {
            if (checkPath(head, treeNode)) {
                return true;
            }
        }
        return false;
    }

    private void traverseTree(TreeNode root, List<TreeNode> list, int headValue) {
        if (root == null) {
            return;
        }
        if (root.val == headValue) {
            list.add(root);
        }
        traverseTree(root.left, list, headValue);
        traverseTree(root.right, list, headValue);
    }

    // 默认执行此方法时已满足 head.value == root.value
    private boolean checkPath(ListNode head, TreeNode root) {
        if (head != null && root != null) {
            if (head.val == root.val) {
                return checkPath(head.next, root.left) || checkPath(head.next, root.right);
            } else {
                return false;
            }
        }
        return head == null;
    }
}
