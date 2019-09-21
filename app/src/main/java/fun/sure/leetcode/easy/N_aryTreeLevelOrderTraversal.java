package fun.sure.leetcode.easy;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class N_aryTreeLevelOrderTraversal {

    /**
     * Given an n-ary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).
     *
     * For example, given a 3-ary tree:
     *
     *
     *
     *
     *
     *
     *
     * We should return its level order traversal:
     *
     * [
     *      [1],
     *      [3,2,4],
     *      [5,6]
     * ]
     *
     *
     * Note:
     *
     * The depth of the tree is at most 1000.
     * The total number of nodes is at most 5000.
     */

    private static class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val,List<Node> _children) {
            val = _val;
            children = _children;
        }
    }

    // [AC]
    public List<List<Integer>> levelOrder(Node root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<List<Integer>> result = new ArrayList<>();
        LinkedList<Node> nodeList = new LinkedList<>();
        nodeList.add(root);
        while (!nodeList.isEmpty()) {
            int len = nodeList.size();
            List<Integer> list = new ArrayList<>();
            while (len-- > 0 && !nodeList.isEmpty()) {
                Node node = nodeList.poll();
                list.add(node.val);
                if (node.children != null) {
                    for (Node child : node.children) {
                        nodeList.offer(child);
                    }
                }
            }
            result.add(list);
        }
        return result;
    }
}
