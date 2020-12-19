package fun.sure.leetcode.medium.tree;

import fun.sure.leetcode.common.TreeNode;

/**
 * Created by wangshuo on 2020/12/19.
 */
class FindACorrespondingNodeBinaryTreeInACloneOfThatTree {

    /**
     * Given two binary trees original and cloned and given a reference to a node target in the original tree.
     *
     * The cloned tree is a copy of the original tree.
     *
     * Return a reference to the same node in the cloned tree.
     *
     * Note that you are not allowed to change any of the two trees or the target node and the answer must be a reference to a node in the cloned tree.
     *
     * Follow up: Solve the problem if repeated values on the tree are allowed.
     */

    /*
     * 思路
     *
     * 按相同的顺序遍历，当 node ref 为 target 时，返回 cloned 中对应的节点
     */

    /*
     * Success
     * Runtime: 1 ms, faster than 96.01% of Java online submissions for Find a Corresponding Node of a Binary Tree in a Clone of That Tree.
     * Memory Usage: 47.1 MB, less than 14.89% of Java online submissions for Find a Corresponding Node of a Binary Tree in a Clone of That Tree.
     */
    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        TreeNode[] found = new TreeNode[]{null};
        preOrderTraverse(original, cloned, target, found);
        return found[0];
    }

    private void preOrderTraverse(final TreeNode original, final TreeNode cloned, final TreeNode target, TreeNode[] found) {
        if (original == null || cloned == null || found[0] != null) {
            return;
        }
        if (original == target) {
            found[0] = cloned;
            return;
        }
        preOrderTraverse(original.left, cloned.left, target, found);
        preOrderTraverse(original.right, cloned.right, target, found);
    }
}
