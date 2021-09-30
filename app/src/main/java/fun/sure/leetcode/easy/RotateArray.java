package fun.sure.leetcode.easy;

import fun.sure.leetcode.Topics;

/**
 * Created by wangshuo on 2016/6/19.
 */
public class RotateArray implements Topics.Array, Topics.Math, Topics.TwoPointers {

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

    // hint 提示考虑 reverse 的思路，可以不用申请额外空间
    // case [1,2,3,4,5,6,7], k = 3
    public void rotate2(int[] nums, int k) {
        int length = nums.length;
        k = k % length;
        int alt = length - k;

        if (alt == k) {
            for (int i = 0; i < k; i++) {
                swap(nums, i, i + k);
            }
        } else {
            // reverse larger part of array
            int start = alt > k ? 0 : alt;
            int reverseLen = Math.max(alt, k);
            reverse(nums, start, reverseLen);
            // result: [4,3,2,1,5,6,7]
            boolean isOdd = length % 2 == 1;
            int left = length / 2 - 1;
            int right = isOdd ? left + 2 : left + 1;
            while (left >= 0 && right < length) {
                swap(nums, left--, right++);
            }
            // result: [7,6,5,1,2,3,4]
            start = alt > k ? 0 : k;
            reverse(nums, start, Math.min(alt, k));
            // result: [5,6,7,1,2,3,4]
        }
    }

    private void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    private void reverse(int[] array, int start, int length) {
        for (int i = start, j = start + length - 1; i < j; i++, j--) {
            swap(array, i, j);
        }
    }

    public static void main(String[] args) {
        int[] nums = {
                1, 2, 3, 4, 5, 6, 7
        };
        new RotateArray().rotate2(nums, 2);
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i]);
        }
    }
}
