package fun.sure.leetcode.easy;

/**
 * Created by wangshuo on 2016/6/7.
 */
public class MoveZeroes {

    /**
     * Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.
     * For example, given nums = [0, 1, 0, 3, 12], after calling your function, nums should be [1, 3, 12, 0, 0].
     * Note:
     * You must do this in-place without making a copy of the array.
     * Minimize the total number of operations.
     */

    // [PASS]
    public void moveZeroes(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return;
        }
        int k = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[k] = nums[i];
                k++;
            }
        }
        while (k < nums.length) {
            nums[k] = 0;
            k++;
        }
    }
}
