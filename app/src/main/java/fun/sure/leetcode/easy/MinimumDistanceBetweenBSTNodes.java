package fun.sure.leetcode.easy;

import java.util.ArrayList;
import java.util.List;

import fun.sure.leetcode.common.TreeNode;

/**
 * Created by sure on 2018/8/4.
 */

public class MinimumDistanceBetweenBSTNodes {

    /**
     * Given a Binary Search Tree (BST) with the root node root, return the minimum difference between the values of any two different nodes in the tree.

     Example :

     Input: root = [4,2,6,1,3,null,null]
     Output: 1
     Explanation:
     Note that root is a TreeNode object, not an array.

     The given tree [4,2,6,1,3,null,null] is represented by the following diagram:

     4
     /   \
     2      6
     / \
     1   3

     while the minimum difference in this tree is 1, it occurs between node 1 and node 2, also between node 3 and node 2.
     Note:

     The size of the BST will be between 2 and 100.
     The BST is always valid, each node's value is an integer, and each node's value is different.
     */

    // [ACCEPTED]
    private List<Integer> list = new ArrayList<>();

    public int minDiffInBST(TreeNode root) {
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
