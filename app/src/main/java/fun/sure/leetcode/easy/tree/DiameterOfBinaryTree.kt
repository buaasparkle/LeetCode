package `fun`.sure.leetcode.easy.tree

import `fun`.sure.leetcode.common.TreeNode

/**
 * Created by wangshuo on 2020/8/28.
 */
class DiameterOfBinaryTree {

    /**
     * Given a binary tree, you need to compute the length of the diameter of the tree. The diameter of a binary tree is the length of the longest path between any two nodes in a tree. This path may or may not pass through the root.

    Example:
    Given a binary tree
    1
    / \
    2   3
    / \
    4   5
    Return 3, which is the length of the path [4,2,1,3] or [5,2,1,3].

    Note: The length of path between two nodes is represented by the number of edges between them.
     */

    /*
     * 根据直径的定义，对于一个节点 node 来说，经过它的最大直径为
     * diameter(node) = maxDepth(node.left) + maxDepth(node.right)
     * 对每一个节点计算 diameter，取最大值即为所求
     */

    /**
     * Success
     * Runtime: 188 ms, faster than 68.32% of Kotlin online submissions for Diameter of Binary Tree.
     * Memory Usage: 36.7 MB, less than 26.73% of Kotlin online submissions for Diameter of Binary Tree.
     */
    fun diameterOfBinaryTree(root: TreeNode?): Int {
        val depthMap = mutableMapOf<TreeNode, Int>() // 记录节点的最大深度
        return traverseTree(root, depthMap)
    }

    private fun calcNodeDepth(node: TreeNode?, depthMap: MutableMap<TreeNode, Int>): Int {
        val nodeNotNull = node ?: return 0
        return if (depthMap.containsKey(nodeNotNull)) {
            depthMap.getValue(nodeNotNull)
        } else {
            val leftDepth = calcNodeDepth(nodeNotNull.left, depthMap)
            val rightDepth = calcNodeDepth(nodeNotNull.right, depthMap)
            val depth = Math.max(leftDepth, rightDepth) +
                    if (nodeNotNull.left != null || nodeNotNull.right != null) 1 else 0
            depthMap[node] = depth
            depth
        }
    }

    private fun diameter(node: TreeNode?, depthMap: MutableMap<TreeNode, Int>): Int {
        val nodeNotNull = node ?: return 0
        val sumChild = calcNodeDepth(node.left, depthMap) + calcNodeDepth(node.right, depthMap)
        val extra = if (nodeNotNull.left == null && node.right == null) {
            0
        } else if (nodeNotNull.left != null && nodeNotNull.right != null) {
            2
        } else {
            1
        }
        return sumChild + extra
    }

    private fun traverseTree(node: TreeNode?, depthMap: MutableMap<TreeNode, Int>): Int {
        val nodeNotNull = node ?: return 0
        val leftMax = traverseTree(nodeNotNull.left, depthMap)
        val curNodeDiameter = diameter(nodeNotNull, depthMap)
        val rightMax = traverseTree(nodeNotNull.right, depthMap)
        return Math.max(leftMax, Math.max(curNodeDiameter, rightMax))
    }
}