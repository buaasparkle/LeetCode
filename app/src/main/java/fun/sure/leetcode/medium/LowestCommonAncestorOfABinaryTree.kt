package `fun`.sure.leetcode.medium

import `fun`.sure.leetcode.Topics
import `fun`.sure.leetcode.common.TreeNode
import java.util.ArrayList

/**
 * Created by wangshuo on 2021/10/13.
 */
class LowestCommonAncestorOfABinaryTree : Topics.DFS, Topics.Tree, Topics.BinaryTree {

    /**
     * Given a binary tree, find the lowest common ancestor (LCA) of two given nodes in the tree.

    According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes p and q as the lowest node in T that has both p and q as descendants (where we allow a node to be a descendant of itself).”

    Example 1:


    Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
    Output: 3
    Explanation: The LCA of nodes 5 and 1 is 3.
    Example 2:


    Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
    Output: 5
    Explanation: The LCA of nodes 5 and 4 is 5, since a node can be a descendant of itself according to the LCA definition.
    Example 3:

    Input: root = [1,2], p = 1, q = 2
    Output: 1


    Constraints:

    The number of nodes in the tree is in the range [2, 105].
    -109 <= Node.val <= 109
    All Node.val are unique.
    p != q
    p and q will exist in the tree.
     */

    /*
     * 思路
     * 比较遍历到 p 和 q 的路径，取最后一个公共节点
     */

    /*
    Success
    Runtime: 468 ms, faster than 17.22% of Kotlin online submissions for Lowest Common Ancestor of a Binary Tree.
    Memory Usage: 49.7 MB, less than 6.22% of Kotlin online submissions for Lowest Common Ancestor of a Binary Tree.
     */
    fun lowestCommonAncestor(root: TreeNode?, p: TreeNode?, q: TreeNode?): TreeNode? {
        if (root == null || p == null || q == null) {
            return null
        }
        if (nodeEqual(root, p) || nodeEqual(root, q)) {
            return root
        }
        val pResult = ArrayList<TreeNode>()
        val qResult = ArrayList<TreeNode>()
        preOrderPathOfNode(root, p, pResult)
        preOrderPathOfNode(root, q, qResult)
        var pre: TreeNode? = null
        pResult.zip(qResult).forEach { (pNode, qNode) ->
            if (nodeEqual(pNode, qNode)) {
                pre = pNode
            } else {
                return@forEach
            }
        }
        return pre
    }

    private fun nodeEqual(p: TreeNode?, q: TreeNode?): Boolean {
        if (p === q) return true
        if (p == null && q == null) return true
        if (p != null && q != null) return p.`val` == q.`val`
        return false
    }

    // 返回值是为了找到后能提前返回
    private fun preOrderPathOfNode(root: TreeNode?, target: TreeNode?, result: ArrayList<TreeNode>): Boolean {
        if (root == null) return false
        if (nodeEqual(root, target)) {
            result.add(root)
            return true
        }
        if (preOrderPathOfNode(root.left, target, result)) {
            result.add(0, root)
            return true
        }
        if (preOrderPathOfNode(root.right, target, result)) {
            result.add(0, root)
            return true
        }
        return false
    }
}