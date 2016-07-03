package fun.sure.leetcode.easy;

/**
 * Created by wangshuo on 2016/6/19.
 */
public class RangeSumQuery {

    /**
     * Given an integer array nums, find the sum of the elements between indices i and j (i ≤ j), inclusive.

     Example:
     Given nums = [-2, 0, 3, -5, 2, -1]

     sumRange(0, 2) -> 1
     sumRange(2, 5) -> -1
     sumRange(0, 5) -> -3

     Note:
     You may assume that the array does not change.
     There are many calls to sumRange function.
     */

    // [PASS]
    private final int[] nums;

    public RangeSumQuery(int[] nums) {
        this.nums = nums;
    }

    public int sumRange(int i, int j) {
        if (nums == null || i < 0 || j > nums.length - 1 || i > nums.length - 1 || i > j) {
            return 0;
        }
        int sum = 0;
        for (int ii = i; ii < j; ii++) {
            sum += nums[ii];
        }
        return sum;
    }
}
