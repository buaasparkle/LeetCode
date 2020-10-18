package fun.sure.leetcode.common;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wangshuo on 2016/6/19.
 */
public class TreeNode {

    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int x) {
        val = x;
    }

    // 根据完全二叉树从上到下，从左到右的顺序，将对应位置的 value 值组成数组，构建 Tree，null 值表示对应位置的节点不存在
    public static TreeNode buildFrom(Integer[] array) {
        List<TreeNode> treeNodeList = new ArrayList<>();
        for (int i = 0; i < array.length; i++) {
            TreeNode node = array[i] != null ? new TreeNode(array[i]) : null;
            treeNodeList.add(node);

            // find parent
            int parentIndex = (i - 1) >> 1;
            if (parentIndex < 0) {
                continue;
            }
            TreeNode parentNode = treeNodeList.get(parentIndex);
            if (parentNode == null) {
                continue;
            }
            if (i % 2 == 1) {
                parentNode.left = node;
            } else {
                parentNode.right = node;
            }
        }
        return treeNodeList.size() > 0 ? treeNodeList.get(0) : null;
    }
}
