package fun.sure.leetcode.easy;

import fun.sure.leetcode.common.TreeNode;

/**
 * Created by wangshuo on 2016/6/7.
 */
public class InvertBinaryTree {

    /**
     *Invert a binary tree.

     4
     /   \
     2     7
     / \   / \
     1   3 6   9

     to

     4
     /   \
     7     2
     / \   / \
     9   6 3   1

     */

    // [PASS]
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode tempNode = root.left;
        root.left = invertTree(root.right);
        root.right = invertTree(tempNode);
        return root;
    }
}
