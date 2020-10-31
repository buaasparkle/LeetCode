package fun.sure.leetcode.easy;

import org.junit.Test;

import fun.sure.leetcode.common.TreeNode;

import static org.junit.Assert.*;

/**
 * Created by wangshuo on 2020/10/31.
 */
public class CousinsInBinaryTreeTest {

    private CousinsInBinaryTree solution = new CousinsInBinaryTree();

    @Test
    public void testIsCousinsCase1() {
        TreeNode root = TreeNode.buildFrom(new Integer[] {1,2,3,4});
        assertFalse(solution.isCousins(root, 4, 3));
    }

    @Test
    public void testIsCousinsCase2() {
        TreeNode root = TreeNode.buildFrom(new Integer[] {1,2,3,null,4,null,5});
        assertTrue(solution.isCousins(root, 5, 4));
    }

    @Test
    public void testIsCousinsCase3() {
        TreeNode root = TreeNode.buildFrom(new Integer[] {1,2,3,null,4});
        assertFalse(solution.isCousins(root, 2, 3));
    }
}