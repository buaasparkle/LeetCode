package fun.sure.leetcode.easy;

/**
 * Created by wangshuo on 2016/6/12.
 */
public class PowerOfTwo {

    /**
     *Given an integer, write a function to determine if it is a power of two.
     */

    // [PASS]
    public boolean isPowerOfTwo(int n) {
        if (n > 0) {
            return (n & (n - 1)) == 0;
        }
        return false;
    }
}
