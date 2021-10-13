package `fun`.sure.leetcode.medium

import `fun`.sure.leetcode.common.TreeNode
import org.junit.Test

import org.junit.Assert.*

/**
 * Created by wangshuo on 2021/10/13.
 */
class LowestCommonAncestorOfABinaryTreeTest {

    private val target = LowestCommonAncestorOfABinaryTree()

    @Test
    fun lowestCommonAncestor() {
        val arrayList = arrayListOf(3, 5, 1, 6, 2, 0, 8, null, null, 7, 4)
        val root = TreeNode.buildFrom(arrayList.toTypedArray())
        var result = target.lowestCommonAncestor(root, TreeNode(5), TreeNode(1))
        result?.let {
            assertEquals(3, result.`val`)
        }
    }
}