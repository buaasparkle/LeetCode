package fun.sure.leetcode.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sure on 2018/3/22.
 */

public class SelfDividingNumbers {

    /**
     * A self-dividing number is a number that is divisible by every digit it contains.

     For example, 128 is a self-dividing number because 128 % 1 == 0, 128 % 2 == 0, and 128 % 8 == 0.

     Also, a self-dividing number is not allowed to contain the digit zero.

     Given a lower and upper number bound, output a list of every possible self dividing number, including the bounds if possible.

     Example 1:
     Input:
     left = 1, right = 22
     Output: [1, 2, 3, 4, 5, 6, 7, 8, 9, 11, 12, 15, 22]
     Note:

     The boundaries of each input argument are 1 <= left <= right <= 10000.
     */

    // [PASS]
    public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> list = new ArrayList<>();
        for (int i = left; i <= right; i++) {
            if (isSelfDividingNumber(i)) {
                list.add(i);
            }
        }
        return list;
    }

    private boolean isSelfDividingNumber(int num) {
        if (num == 0) {
            return false;
        }
        int tmp = Math.abs(num);
        int digit;
        while (tmp > 0) {
            digit = tmp % 10;
            if (digit == 0 || num % digit != 0) {
                return false;
            }
            tmp /= 10;
        }
        return true;
    }
}
