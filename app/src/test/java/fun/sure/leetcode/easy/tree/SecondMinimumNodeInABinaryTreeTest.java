package fun.sure.leetcode.easy.tree;

import org.junit.Test;

import fun.sure.leetcode.common.TreeNode;

import static org.junit.Assert.*;

/**
 * Created by wangshuo on 2020/12/13.
 */
public class SecondMinimumNodeInABinaryTreeTest {

    private SecondMinimumNodeInABinaryTree solution = new SecondMinimumNodeInABinaryTree();

    @Test
    public void testcase1() {
        TreeNode node = TreeNode.buildFrom(new Integer[]{1, 1, 3, 1, 1, 3, 4, 3, 1, 1, 1, 3, 8, 4, 8, 3, 3, 1, 6, 2, 1});
        assertEquals(2, solution.findSecondMinimumValue(node));
    }

    @Test
    public void testcase2() {
        TreeNode node = TreeNode.buildFrom(new Integer[]{2, 2, 2});
        assertEquals(-1, solution.findSecondMinimumValue(node));
    }

    @Test
    public void testcase3() {
        TreeNode node = TreeNode.buildFrom(new Integer[]{2, 2, 5, null, null, 5, 7});
        assertEquals(5, solution.findSecondMinimumValue(node));
    }

    @Test
    public void testcase4() {
        TreeNode node = TreeNode.buildFrom(new Integer[]{2, 2, 2147483647});
        assertEquals(2147483647, solution.findSecondMinimumValue(node));
    }
}