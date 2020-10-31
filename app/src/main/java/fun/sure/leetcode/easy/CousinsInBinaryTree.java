package fun.sure.leetcode.easy;

import fun.sure.leetcode.common.TreeNode;

/**
 * Created by wangshuo on 2020/10/31.
 */
class CousinsInBinaryTree {

    /**
     * In a binary tree, the root node is at depth 0, and children of each depth k node are at depth k+1.
     *
     * Two nodes of a binary tree are cousins if they have the same depth, but have different parents.
     *
     * We are given the root of a binary tree with unique values, and the values x and y of two different nodes in the tree.
     *
     * Return true if and only if the nodes corresponding to the values x and y are cousins.
     *
     * Constraints:
     *
     * The number of nodes in the tree will be between 2 and 100.
     * Each node has a unique integer value from 1 to 100.
     */

    /*
     * 思路
     * 直观的方法就是遍历数，得到每个节点的深度及 parent，然后先比较深度，再比较 parent
     */

    /*
     * Success
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Cousins in Binary Tree.
     * Memory Usage: 36.9 MB, less than 14.56% of Java online submissions for Cousins in Binary Tree.
     */
    public boolean isCousins(TreeNode root, int x, int y) {
        NodeInfo nodeX = new NodeInfo();
        NodeInfo nodeY = new NodeInfo();
        traverseTree(root, x, y, 0, nodeX, nodeY);
        return nodeX.depth == nodeY.depth && nodeX.parent != nodeY.parent;
    }

    private void traverseTree(TreeNode root, int x, int y, int depth, NodeInfo nodeX, NodeInfo nodeY) {
        if (root == null) {
            return;
        }
        TreeNode left = root.left;
        TreeNode right = root.right;
        if (checkNodeValue(left, x) || checkNodeValue(right, x)) {
            nodeX.depth = depth + 1;
            nodeX.parent = root;
        }
        if (checkNodeValue(left, y) || checkNodeValue(right, y)) {
            nodeY.depth = depth + 1;
            nodeY.parent = root;
        }
        traverseTree(left, x, y, depth + 1, nodeX, nodeY);
        traverseTree(right, x, y, depth + 1, nodeX, nodeY);
    }

    private boolean checkNodeValue(TreeNode node, int value) {
        return node != null && node.val == value;
    }

    // 记录节点的深度以及 parent 信息
    private static class NodeInfo {
        private int depth = 0;
        private TreeNode parent = null;
    }
}
