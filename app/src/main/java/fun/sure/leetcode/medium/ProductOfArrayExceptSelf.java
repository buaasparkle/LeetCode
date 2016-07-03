package fun.sure.leetcode.medium;

/**
 * Created by wangshuo on 2016/6/22.
 */
public class ProductOfArrayExceptSelf {

    /**
     * Given an array of n integers where n > 1, nums, return an array output such that output[i] is
     * equal to the product of all the elements of nums except nums[i].

     Solve it without division and in O(n).

     For example, given [1,2,3,4], return [24,12,8,6].
     */

    // [PASS] with division but passed?
    public int[] productExceptSelf(int[] nums) {
        int len = nums.length;
        int sum = 1;
        int zeroCount = 0;
        for (int i = 0; i < len; i++) {
            if (nums[i] == 0) {
                zeroCount++;
            } else {
                sum *= nums[i];
            }
        }
        int[] result = new int[len];
        for (int i = 0; i < len; i++) {
            if (zeroCount == 0) {
                result[i] = sum / nums[i];
            } else if (zeroCount == 1) {
                result[i] = nums[i] == 0 ? sum : 0;
            } else {
                result[i] = 0;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = new int[] {
                0, 0
        };
        int[] result = new ProductOfArrayExceptSelf().productExceptSelf(nums);
        for (int i : result) {
            System.out.print(i + " ");
        }
    }
}
