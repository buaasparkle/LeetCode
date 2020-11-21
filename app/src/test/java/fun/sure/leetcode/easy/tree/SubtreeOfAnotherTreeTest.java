package fun.sure.leetcode.easy.tree;

import org.junit.Test;

import fun.sure.leetcode.common.TreeNode;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by wangshuo on 2020/11/14.
 */
public class SubtreeOfAnotherTreeTest {

    SubtreeOfAnotherTree solution = new SubtreeOfAnotherTree();

    @Test
    public void testcase_1() {
        TreeNode s = TreeNode.buildFrom(new Integer[]{3, 4, 5, 1, 2});
        TreeNode t = TreeNode.buildFrom(new Integer[]{4, 1, 2});
        assertTrue(solution.isSubtree(s, t));
    }

    @Test
    public void testcase_2() {
        TreeNode s = TreeNode.buildFrom(new Integer[]{3, 4, 5, 1, 2, null, null, null, null, 0});
        TreeNode t = TreeNode.buildFrom(new Integer[]{4, 1, 2});
        assertFalse(solution.isSubtree(s, t));
    }

    @Test
    public void testcase_3() {
        TreeNode s = TreeNode.buildFrom(new Integer[]{4, 1, 2, null, null, 0});
        TreeNode t = TreeNode.buildFrom(new Integer[]{4, 1, 2});
        assertFalse(solution.isSubtree(s, t));
    }
}