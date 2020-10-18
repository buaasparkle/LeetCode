package fun.sure.leetcode.easy;

import fun.sure.leetcode.common.TreeNode;

/**
 * Created by wangshuo on 2020/10/18.
 */
class SumOfRootToLeafBinaryNumbers {

    /**
     * You are given the root of a binary tree where each node has a value 0 or 1.  Each root-to-leaf path represents a binary number starting with the most significant bit.  For example, if the path is 0 -> 1 -> 1 -> 0 -> 1, then this could represent 01101 in binary, which is 13.
     * <p>
     * For all leaves in the tree, consider the numbers represented by the path from the root to that leaf.
     * <p>
     * Return the sum of these numbers. The answer is guaranteed to fit in a 32-bits integer.
     * <p>
     * <p>
     * <p>
     * Example 1:
     * <p>
     * <p>
     * Input: root = [1,0,1,0,1,0,1]
     * Output: 22
     * Explanation: (100) + (101) + (110) + (111) = 4 + 5 + 6 + 7 = 22
     * <p>
     * Example 2:
     * Input: root = [0]
     * Output: 0
     * <p>
     * Example 3:
     * Input: root = [1]
     * Output: 1
     * <p>
     * Example 4:
     * Input: root = [1,1]
     * Output: 3
     * <p>
     * Constraints:
     * <p>
     * The number of nodes in the tree is in the range [1, 1000].
     * Node.val is 0 or 1.
     */

    /*
     * 思路
     * 递归深度遍历二叉树，记录一个 sum，记录一次遍历到叶子节点的 curValue
     */

    /*
     * Success
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Sum of Root To Leaf Binary Numbers.
     * Memory Usage: 38 MB, less than 13.40% of Java online submissions for Sum of Root To Leaf Binary Numbers.
     */
    public int sumRootToLeaf(TreeNode root) {
        int[] sum = {0}; // 因为引入传递，所以需要定义为一个数组
        traverseTree(root, 0, sum);
        return sum[0];
    }

    private void traverseTree(TreeNode node, int curValue, int[] sum) {
        if (node == null) return; // 理论上 node 应该非空
        int value = (curValue << 1) + node.val;
        if (node.left == null && node.right == null) { // 叶节点
            sum[0] += value;
            return;
        }
        if (node.left != null) {
            traverseTree(node.left, value, sum);
        }
        if (node.right != null) {
            traverseTree(node.right, value, sum);
        }
    }
}
