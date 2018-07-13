package fun.sure.leetcode.easy;

import java.util.ArrayList;
import java.util.List;

import fun.sure.leetcode.common.TreeNode;

/**
 * Created by sure on 2018/7/13.
 */

public class AverageOfLevelsInBinaryTree {
    /**
     * Given a non-empty binary tree, return the average value of the nodes on each level in the form of an array.
     Example 1:
     Input:
     3
     / \
     9  20
     /  \
     15   7
     Output: [3, 14.5, 11]
     Explanation:
     The average value of nodes on level 0 is 3,  on level 1 is 14.5, and on level 2 is 11. Hence return [3, 14.5, 11].
     */

    public List<Double> averageOfLevels(TreeNode root) {
        List<TreeNode> queue = new ArrayList<>();
        List<Double> levelAvgList = new ArrayList<>();
        queue.add(root);
        List<TreeNode> queueTmp = new ArrayList<>();
        while (!queue.isEmpty()) {
            double sum = 0f;
            for (int i = 0; i < queue.size(); i++) {
                TreeNode node = queue.get(i);
                sum += node.val;
                if (node.left != null) {
                    queueTmp.add(node.left);
                }
                if (node.right != null) {
                    queueTmp.add(node.right);
                }
            }
            levelAvgList.add(sum / queue.size());
            queue.clear();
            queue.addAll(queueTmp);
            queueTmp.clear();
        }
        return levelAvgList;
    }
}
