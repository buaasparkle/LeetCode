package fun.sure.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

import fun.sure.leetcode.Topics;
import fun.sure.leetcode.common.TreeNode;
import kotlin.collections.ArrayDeque;

/**
 * Created by wangshuo on 2021/9/29.
 */
class KthSmallestElementInBST implements Topics.Tree, Topics.DFS, Topics.BinarySearchTree, Topics.BinaryTree {

    /**
     * Given the root of a binary search tree, and an integer k, return the kth smallest value (1-indexed) of all the values of the nodes in the tree.
     * <p>
     * <p>
     * Example 1:
     * <p>
     * <p>
     * Input: root = [3,1,4,null,2], k = 1
     * Output: 1
     * Example 2:
     * <p>
     * <p>
     * Input: root = [5,3,6,2,4,null,null,1], k = 3
     * Output: 3
     * <p>
     * <p>
     * Constraints:
     * <p>
     * The number of nodes in the tree is n.
     * 1 <= k <= n <= 104
     * 0 <= Node.val <= 104
     */

    /*
    Success
    Runtime: 1 ms, faster than 48.41% of Java online submissions for Kth Smallest Element in a BST.
    Memory Usage: 39 MB, less than 58.72% of Java online submissions for Kth Smallest Element in a BST.

     */
    public int kthSmallest(TreeNode root, int k) {
        List<Integer> list = new ArrayList<>();
        inOrderDFS(root, list);
        return list.get(k - 1);
    }

    // BST 中序遍历 结果保存到列表
    private void inOrderDFS(TreeNode root, List<Integer> list) {
        if (root != null) {
            inOrderDFS(root.left, list);
            list.add(root.val);
            inOrderDFS(root.right, list);
        }
    }

}
