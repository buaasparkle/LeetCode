package fun.sure.leetcode.easy.tree;

import java.util.ArrayList;
import java.util.List;

import fun.sure.leetcode.common.TreeNode;

/**
 * Created by wangshuo on 2016/6/19.
 */
public class BinaryTreePaths {

    /**
     *Given a binary tree, return all root-to-leaf paths.

     For example, given the following binary tree:

     1
     /   \
     2     3
     \
     5
     All root-to-leaf paths are:

     ["1->2->5", "1->3"]
     */

    List<Integer> path = new ArrayList<>();
    List<String> result = new ArrayList<>();

    public List<String> binaryTreePaths(TreeNode root) {
        if (root != null) {
            printPath(root);
        }
        return result;
    }

    private void printPath(TreeNode node) {
        path.add(node.val);
        if (isLeaf(node)) {
            StringBuilder sb = new StringBuilder();
            sb.append(path.get(0));
            for (int i = 1; i < path.size(); i++) {
                sb.append("->").append(path.get(i));
            }
            result.add(sb.toString());
        }
        if (node.left != null) {
            printPath(node.left);
        }
        if (node.right != null) {
            printPath(node.right);
        }
        path.remove(path.size() - 1);
    }

    private boolean isLeaf(TreeNode node) {
        return node != null && node.left == null && node.right == null;
    }
}

