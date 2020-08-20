package `fun`.sure.leetcode.medium

import `fun`.sure.leetcode.common.TreeNode
import java.util.*

/**
 * Created by wangshuo on 2020/8/20.
 */
class ConstructBinarySearchTreeFromPreorderTraversal {

    /**
     * Return the root node of a binary search tree that matches the given preorder traversal.

    (Recall that a binary search tree is a binary tree where for every node, any descendant of node.left has a value < node.val, and any descendant of node.right has a value > node.val.  Also recall that a preorder traversal displays the value of the node first, then traverses node.left, then traverses node.right.)

    It's guaranteed that for the given test cases there is always possible to find a binary search tree with the given requirements.

    Example 1:

    Input: [8,5,1,7,10,12]
    Output: [8,5,10,1,7,null,12]



    Constraints:

    1 <= preorder.length <= 100
    1 <= preorder[i] <= 10^8
    The values of preorder are distinct.
     */

    /**
     * 思路：
     *
     * 维护一个栈来实现
     * 1. 当 cur 为 null 时 cur = node，cur 进栈
     * 2. cur 和 stack top 比，如果 < top，top.left = cur, cur 进栈
     * 3. cur 和 stack top 比，如果 >= top，top 出栈，parent = stack.pop 直到 stack 为空，或者 < top，parent.right = cur
     */

    /**
     * Success
     * Details
     * Runtime: 244 ms, faster than 29.03% of Kotlin online submissions for Construct Binary Search Tree from Preorder Traversal.
     * Memory Usage: 33.9 MB, less than 48.39% of Kotlin online submissions for Construct Binary Search Tree from Preorder Traversal.
     */
    fun bstFromPreorder(preorder: IntArray): TreeNode? {
        val stack = Stack<TreeNode>()
        var cur: TreeNode? = null
        var root: TreeNode? = null

        for (value in preorder) {
            cur = TreeNode(value)
            if (stack.isEmpty()) {
                stack.push(cur)
                if (root == null) {
                    root = cur
                }
            } else {
                var parent = stack.peek()
                if (value < parent.`val`) {
                    parent.left = cur
                } else {
                    while (!stack.empty() && value >= stack.peek().`val`) {
                        parent = stack.pop()
                    }
                    parent?.right = cur
                }
                stack.push(cur)
            }
        }
        return root
    }
}