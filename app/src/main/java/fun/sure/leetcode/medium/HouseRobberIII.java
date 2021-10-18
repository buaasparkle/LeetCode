package fun.sure.leetcode.medium;

import java.util.HashMap;
import java.util.Map;

import fun.sure.leetcode.Topics;
import fun.sure.leetcode.common.TreeNode;

/**
 * Created by wangshuo on 2021/10/18.
 */
class HouseRobberIII implements Topics.DynamicProgramming, Topics.Tree, Topics.DFS, Topics.BinaryTree {

    /**
     * https://leetcode.com/problems/house-robber-iii/
     * <p>
     * The thief has found himself a new place for his thievery again. There is only one entrance to this area, called root.
     * <p>
     * Besides the root, each house has one and only one parent house. After a tour, the smart thief realized that all houses in this place form a binary tree. It will automatically contact the police if two directly-linked houses were broken into on the same night.
     * <p>
     * Given the root of the binary tree, return the maximum amount of money the thief can rob without alerting the police.
     * <p>
     * <p>
     * <p>
     * Example 1:
     * <p>
     * <p>
     * Input: root = [3,2,3,null,3,null,1]
     * Output: 7
     * Explanation: Maximum amount of money the thief can rob = 3 + 3 + 1 = 7.
     * Example 2:
     * <p>
     * <p>
     * Input: root = [3,4,5,1,3,null,1]
     * Output: 9
     * Explanation: Maximum amount of money the thief can rob = 4 + 5 = 9.
     * <p>
     * <p>
     * Constraints:
     * <p>
     * The number of nodes in the tree is in the range [1, 104].
     * 0 <= Node.val <= 104
     */

    /*
    Success
    Runtime: 7 ms, faster than 6.12% of Java online submissions for House Robber III.
    Memory Usage: 41.8 MB, less than 11.31% of Java online submissions for House Robber III.
     */
    public int rob(TreeNode root) {
        Map<TreeNode, Money> map = new HashMap<>();
        return Math.max(rob(root, true, map), rob(root, false, map));
    }

    private int rob(TreeNode node, boolean rob, Map<TreeNode, Money> map) {
        if (map.containsKey(node)) {
            Money money = map.get(node);
            if (money != null && money.amountAvailable(rob)) {
                return money.amount(rob);
            }
        }
        if (node == null) {
            return 0;
        }
        int amount;
        if (rob) {
            amount = node.val + rob(node.left, false, map) + rob(node.right, false, map);
        } else {
            amount = Math.max(rob(node.left, true, map) + rob(node.right, true, map),
                    Math.max(rob(node.left, true, map) + rob(node.right, false, map),
                            Math.max(rob(node.left, false, map) + rob(node.right, true, map),
                                    rob(node.left, false, map) + rob(node.right, false, map))));
        }
        Money money = map.get(node);
        if (money == null) {
            money = new Money();
        }
        money.setAmount(rob, amount);
        map.put(node, money);
        return amount;
    }

    private class Money {
        private int amountIfRob = -1;
        private int amountNotRob = -1;

        public int max() {
            return Math.max(amountIfRob, amountNotRob);
        }

        public boolean amountAvailable(boolean rob) {
            return amount(rob) != -1;
        }

        public int amount(boolean rob) {
            return rob ? amountIfRob : amountNotRob;
        }

        public void setAmount(boolean rob, int amount) {
            if (rob) {
                this.amountIfRob = amount;
            } else {
                this.amountNotRob = amount;
            }
        }
    }
}
