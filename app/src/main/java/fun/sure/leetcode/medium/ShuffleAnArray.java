package fun.sure.leetcode.medium;

import java.util.Random;

/**
 * Created by sure on 2017/2/19.
 */

public class ShuffleAnArray {

    /**
     * Shuffle a set of numbers without duplicates.

     Example:

     // Init an array with set 1, 2, and 3.
     int[] nums = {1,2,3};
     Solution solution = new Solution(nums);

     // Shuffle the array [1,2,3] and return its result. Any permutation of [1,2,3] must equally likely to be returned.
     solution.shuffle();

     // Resets the array back to its original configuration [1,2,3].
     solution.reset();

     // Returns the random shuffling of array [1,2,3].
     solution.shuffle();
     */

    private int[] _nums;
    private Random random;

    public ShuffleAnArray(int[] nums) {
        _nums = nums;
        random = new Random();
    }

    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        return _nums;
    }

    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        if (_nums == null) {
            return null;
        }
        int length = _nums.length;
        int[] ret = _nums.clone();
        for (int i = 0; i < ret.length; i++) {
            int j = random.nextInt(length);
            int tmp = ret[i];
            ret[i] = ret[j];
            ret[j] = tmp;
        }
        return ret;
    }
}
