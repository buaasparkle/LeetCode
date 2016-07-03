package fun.sure.leetcode.easy;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by wangshuo on 2016/6/7.
 */
public class IntersectionOfTwoArrays {

    /**
     * Given two arrays, write a function to compute their intersection.
     * Example: Given nums1 = [1, 2, 2, 1], nums2 = [2, 2], return [2].
     * Note: Each element in the result must be unique. The result can be in any order.
     */

    // [PASS]
    public int[] intersection(int[] nums1, int[] nums2) {
        if (nums1 == null || nums2 == null) {
            return null;
        }
        Map<Integer, Boolean> map = new HashMap<>();
        for (int i : nums1) {
            map.put(i, true);
        }

        Set<Integer> result = new HashSet<>();
        for (int i : nums2) {
            if (map.containsKey(i) && map.get(i)) {
                result.add(i);
            }
        }

        int[] intersectionResult = new int[result.size()];
        int i = 0;
        for (Integer integer : result) {
            intersectionResult[i] = integer;
            i++;
        }
        return intersectionResult;
    }
}

