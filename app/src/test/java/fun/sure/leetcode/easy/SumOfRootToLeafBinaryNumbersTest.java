package fun.sure.leetcode.easy;

import org.junit.Assert;
import org.junit.Test;

import fun.sure.leetcode.common.TreeNode;

/**
 * Created by wangshuo on 2020/10/18.
 */
public class SumOfRootToLeafBinaryNumbersTest {

    private SumOfRootToLeafBinaryNumbers solution = new SumOfRootToLeafBinaryNumbers();

    @Test
    public void testcase_1() {
        TreeNode root = TreeNode.buildFrom(new Integer[]{1, 0, 1, 0, 1, 0, 1});
        Assert.assertEquals(22, solution.sumRootToLeaf(root));
    }

    @Test
    public void testcase_2() {
        TreeNode root = TreeNode.buildFrom(new Integer[]{0});
        Assert.assertEquals(0, solution.sumRootToLeaf(root));
    }

    @Test
    public void testcase_3() {
        TreeNode root = TreeNode.buildFrom(new Integer[]{1});
        Assert.assertEquals(1, solution.sumRootToLeaf(root));
    }

    @Test
    public void testcase_4() {
        TreeNode root = TreeNode.buildFrom(new Integer[]{1, 1});
        Assert.assertEquals(3, solution.sumRootToLeaf(root));
    }
}