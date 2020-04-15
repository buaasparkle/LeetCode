package fun.sure.leetcode.medium;

public class LongestIncreasingSubsequence {

    /**
     * Given an unsorted array of integers, find the length of longest increasing subsequence.
     *
     * Example:
     *
     * Input: [10,9,2,5,3,7,101,18]
     * Output: 4
     * Explanation: The longest increasing subsequence is [2,3,7,101], therefore the length is 4.
     * Note:
     *
     * There may be more than one LIS combination, it is only necessary for you to return the length.
     * Your algorithm should run in O(n2) complexity.
     * Follow up: Could you improve it to O(n log n) time complexity?
     *
     */

    // [pass]
    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int[] counts = new int[nums.length];
        for (int i = 0; i < counts.length; i++) {
            counts[i] = 1;
        }
        int maxLength = counts[0];
        for (int i = 1; i < nums.length; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (nums[i] > nums[j]) {
                    counts[i] = Math.max(counts[j] + 1, counts[i]);
                    if (counts[i] > maxLength) {
                        maxLength = counts[i];
                    }
                }
            }
        }
        return maxLength;
    }
}
