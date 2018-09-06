package fun.sure.leetcode.easy;

import java.util.ArrayList;
import java.util.List;

import fun.sure.leetcode.common.Node;

/**
 * Created by sure on 2018/9/7.
 */

public class N_aryTreePreorderTraversal {

    /**
     * Given an n-ary tree, return the preorder traversal of its nodes' values.


     For example, given a 3-ary tree:




     Return its preorder traversal as: [1,3,5,6,2,4].


     Note: Recursive solution is trivial, could you do it iteratively?
     */

    // [AC]
    public List<Integer> preorder(Node root) {
        List<Integer> list = new ArrayList<>();
        preorder(root, list);
        return list;
    }

    private void preorder(Node root, List<Integer> list) {
        if (root == null) {
            return;
        }
        list.add(root.val);
        if (root.children != null) {
            for (Node child : root.children) {
                preorder(child, list);
            }
        }
    }

}
