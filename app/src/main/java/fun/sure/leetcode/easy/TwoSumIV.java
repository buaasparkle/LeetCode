package fun.sure.leetcode.easy;

import java.util.HashMap;
import java.util.Map;

import fun.sure.leetcode.common.TreeNode;

/**
 * Created by sure on 2018/7/31.
 */

public class TwoSumIV {

    /**
     * Given a Binary Search Tree and a target number, return true if there exist two elements in the BST such that their sum is equal to the given target.

     Example 1:
     Input:
     5
     / \
     3   6
     / \   \
     2   4   7

     Target = 9

     Output: True
     Example 2:
     Input:
     5
     / \
     3   6
     / \   \
     2   4   7

     Target = 28

     Output: False
     */

    // [ACCEPTED] 但是好像没有利用到 BST 的特点
    Map<Integer, Integer> nodeMap = new HashMap<>();

    public boolean findTarget(TreeNode root, int k) {
        traverseTree(root);
        int left;
        boolean find = false;
        for (Integer val : nodeMap.keySet()) {
            left = k - val;
            if (left == val) {
                find = (nodeMap.get(val) == 2);
            } else {
                find = nodeMap.get(left) != null;
            }
            if (find) {
                break;
            }
        }
        return find;
    }

    private void traverseTree(TreeNode node) {
        if (node == null) {
            return;
        }
        traverseTree(node.left);
        if (!nodeMap.containsKey(node.val)) {
            nodeMap.put(node.val, 0);
        }
        nodeMap.put(node.val, nodeMap.get(node.val) + 1);
        traverseTree(node.right);
    }
}
