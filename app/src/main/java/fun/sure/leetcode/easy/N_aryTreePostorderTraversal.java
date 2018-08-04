package fun.sure.leetcode.easy;

import java.util.ArrayList;
import java.util.List;

import fun.sure.leetcode.common.Node;

/**
 * Created by sure on 2018/8/4.
 */

public class N_aryTreePostorderTraversal {

    /**
     * Given an n-ary tree, return the postorder traversal of its nodes' values.


     For example, given a 3-ary tree:


     https://leetcode.com/problems/n-ary-tree-postorder-traversal/description/

     Return its postorder traversal as: [5,6,3,2,4,1].


     Note: Recursive solution is trivial, could you do it iteratively?
     */

    // [ACCEPTED]
    public List<Integer> postorder(Node root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        if (root.children != null) {
            for (Node child : root.children) {
                List<Integer> childOrder = postorder(child);
                if (childOrder.size() > 0) {
                    list.addAll(childOrder);
                }
            }
        }
        list.add(root.val);
        return list;
    }
}
