package fun.sure.leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by wangshuo on 2016/6/27.
 */
public class _TopKFrequentElements {

    /**
     *Given a non-empty array of integers, return the k most frequent elements.

     For example,
     Given [1,1,1,2,2,3] and k = 2, return [1,2].

     Note:
     You may assume k is always valid, 1 ≤ k ≤ number of unique elements.
     Your algorithm's time complexity must be better than O(n log n), where n is the array's size.
     */

    public List<Integer> topKFrequent(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        Arrays.sort(nums);
        List<Integer> result = new ArrayList<>();
        result.add(nums[0]);
        int count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (count == k) {
                break;
            }
            if (nums[i] == nums[i - 1]) {
                continue;
            } else {
                count++;
                result.add(nums[i]);
            }
        }
        return result;
    }
}
