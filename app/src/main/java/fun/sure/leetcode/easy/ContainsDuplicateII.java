package fun.sure.leetcode.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by wangshuo on 2016/6/18.
 */
public class ContainsDuplicateII {

    /**
     * Given an array of integers and an integer k, find out whether there are two distinct indices
     * i and j in the array such that nums[i] = nums[j] and the difference between i and j is at most k.
     */

    // [PASS]
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        if (nums == null || nums.length <= 1 || k < 1) {
            return false;
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                if (i - map.get(nums[i]) <= k) {
                    return true;
                }
            }
            map.put(nums[i], i);
        }
        return false;
    }
}
