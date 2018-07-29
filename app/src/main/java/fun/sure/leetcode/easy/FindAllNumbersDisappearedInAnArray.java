package fun.sure.leetcode.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by sure on 2018/7/29.
 */

public class FindAllNumbersDisappearedInAnArray {

    /**
     * Given an array of integers where 1 ≤ a[i] ≤ n (n = size of array), some elements appear twice and others appear once.

     Find all the elements of [1, n] inclusive that do not appear in this array.

     Could you do it without extra space and in O(n) runtime? You may assume the returned list does not count as extra space.

     Example:

     Input:
     [4,3,2,7,8,2,3,1]

     Output:
     [5,6]
     */

    // 看看别人的思路：想保留值能取到，但是又要加标记，"负号"是个不错的思路

    /**
     * The basic idea is that we iterate through the input array and mark elements as negative
     * using nums[nums[i] -1] = -nums[nums[i]-1].
     * In this way all the numbers that we have seen will be marked as negative.
     * In the second iteration, if a value is not marked as negative,
     * it implies we have never seen that index before, so just add it to the return list.

     */

    public List<Integer> findDisappearedNumbersBetter(int[] nums) {
        List<Integer> ret = new ArrayList<>();

        for(int i = 0; i < nums.length; i++) {
            int val = Math.abs(nums[i]) - 1;
            if(nums[val] > 0) {
                nums[val] = -nums[val];
            }
        }

        for(int i = 0; i < nums.length; i++) {
            if(nums[i] > 0) {
                ret.add(i+1);
            }
        }
        return ret;
    }

    // [ACCEPTED]
    // 但是这个不是 O(n) 的时间复杂度
    public List<Integer> findDisappearedNumbers(int[] nums) {
        // sort
        int n;
        int tmp;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == i + 1) {
                continue;
            }
            while (nums[i] != i + 1) {
                if (nums[i] == nums[nums[i] - 1]) {
                    break;
                }
                tmp = nums[i];
                n = nums[i] - 1;
                nums[i] = nums[n];
                nums[n] = tmp;
            }
        }
        // compare
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1) {
                result.add(i + 1);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {4, 3, 2, 7, 8, 2, 3, 1};
        List<Integer> result = new FindAllNumbersDisappearedInAnArray().findDisappearedNumbersBetter(nums);
        System.out.println(Arrays.toString(result.toArray(new Integer[0])));
    }
}
