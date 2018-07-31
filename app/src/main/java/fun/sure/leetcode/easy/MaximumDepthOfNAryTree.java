package fun.sure.leetcode.easy;

import fun.sure.leetcode.common.Node;

/**
 * Created by sure on 2018/7/31.
 */

public class MaximumDepthOfNAryTree {

    /**
     * Given a n-ary tree, find its maximum depth.

     The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.

     For example, given a 3-ary tree:





     We should return its max depth, which is 3.

     Note:

     The depth of the tree is at most 1000.
     The total number of nodes is at most 5000.
     */

    // [ACCEPTED] 没考虑耗时问题
    public int maxDepth(Node root) {
        if (root == null ) {
            return 0;
        }
        if (root.children == null || root.children.size() == 0) {
            return 1;
        }
        int max = 0;
        int depth;
        for (int i = 0; i < root.children.size(); i++) {
            depth = maxDepth(root.children.get(i)) + 1;
            max = Math.max(max, depth);
        }
        return max;
    }
}
