package fun.sure.leetcode.easy;

import fun.sure.leetcode.common.TreeNode;

/**
 * Created by sure on 2018/7/29.
 */

public class LeafSimilarTrees {

    /**
     * Consider all the leaves of a binary tree.  From left to right order, the values of those leaves form a leaf value sequence.



     For example, in the given tree above, the leaf value sequence is (6, 7, 4, 9, 8).

     Two binary trees are considered leaf-similar if their leaf value sequence is the same.

     Return true if and only if the two given trees with head nodes root1 and root2 are leaf-similar.



     Note:

     Both of the given trees will have between 1 and 100 nodes.
     */

    // [ACCEPTED]
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        String seq1 = leafSequence(root1);
        String seq2 = leafSequence(root2);
        return seq1.equals(seq2);
    }

    private String leafSequence(TreeNode node) {
        StringBuilder sb = new StringBuilder();
        inorderTraversal(node, sb);
        return sb.toString();
    }

    private void inorderTraversal(TreeNode node, StringBuilder sb) {
        if (node == null) {
            return;
        }
        if (isLeafNode(node)) {
            sb.append(node.val);
            return;
        }
        inorderTraversal(node.left, sb);
        inorderTraversal(node.right, sb);
    }

    private boolean isLeafNode(TreeNode node) {
        return node != null && node.left == null && node.right == null;
    }
}
