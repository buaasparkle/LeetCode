package fun.sure.leetcode.easy.tree;

import java.util.ArrayList;
import java.util.List;

import fun.sure.leetcode.common.TreeNode;

/**
 * Created by wangshuo on 2020/11/21.
 */
public class FindModeInBinarySearchTree {

    /**
     * Given a binary search tree (BST) with duplicates, find all the mode(s) (the most frequently occurred element) in the given BST.
     *
     * Assume a BST is defined as follows:
     *
     * The left subtree of a node contains only nodes with keys less than or equal to the node's key.
     * The right subtree of a node contains only nodes with keys greater than or equal to the node's key.
     * Both the left and right subtrees must also be binary search trees.
     *
     *
     * For example:
     * Given BST [1,null,2,2],
     *
     *    1
     *     \
     *      2
     *     /
     *    2
     *
     *
     * return [2].
     *
     * Note: If a tree has more than one mode, you can return them in any order.
     */

    /*
     * mode: 在统计学中表示 众数，即集合中重复出现最多的元素
     *
     * 思路：
     * 中序遍历，保证 BST 是按由小到大顺序的，记录当前最大值对应的数组即可
     */


    /*
     * Success
     *
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Find Mode in Binary Search Tree.
     * Memory Usage: 39.3 MB, less than 87.93% of Java online submissions for Find Mode in Binary Search Tree.
     */

    // 偷懒维护了一个 field 保存上次访问的节点，如果要包在函数中，可以考虑封装到一个类中提供 get/set 方法
    private TreeNode lastVisited;

    public int[] findMode(TreeNode root) {
        lastVisited = null;
        CountModes countModes = new CountModes();
        if (root != null) {
            traverseTree(root, countModes);
            // 遍历结束检查一下最后一组数据
            countModes.checkCount();
        }
        return countModes.modeToIntArray();
    }

    // 中序遍历
    private void traverseTree(TreeNode root, CountModes countModes) {
        if (root == null) {
            return;
        }
        traverseTree(root.left, countModes);
        countModes.visitNode(root, lastVisited);
        lastVisited = root;
        traverseTree(root.right, countModes);
    }

    private static class CountModes {
        // 当前的值和重复次数
        int curCount = 0;
        int curValue = 0;

        // 目前最值最大的重复次数
        int maxCount = 0;

        // 众数数组
        List<Integer> modes = new ArrayList<>();

        void init(int newValue) {
            curValue = newValue;
            curCount = 1;
        }

        // 根据当前访问和上次访问节点关系，更新值
        void visitNode(TreeNode root, TreeNode lastVisited) {
            if (lastVisited == null) {
                init(root.val);
            } else if (lastVisited.val == root.val) {
                curCount += 1;
            } else {
                checkCount();
                init(root.val);
            }
        }

        // 一般在访问值发生变化时检查更新
        void checkCount() {
            if (curCount > maxCount) {
                maxCount = curCount;
                modes.clear();
                modes.add(curValue);
            } else if (curCount == maxCount) {
                modes.add(curValue);
            } else {
                // pass
            }
            resetCur();
        }

        private void resetCur() {
            curCount = 0;
            curValue = 0;
        }

        public int[] modeToIntArray() {
            int[] array = new int[modes.size()];
            for (int i = 0; i < modes.size(); i++) {
                array[i] = modes.get(i);
            }
            return array;
        }
    }
}
