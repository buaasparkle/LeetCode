package fun.sure.leetcode.easy;

/**
 * Created by wangshuo on 2016/6/7.
 */
public class AddDigits {

    /**
     *Given a non-negative integer num, repeatedly add all its digits until the result has only one digit.
     * For example:
     * Given num = 38, the process is like: 3 + 8 = 11, 1 + 1 = 2. Since 2 has only one digit, return it.
     */

    // [PASS]
    public int addDigits(int num) {
        int result = addDigitOnce(num);
        while (!hasOnlyOneDigit(result)) {
            result = addDigitOnce(result);
        }
        return result;
    }

    private boolean hasOnlyOneDigit(int num) {
        return num >= 0 && num <= 9;
    }

    private int addDigitOnce(int num) {
        int count = 0;
        while(num > 0) {
            count += num % 10;
            num /= 10;
        }
        return count;
    }

}
