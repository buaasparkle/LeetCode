package fun.sure.leetcode.easy;

public class ThirdMaximumNumber {

    /**
     * Given a non-empty array of integers, return the third maximum number in this array. If it does not exist, return the maximum number. The time complexity must be in O(n).
     *
     * Example 1:
     * Input: [3, 2, 1]
     *
     * Output: 1
     *
     * Explanation: The third maximum is 1.
     * Example 2:
     * Input: [1, 2]
     *
     * Output: 2
     *
     * Explanation: The third maximum does not exist, so the maximum (2) is returned instead.
     * Example 3:
     * Input: [2, 2, 3, 1]
     *
     * Output: 1
     *
     * Explanation: Note that the third maximum here means the third maximum distinct number.
     * Both numbers with value 2 are both considered as second maximum.
     */

    public int thirdMax(int[] nums) {
        Integer max = null;
        Integer snd = null;
        Integer thd = null;
        for (int i = 0; i < nums.length; i++) {
            if (max == null || nums[i] > max) {
                thd = snd;
                snd = max;
                max = nums[i];
            } else if (nums[i] == max) {
                // do nothing
            } else if (snd == null || nums[i] > snd) {
                thd = snd;
                snd = nums[i];
            } else if (nums[i] == snd) {
                // do nothing
            } else if (thd == null || nums[i] > thd) {
                thd = nums[i];
            }
        }
        return thd != null ? thd : max;
    }

    public static void main(String[] args) {
        System.out.println(new ThirdMaximumNumber().thirdMax(new int[]{1, 2, 2, 5, 3, 5}));
    }
}
