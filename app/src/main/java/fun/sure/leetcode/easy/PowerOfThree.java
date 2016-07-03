package fun.sure.leetcode.easy;

/**
 * Created by wangshuo on 2016/6/12.
 */
public class PowerOfThree {

    /**
     * Given an integer, write a function to determine if it is a power of three.
     */

    // [PASS]
    public boolean isPowerOfThree(int n) {
        if (n <= 0) {
            return false;
        }
        while (n > 0) {
            if (n == 1) {
                break;
            }
            if (n % 3 != 0) {
                return false;
            }
            n /= 3;
        }
        return true;
    }
}
