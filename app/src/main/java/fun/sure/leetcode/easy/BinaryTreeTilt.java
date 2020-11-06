package fun.sure.leetcode.easy;

import java.util.HashMap;
import java.util.Map;

import fun.sure.leetcode.common.TreeNode;

/**
 * Created by wangshuo on 2020/11/6.
 */
class BinaryTreeTilt {

    /**
     * Given the root of a binary tree, return the sum of every tree node's tilt.
     *
     * The tilt of a tree node is the absolute difference between the sum of all left subtree node
     * values and all right subtree node values. If a node does not have a left child, then the sum
     * of the left subtree node values is treated as 0. The rule is similar if there the node does
     * not have a right child.
     *
     * Constraints:
     *
     * The number of nodes in the tree is in the range [0, 104].
     * -1000 <= Node.val <= 1000
     */

    /*
     * Success
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Binary Tree Tilt.
     * Memory Usage: 39.4 MB, less than 7.43% of Java online submissions for Binary Tree Tilt.
     */

    public int findTilt(TreeNode root) {
        int[] tilt = new int[] {0};
        sumOfTree(root, tilt);
        return tilt[0];
    }

    private int sumOfTree(TreeNode root, int[] tilt) {
        if (root == null) {
            return 0;
        }
        int leftSum = sumOfTree(root.left, tilt);
        int rightSum = sumOfTree(root.right, tilt);
        int sum = root.val + leftSum + rightSum;
        tilt[0] += Math.abs(leftSum - rightSum);
        return sum;
    }
}
