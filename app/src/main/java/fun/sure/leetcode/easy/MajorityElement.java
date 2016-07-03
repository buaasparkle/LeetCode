package fun.sure.leetcode.easy;

import java.util.HashMap;

/**
 * Created by wangshuo on 2016/6/7.
 */
public class MajorityElement {

    /**
     * Given an array of size n, find the majority element. The majority element is the element that appears more than ⌊ n/2 ⌋ times.
     * You may assume that the array is non-empty and the majority element always exist in the array.
     */

    // [PASS]
    public int majorityElement(int[] nums) {
        int n = nums.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            int value = map.containsKey(num) ? map.get(num) + 1 : 1;
            if ((n % 2 == 0 && value >= n / 2) ||
                    (n % 2 == 1 && value > n / 2)) { // 这里开始写成value >= n /2 没有判断奇偶的情况，[6, 5, 5]
                return num;
            }
            map.put(num, value);
        }
        return 0;
    }
}
