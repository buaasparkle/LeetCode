package fun.sure.leetcode.easy;

/**
 * Created by wangshuo on 2016/6/13.
 */
public class PowerOfFour {

    /**
     * Given an integer (signed 32 bits), write a function to check whether it is a power of 4.
     * Example: Given num = 16, return true. Given num = 5, return false.
     */

    // [PASS]
    public boolean isPowerOfFour(int num) {
        if (num <= 0) {
            return false;
        }
        while (num > 0) {
            if (num == 1) {
                break;
            }
            if (num % 4 != 0) {
                return false;
            }
            num /= 4;
        }
        return true;
    }
}
