package fun.sure.leetcode.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by wangshuo on 2016/6/13.
 */
public class HouseRobber {

    /**
     * You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed,
     * the only constraint stopping you from robbing each of them is that adjacent houses have security system connected and
     * it will automatically contact the police if two adjacent houses were broken into on the same night.
     *
     * Given a list of non-negative integers representing the amount of money of each house, determine the maximum amount of
     * money you can rob tonight without alerting the police.
     */

    // [TIME LIMIT EXCEEDED]
    // 加入map保存中间数据后，[PASS]
    private Map<Integer, Integer> startIndexCountMap = new HashMap<>();

    public int rob(int[] nums) {
        return rob(nums, 0);
    }

    private int rob(int[] nums, int startIndex) {
        if (nums == null || nums.length == 0 || startIndex >= nums.length) {
            return 0;
        }
        if (startIndexCountMap.containsKey(startIndex)) {
            return startIndexCountMap.get(startIndex);
        }
        if (nums.length - startIndex == 1) {
            saveToMap(startIndex, nums[startIndex]);
            return nums[startIndex];
        } else if (nums.length - startIndex == 2) {
            int count = Math.max(nums[startIndex], nums[startIndex + 1]);
            saveToMap(startIndex, count);
            return count;
        } else {
            int max = 0;
            int count;
            for (int i = startIndex; i < nums.length; i++) {
                for (int j = i + 2; j < nums.length; j++) {
                    count = nums[i] + rob(nums, j);
                    if (count > max) {
                        max = count;
                    }
                }
                if (nums[i] > max) {
                    max = nums[i];
                }
            }
            saveToMap(startIndex, max);
            return max;
        }
    }

    private void saveToMap(int startIndex, int count) {
        if (!startIndexCountMap.containsKey(startIndex)) {
            startIndexCountMap.put(startIndex, count);
        }
    }
}
