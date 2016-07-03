package fun.sure.leetcode.medium;

/**
 * Created by wangshuo on 2016/6/23.
 */
public class SingleNumberIII {

    /**
     * Given an array of numbers nums, in which exactly two elements appear only once and all the
     * other elements appear exactly twice. Find the two elements that appear only once.

     For example:

     Given nums = [1, 2, 1, 3, 2, 5], return [3, 5].

     Note:
     The order of the result is not important. So in the above example, [5, 3] is also correct.
     Your algorithm should run in linear runtime complexity. Could you implement it using only constant space complexity?
     */

    public int[] singleNumber(int[] nums) {
        if (nums == null || nums.length < 2) {
            return null;
        }
        // 假定两个不同的数字为a和b，全异或一遍后得到的是a^b的结果
        int xorResult = 0;
        for (int num : nums) {
            xorResult ^= num;
        }
        int singleOne = xorResult;
        while ((singleOne & (singleOne - 1)) != 0) {
            singleOne &= (singleOne - 1);
        }
        int a = 0; // a表示异或结果中对应bit含中有1的那个
        for (int num : nums) { // 挑出与a一样与singleOne中1的bit相同的数，由于其他的都有两个，xor后就只剩a了
            if ((num & singleOne) == singleOne) {
                a ^= num;
            }
        }
        int b = a ^ xorResult;
        return new int[] {a, b};
    }

    public static void main(String[] args) {
        int[] nums = new int[] {
                1,2,1,3,2,5
        };
        int[] result = new SingleNumberIII().singleNumber(nums);
        for (int i : result) {
            System.out.print(i);
        }
    }
}
