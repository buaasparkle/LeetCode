package fun.sure.leetcode.easy;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by wangshuo on 2016/6/12.
 */
public class HappyNumber {

    /**
     Write an algorithm to determine if a number is "happy".

     A happy number is a number defined by the following process: Starting with any positive integer,
     replace the number by the sum of the squares of its digits, and repeat the process until the number
     equals 1 (where it will stay), or it loops endlessly in a cycle which does not include 1. Those
     numbers for which this process ends in 1 are happy numbers.

     Example: 19 is a happy number

     1^2 + 9^2 = 82
     8^2 + 2^2 = 68
     6^2 + 8^2 = 100
     1^2 + 0^2 + 0^2 = 1
     */

    // [PASS]
    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();
        while (n > 0) {
            n = sumSquare(n);
            if (n == 1) {
                return true;
            }
            if (set.contains(n)) {
                break;
            } else {
                set.add(n);
            }
        }
        return false;
    }

    private int sumSquare(int n) {
        int sum = 0;
        int m;
        while (n > 0) {
            m = n % 10;
            sum += m * m;
            n /= 10;
        }
        return sum;
    }
}
