package fun.sure.leetcode.medium;

import fun.sure.leetcode.common.TreeNode;

/**
 * Created by sure on 2017/10/16.
 */

public class MaximumBinaryTree {

    /**
     * Given an integer array with no duplicates. A maximum tree building on this array is defined as follow:

     The root is the maximum number in the array.
     The left subtree is the maximum tree constructed from left part subarray divided by the maximum number.
     The right subtree is the maximum tree constructed from right part subarray divided by the maximum number.
     Construct the maximum tree by the given array and output the root node of this tree.

     Example 1:
     Input: [3,2,1,6,0,5]
     Output: return the tree root node representing the following tree:

        6
      /   \
     3     5
     \    /
      2  0
      \
       1

     Note:
     The size of the given array will be in the range [1,1000].
     */

    public TreeNode constructMaximumBinaryTree(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        } else if (nums.length == 1) {
            return new TreeNode(nums[0]);
        } else {
            // find max number
            int max = nums[0];
            int maxIndex = 0;
            for (int i = 1; i < nums.length; i++) {
                if (nums[i] > max) {
                    max = nums[i];
                    maxIndex = i;
                }
            }
            TreeNode rootNode = new TreeNode(max);

            // split into 2 sub-arrays
            int[] leftArray = new int[maxIndex];
            int[] rightArray = new int[nums.length - maxIndex - 1];
            int leftIndex = 0;
            int rightIndex = 0;
            for (int i = 0; i < nums.length; i++) {
                if (i < maxIndex) {
                    leftArray[leftIndex++] = nums[i];
                }
                if (i > maxIndex) {
                    rightArray[rightIndex++] = nums[i];
                }
            }

            rootNode.left = constructMaximumBinaryTree(leftArray);
            rootNode.right = constructMaximumBinaryTree(rightArray);

            return rootNode;
        }
    }
}
