package fun.sure.leetcode.medium.tree;

import fun.sure.leetcode.common.TreeNode;

/**
 * Created by wangshuo on 2020/12/19.
 */
class SumOfNodesWithEvenValuedGrandparent {

    /**
     * https://leetcode.com/problems/sum-of-nodes-with-even-valued-grandparent/
     *
     * Given a binary tree, return the sum of values of nodes with even-valued grandparent.  (A grandparent of a node is the parent of its parent, if it exists.)
     *
     * If there are no nodes with an even-valued grandparent, return 0.
     */

    /*
     * 思路
     *
     * 返回值为偶数节点的孙子节点值的合
     */

    /*
     * Success
     * Runtime: 1 ms, faster than 98.59% of Java online submissions for Sum of Nodes with Even-Valued Grandparent.
     * Memory Usage: 40.9 MB, less than 69.68% of Java online submissions for Sum of Nodes with Even-Valued Grandparent.
     */
    public int sumEvenGrandparent(TreeNode root) {
        int[] sum = new int[]{0};
        sumEvenValueNodeGrandSon(root, sum);
        return sum[0];
    }

    private void sumEvenValueNodeGrandSon(TreeNode grandParent, int[] sum) {
        if (grandParent == null) {
            return;
        }
        if (isEvent(grandParent.val)) {
            sum[0] += sumOfGrandSon(grandParent);
        }
        sumEvenValueNodeGrandSon(grandParent.left, sum);
        sumEvenValueNodeGrandSon(grandParent.right, sum);
    }

    private int sumOfGrandSon(TreeNode node) {
        return node != null ? sumOfSon(node.left) + sumOfSon(node.right) : 0;
    }

    private int sumOfSon(TreeNode node) {
        if (node == null) {
            return 0;
        }
        return nodeValue(node.left) + nodeValue(node.right);
    }

    private int nodeValue(TreeNode node) {
        return node != null ? node.val : 0;
    }

    private static boolean isEvent(int value) {
        return value % 2 == 0;
    }
}
