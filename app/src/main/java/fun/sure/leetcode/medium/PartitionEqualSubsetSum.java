package fun.sure.leetcode.medium;

import fun.sure.leetcode.Topics;

/**
 * Created by wangshuo on 2021/10/13.
 */
class PartitionEqualSubsetSum implements Topics.Array, Topics.DynamicProgramming {

    /**
     * Given a non-empty array nums containing only positive integers, find if the array can be partitioned into two subsets such that the sum of elements in both subsets is equal.
     * <p>
     * <p>
     * <p>
     * Example 1:
     * <p>
     * Input: nums = [1,5,11,5]
     * Output: true
     * Explanation: The array can be partitioned as [1, 5, 5] and [11].
     * Example 2:
     * <p>
     * Input: nums = [1,2,3,5]
     * Output: false
     * Explanation: The array cannot be partitioned into equal sum subsets.
     * <p>
     * <p>
     * Constraints:
     * <p>
     * 1 <= nums.length <= 200
     * 1 <= nums[i] <= 100
     */

    /*
    Success
    Runtime: 171 ms, faster than 8.93% of Java online submissions for Partition Equal Subset Sum.
    Memory Usage: 74.3 MB, less than 11.75% of Java online submissions for Partition Equal Subset Sum.
     */
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        if (sum % 2 != 0) {
            return false;
        }
        int target = sum / 2;
        // init memo
        Boolean[][] memo = new Boolean[nums.length][target + 1];
        // backtrack
        sequenceSum(nums, 0, target, memo);
        return memo[0][target] == Boolean.TRUE;
    }

    private boolean sequenceSum(int[] nums, int index, int remain, Boolean[][] memo) {
        if (remain == 0) {
            return true;
        }
        if (index >= nums.length || remain < 0) {
            return false;
        }
        if (memo[index][remain] != null) {
            return memo[index][remain];
        }
        memo[index][remain] = sequenceSum(nums, index + 1, remain - nums[index], memo)
                | sequenceSum(nums, index + 1, remain, memo);
        return memo[index][remain];
    }
}
