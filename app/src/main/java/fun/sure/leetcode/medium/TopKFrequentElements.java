package fun.sure.leetcode.medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

/**
 * Created by wangshuo on 2016/6/27.
 */
public class TopKFrequentElements {

    /**
     * Given a non-empty array of integers, return the k most frequent elements.
     * <p>
     * For example,
     * Given [1,1,1,2,2,3] and k = 2, return [1,2].
     * <p>
     * Note:
     * You may assume k is always valid, 1 ≤ k ≤ number of unique elements.
     * Your algorithm's time complexity must be better than O(n log n), where n is the array's size.
     */

    /*
    Success
    Runtime: 9 ms, faster than 87.90% of Java online submissions for Top K Frequent Elements.
    Memory Usage: 42 MB, less than 42.63% of Java online submissions for Top K Frequent Elements.
     */
    public int[] topKFrequent(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        HashMap<Integer, ElementCount> map = new HashMap<>();
        for (int num : nums) {
            if (!map.containsKey(num)) {
                map.put(num, new ElementCount(num));
            }
            ElementCount ec = map.get(num);
            if (ec != null) {
                ec.increaseCount();
            }
        }
        List<ElementCount> ecList = new ArrayList<>(map.values());
        Collections.sort(ecList, new Comparator<ElementCount>() {
            @Override
            public int compare(ElementCount o1, ElementCount o2) {
                return o2.count - o1.count;
            }
        });
        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = ecList.get(i).value;
        }
        return result;
    }

    private class ElementCount {
        int value;
        int count;

        public ElementCount(int value) {
            this.value = value;
            this.count = 0;
        }

        public void increaseCount() {
            count++;
        }
    }
}
