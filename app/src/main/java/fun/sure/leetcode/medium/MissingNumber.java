package fun.sure.leetcode.medium;

/**
 * Created by wangshuo on 2016/6/27.
 */
public class MissingNumber {

    /**
     * Given an array containing n distinct numbers taken from 0, 1, 2, ..., n, find the one that is missing from the array.

     For example,
     Given nums = [0, 1, 3] return 2.

     Note:
     Your algorithm should run in linear runtime complexity. Could you implement it using only constant extra space complexity?
     */

    // 因为n个不同的数是有规律的，所以缺失的数是：(0+n)*(n+1)/2 - sum(nums)
    // [PASS]
    public int missingNumber(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int n = nums.length;
        long sumAll = n * (n + 1) / 2;
        long sum = 0;
        for (int num : nums) {
            sum += num;
        }
        return (int) (sumAll - sum);
    }
}
