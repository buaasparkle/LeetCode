package fun.sure.leetcode.easy;

/**
 * Created by wangshuo on 2020/6/22.
 */
class RunningSumOf1dArray {

    /**
     * Given an array nums. We define a running sum of an array as runningSum[i] = sum(nums[0]…nums[i]).
     *
     * Return the running sum of nums.
     *
     *
     *
     * Example 1:
     *
     * Input: nums = [1,2,3,4]
     * Output: [1,3,6,10]
     * Explanation: Running sum is obtained as follows: [1, 1+2, 1+2+3, 1+2+3+4].
     * Example 2:
     *
     * Input: nums = [1,1,1,1,1]
     * Output: [1,2,3,4,5]
     * Explanation: Running sum is obtained as follows: [1, 1+1, 1+1+1, 1+1+1+1, 1+1+1+1+1].
     * Example 3:
     *
     * Input: nums = [3,1,2,10,1]
     * Output: [3,4,6,16,17]
     *
     *
     * Constraints:
     *
     * 1 <= nums.length <= 1000
     * -10^6 <= nums[i] <= 10^6
     */

    /**
     * Success
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Running Sum of 1d Array.
     * Memory Usage: 39.6 MB, less than 100.00% of Java online submissions for Running Sum of 1d Array.
     */
    public int[] runningSum(int[] nums) {
        int len = nums.length;
        int[] ret = new int[len];

        int sum = 0;
        for (int i = 0; i < len; i++) {
            ret[i] = sum + nums[i];
            sum = ret[i];
        }
        return ret;
    }
}
