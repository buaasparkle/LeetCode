package fun.sure.leetcode.easy;

import android.util.ArraySet;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import fun.sure.leetcode.common.TreeNode;

public class PathSumIII {

    /**
     * You are given a binary tree in which each node contains an integer value.
     *
     * Find the number of paths that sum to a given value.
     *
     * The path does not need to start or end at the root or a leaf, but it must go downwards (traveling only from parent nodes to child nodes).
     *
     * The tree has no more than 1,000 nodes and the values are in the range -1,000,000 to 1,000,000.
     *
     * Example:
     *
     * root = [10,5,-3,3,2,null,11,3,-2,null,1], sum = 8
     *
     *       10
     *      /  \
     *     5   -3
     *    / \    \
     *   3   2   11
     *  / \   \
     * 3  -2   1
     *
     * Return 3. The paths that sum to 8 are:
     *
     * 1.  5 -> 3
     * 2.  5 -> 2 -> 1
     * 3. -3 -> 11
     */

    // [AC]
    private int paths = 0;

    public int pathSum(TreeNode root, int sum) {
        Map<TreeNode, List<Integer>> treeNodeSetMap = new HashMap<>();
        buildMap(root, treeNodeSetMap, sum);
        return paths;
    }

    private void buildMap(TreeNode root, Map<TreeNode, List<Integer>> map, int sum) {
        if (root == null) {
            return;
        }
        if (!map.containsKey(root)) {
            map.put(root, new ArrayList<Integer>());
        }
        if (root.left == null && root.right == null) {
            map.get(root).add(root.val);
        } else {
            buildMap(root.left, map, sum);
            buildMap(root.right, map, sum);
            List<Integer> leftRightList = new ArrayList<>();
            if (root.left != null) {
                leftRightList.addAll(map.get(root.left));
            }
            if (root.right != null) {
                leftRightList.addAll(map.get(root.right));
            }
            map.get(root).add(root.val);
            for (Integer value : leftRightList) {
                map.get(root).add(value + root.val);
            }
        }
        for (Integer path : map.get(root)) {
            if (path == sum) {
                paths++;
            }
        }
    }

    public static void main(String[] args) {
        // build tree
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.left.left = new TreeNode(3);
        root.left.left.left = new TreeNode(3);
        root.left.left.right = new TreeNode(-2);
        root.left.right = new TreeNode(2);
        root.left.right.right = new TreeNode(1);
        root.right = new TreeNode(-3);
        root.right.right = new TreeNode(11);
        System.out.println(new PathSumIII().pathSum(root, 8));
    }
}
