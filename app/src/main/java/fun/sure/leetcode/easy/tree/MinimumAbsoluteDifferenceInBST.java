package fun.sure.leetcode.easy.tree;

import java.util.ArrayList;
import java.util.List;

import fun.sure.leetcode.common.TreeNode;

/**
 * Created by sure on 2018/8/4.
 */

public class MinimumAbsoluteDifferenceInBST {

    /**
     * Given a binary search tree with non-negative values, find the minimum absolute difference between values of any two nodes.

     Example:

     Input:

     1
     \
     3
     /
     2

     Output:
     1

     Explanation:
     The minimum absolute difference is 1, which is the difference between 2 and 1 (or between 2 and 3).
     Note: There are at least two nodes in this BST.
     */

    // [ACCEPTED]
    private List<Integer> list = new ArrayList<>();

    public int getMinimumDifference(TreeNode root) {
        inorder(root);
        int min = Integer.MAX_VALUE;
        int diff;
        for (int i = 0; i < list.size() - 1; i++) {
            diff = list.get(i + 1) - list.get(i);
            if (diff < min) {
                min = diff;
            }
        }
        return min;
    }

    private void inorder(TreeNode node) {
        if (node == null) {
            return;
        }
        inorder(node.left);
        list.add(node.val);
        inorder(node.right);
    }
}
