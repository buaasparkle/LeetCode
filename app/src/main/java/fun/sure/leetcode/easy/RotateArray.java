package fun.sure.leetcode.easy;

/**
 * Created by wangshuo on 2016/6/19.
 */
public class RotateArray {

    /**
     * Rotate an array of n elements to the right by k steps.

     For example, with n = 7 and k = 3, the array [1,2,3,4,5,6,7] is rotated to [5,6,7,1,2,3,4].
     */

    // [PASS]
    public void rotate(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return;
        }
        k %= nums.length;
        if (k > 0) {
            int len = nums.length;
            int[] temp = new int[k];
            for (int i = 0; i < temp.length; i++) {
                temp[i] = nums[len - k + i];
            }
            for (int i = len - 1; i >= k ; i--) {
                nums[i] = nums[(i - k + len) % len];
            }
            for (int i = 0; i < temp.length; i++) {
                nums[i] = temp[i];
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {
                1, 2, 3, 4, 5, 6, 7
        };
        new RotateArray().rotate(nums, 6);
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i]);
        }
    }
}
