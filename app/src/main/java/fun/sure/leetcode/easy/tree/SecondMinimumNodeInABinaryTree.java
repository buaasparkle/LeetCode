package fun.sure.leetcode.easy.tree;

import fun.sure.leetcode.common.TreeNode;

/**
 * Created by wangshuo on 2020/12/13.
 */
class SecondMinimumNodeInABinaryTree {

    /**
     * Given a non-empty special binary tree consisting of nodes with the non-negative value,
     * where each node in this tree has exactly two or zero sub-node. If the node has two sub-nodes,
     * then this node's value is the smaller value among its two sub-nodes. More formally,
     * the property root.val = min(root.left.val, root.right.val) always holds.
     *
     * Given such a binary tree, you need to output the second minimum value in the set made of all
     * the nodes' value in the whole tree.
     *
     * If no such second minimum value exists, output -1 instead.
     *
     * Constraints:
     *
     * The number of nodes in the tree is in the range [1, 25].
     * 1 <= Node.val <= 231 - 1
     * root.val == min(root.left.val, root.right.val) for each internal node of the tree.
     */

    /*
     * 思路
     * 递归去找左右子树中"第二小值"中的最小值
     *
     * 几个 testcase 没过的点：
     * 1. -1 表示没有满足值返回的结果，不能用任何其他值代替：比如 Integer.MAX_VALUE
     * 2. 定义 Result 包含 valid 字段来表示是否存在结果，避免单纯值的比较不符合语义
     */

    /*
     * Success
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Second Minimum Node In a Binary Tree.
     * Memory Usage: 37.9 MB, less than 5.99% of Java online submissions for Second Minimum Node In a Binary Tree.
     */
    public int findSecondMinimumValue(TreeNode root) {
        return findSecondMin(root).value;
    }

    private Result findSecondMin(TreeNode root) {
        if (noChild(root)) {
            return Result.inValidResult();
        } else if (hasTwoChildren(root)) {
            int leftVal = root.left.val;
            int rightVal = root.right.val;
            if (leftVal == rightVal) {
                return Result.min(findSecondMin(root.left), findSecondMin(root.right));
            } else if (leftVal < rightVal) {
                return Result.min(findSecondMin(root.left), Result.validWithValue(rightVal));
            } else {
                return Result.min(findSecondMin(root.right), Result.validWithValue(leftVal));
            }
        } else { // only one child
            return findSecondMin(onlyChild(root));
        }
    }

    private boolean noChild(TreeNode node) {
        return node == null || (node.left == null && node.right == null);
    }

    private boolean hasTwoChildren(TreeNode node) {
        return node != null && node.left != null && node.right != null;
    }

    private TreeNode onlyChild(TreeNode node) {
        if (node != null) {
            if (node.left != null) {
                return node.left;
            } else {
                return node.right;
            }
        }
        return null;
    }

    private static class Result {
        boolean valid;
        int value;

        public static Result inValidResult() {
            return new Result(false, -1);
        }

        public static Result validWithValue(int value) {
            return new Result(true, value);
        }

        private Result(boolean valid, int value) {
            this.valid = valid;
            this.value = value;
        }

        static Result min(Result r1, Result r2) {
            if (r1.valid && r2.valid) {
                return Result.validWithValue(Math.min(r1.value, r2.value));
            } else if (r1.valid) {
                return r1;
            } else if (r2.valid) {
                return r2;
            } else {
                return Result.inValidResult();
            }
        }
    }
}
