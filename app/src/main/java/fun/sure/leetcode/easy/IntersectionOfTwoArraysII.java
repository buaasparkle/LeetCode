package fun.sure.leetcode.easy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by wangshuo on 2016/6/7.
 */
public class IntersectionOfTwoArraysII {

    /**
     * Given two arrays, write a function to compute their intersection.

     Example:
     Given nums1 = [1, 2, 2, 1], nums2 = [2, 2], return [2, 2].

     Note:
     Each element in the result should appear as many times as it shows in both arrays.
     The result can be in any order.

     Follow up:
     What if the given array is already sorted? How would you optimize your algorithm?
     What if nums1's size is small compared to nums2's size? Which algorithm is better?
     What if elements of nums2 are stored on disk, and the memory is limited such that you cannot load all elements into the memory at once?
     */

    // [PASS]
    public int[] intersect(int[] nums1, int[] nums2) {
        if (nums1 == null || nums2 == null) {
            return null;
        }
        Map<Integer, Integer> map1 = getNumCountMap(nums1);
        Map<Integer, Integer> map2 = getNumCountMap(nums2);

        List<Integer> result = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry1 : map1.entrySet()) {
            int key = entry1.getKey();
            if (map2.containsKey(key)) {
                int count = Math.min(entry1.getValue(), map2.get(key));
                for (int i = 0; i < count; i++) {
                    result.add(key);
                }
            }
        }

        int[] intersectionResult = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            intersectionResult[i] = result.get(i);
        }
        return intersectionResult;
    }

    private Map<Integer, Integer> getNumCountMap(int[] num) {
        Map<Integer, Integer> map = new HashMap<>();
        if (num != null) {
            for (int i : num) {
                map.put(i, map.containsKey(i) ? map.get(i) + 1 : 1);
            }
        }
        return map;
    }
}
