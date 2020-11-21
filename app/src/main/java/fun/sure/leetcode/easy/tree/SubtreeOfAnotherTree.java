package fun.sure.leetcode.easy.tree;

import fun.sure.leetcode.common.TreeNode;

/**
 * Created by wangshuo on 2020/11/14.
 */
public class SubtreeOfAnotherTree {

    /**
     * Given two non-empty binary trees s and t, check whether tree t has exactly the same structure and node values with a subtree of s. A subtree of s is a tree consists of a node in s and all of this node's descendants. The tree s could also be considered as a subtree of itself.
     *
     * Example 1:
     * Given tree s:
     *
     *      3
     *     / \
     *    4   5
     *   / \
     *  1   2
     * Given tree t:
     *    4
     *   / \
     *  1   2
     * Return true, because t has the same structure and node values with a subtree of s.
     *
     *
     * Example 2:
     * Given tree s:
     *
     *      3
     *     / \
     *    4   5
     *   / \
     *  1   2
     *     /
     *    0
     * Given tree t:
     *    4
     *   / \
     *  1   2
     * Return false.
     */

    /*
     * 思路：
     *
     * [wrong] 考虑先中序遍历得到两个数组，看例子必须是完整子树，所以就变成 string contain 的问题
     * [right] 字符串 contains 无法确认是不是完整子树，所以就直接用最粗暴的递归遍历方式
     */

    /*
     * Success
     * Runtime: 5 ms, faster than 97.06% of Java online submissions for Subtree of Another Tree.
     * Memory Usage: 38.8 MB, less than 97.88% of Java online submissions for Subtree of Another Tree.
     */
    public boolean isSubtree(TreeNode s, TreeNode t) {
        return isSameTree(s, t) || (s != null && (isSubtree(s.left, t) || isSubtree(s.right, t)));
    }

    private boolean isSameTree(TreeNode s, TreeNode t) {
        if (s == null && t == null) {
            return true;
        } else if (s == null || t == null) {
            return false;
        } else {
            if (s.val != t.val) {
                return false;
            } else {
                return isSameTree(s.left, t.left) && isSameTree(s.right, t.right);
            }
        }
    }
}
