package `fun`.sure.leetcode.easy

import `fun`.sure.leetcode.common.TreeNode
import org.junit.Assert.*
import org.junit.Test

/**
 * Created by wangshuo on 2020/8/28.
 */
class DiameterOfBinaryTreeTest {

    private val solution = DiameterOfBinaryTree()

    @Test
    fun testcase() {
        //     1
        //  2      3
        //4   5
        val n1 = TreeNode(1)
        val n2 = TreeNode(1)
        val n3 = TreeNode(1)
        val n4 = TreeNode(1)
        val n5 = TreeNode(1)
        n1.left = n2
        n1.right = n3
        n2.left = n4
        n2.right = n5
        assertEquals(3, solution.diameterOfBinaryTree(n1))
    }
}