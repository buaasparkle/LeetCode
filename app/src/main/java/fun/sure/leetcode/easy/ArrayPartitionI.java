package fun.sure.leetcode.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by sure on 2017/9/9.
 */

public class ArrayPartitionI {

    /**
     * Given an array of 2n integers, your task is to group these integers into n pairs of integer,
     * say (a1, b1), (a2, b2), ..., (an, bn) which makes sum of min(ai, bi) for all i from 1 to n as large as possible.

     Example 1:
     Input: [1,4,3,2]

     Output: 4
     Explanation: n is 2, and the maximum sum of pairs is 4 = min(1, 2) + min(3, 4).

     Note:
     n is a positive integer, which is in the range of [1, 10000].
     All the integers in the array will be in the range of [-10000, 10000].
     */

    /**
     * 思路：
     * 由所给例子直观感觉需要 由小到大 拍个续，然后按顺序两两组合
     * 证明：[a, b, c, d] (a<b<c<d)
     * 假设果最大sum组合不是 （a,b) (c,d),  最大值为 a+c
     * 那么必有 (a,c)或(a,d), 则另外一对组合必是 (b,*), 此时最大值为 a+b < a+c
     * 得证
     */

    public int arrayPairSum(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        List<Integer> numList = new ArrayList<>();
        for (int num : nums) {
            numList.add(num);
        }
        // Need to use quick sort, otherwise will lead to time limitation
        Collections.sort(numList);
        int sum = 0;
        for (int i = 0; i < numList.size(); i += 2) {
            sum += numList.get(i);
        }
        return sum;
    }
}
