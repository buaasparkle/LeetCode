package `fun`.sure.leetcode.medium

import `fun`.sure.leetcode.Topics
import `fun`.sure.leetcode.common.TreeNode

/**
 * Created by wangshuo on 2021/10/11.
 */
class BinaryTreeRightSideView: Topics.Tree, Topics.BFS, Topics.BinaryTree {

    /**
     * Given the root of a binary tree, imagine yourself standing on the right side of it,
     * return the values of the nodes you can see ordered from top to bottom.


    Example 1:


    Input: root = [1,2,3,null,5,null,4]
    Output: [1,3,4]
    Example 2:

    Input: root = [1,null,3]
    Output: [1,3]
    Example 3:

    Input: root = []
    Output: []

    Constraints:

    The number of nodes in the tree is in the range [0, 100].
    -100 <= Node.val <= 100
     */

    /*
     * 思路
     *
     * BFS，find the last one of each level of the tree.
     */

    /*
    Success
    Runtime: 172 ms, faster than 83.09% of Kotlin online submissions for Binary Tree Right Side View.
    Memory Usage: 36.1 MB, less than 25.00% of Kotlin online submissions for Binary Tree Right Side View.

     */
    fun rightSideView(root: TreeNode?): List<Int> {
        val rightSideViewList = ArrayList<Int>()
        var curQueue = ArrayList<TreeNode>()
        var nextQueue = ArrayList<TreeNode>()
        if (root != null) {
            curQueue.add(root)
            while (curQueue.isNotEmpty()) {
                rightSideViewList.add(curQueue.last().`val`)
                while (curQueue.isNotEmpty()) {
                    val node = curQueue.removeAt(0)
                    node.left?.let { nextQueue.add(it) }
                    node.right?.let { nextQueue.add(it) }
                }
                // swap cur & next queue
                val temp = curQueue
                curQueue = nextQueue
                nextQueue = temp
            }
        }
        return rightSideViewList
    }
}