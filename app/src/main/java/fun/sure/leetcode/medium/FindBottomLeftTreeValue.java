package fun.sure.leetcode.medium;

import fun.sure.leetcode.common.TreeNode;

/**
 * Created by sure on 2017/6/25.
 */

public class FindBottomLeftTreeValue {

    /**
     * Given a binary tree, find the leftmost value in the last row of the tree.

     Example 1:
     Input:

     2
     / \
     1   3

     Output:
     1
     Example 2:
     Input:

     1
     / \
     2   3
     /   / \
     4   5   6
        /
        7

     Output:
     7

     Note: You may assume the tree (i.e., the given root node) is not NULL.
     */

    // [PASS]
    private int maxDepth = 0;
    private int value;

    public int findBottomLeftValue(TreeNode root) {
        searchTree(root, 1);
        return value;
    }

    private void searchTree(TreeNode node, int depth) {
        if (node == null) {
            return;
        }
        if (node.left == null && node.right == null) {
            if (depth > maxDepth) {
                maxDepth = depth;
                value = node.val;
            }
            return;
        }
        if (node.left != null) {
            searchTree(node.left, depth + 1);
        }
        if (node.right != null) {
            searchTree(node.right, depth + 1);
        }
    }
}
