package fun.sure.leetcode.easy.tree;

import java.util.ArrayList;
import java.util.List;

import fun.sure.leetcode.common.TreeNode;

/**
 * Created by sure on 2018/7/31.
 */

public class ConvertBST2GreaterTree {

    /**
     * Given a Binary Search Tree (BST), convert it to a Greater Tree such that every key of the original BST is changed to the original key plus sum of all keys greater than the original key in BST.

     Example:

     Input: The root of a Binary Search Tree like this:
     5
     /   \
     2     13

     Output: The root of a Greater Tree like this:
     18
     /   \
     20     13

     */

    // [ACCEPTED]
    private List<TreeNode> list = new ArrayList<>();

    public TreeNode convertBST(TreeNode root) {
        inorder(root);
        for (int i = list.size() - 2; i >= 0; i--) {
            list.get(i).val += list.get(i + 1).val;
        }
        return root;
    }

    private void inorder(TreeNode root) {
        if (root == null) {
            return;
        }
        inorder(root.left);
        list.add(root);
        inorder(root.right);
    }
}
