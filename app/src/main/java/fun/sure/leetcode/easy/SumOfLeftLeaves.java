package fun.sure.leetcode.easy;

import fun.sure.leetcode.common.TreeNode;

/**
 * Created by sure on 2018/8/4.
 */

public class SumOfLeftLeaves {

    /**
     * Find the sum of all left leaves in a given binary tree.

     Example:

      3
     / \
     9  20
        /  \
       15   7

     There are two left leaves in the binary tree, with values 9 and 15 respectively. Return 24.
     */

    // [ACCEPTED]
    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (isLeafNode(root.left)) {
            return root.left.val + sumOfLeftLeaves(root.right);
        } else {
            return sumOfLeftLeaves(root.left) + sumOfLeftLeaves(root.right);
        }
    }

    private boolean isLeafNode(TreeNode node) {
        return node != null && node.left == null && node.right == null;
    }
}
