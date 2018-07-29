package fun.sure.leetcode.easy;

/**
 * Created by sure on 2018/7/29.
 */

public class RotatedDigits {

    /**
     * X is a good number if after rotating each digit individually by 180 degrees, we get a valid number that is different from X.  Each digit must be rotated - we cannot choose to leave it alone.

     A number is valid if each digit remains a digit after rotation.
     0, 1, and 8 rotate to themselves;
     2 and 5 rotate to each other;
     6 and 9 rotate to each other,
     and the rest of the numbers do not rotate to any other number and become invalid.

     Now given a positive number N, how many numbers X from 1 to N are good?

     Example:
     Input: 10
     Output: 4
     Explanation:
     There are four good numbers in the range [1, 10] : 2, 5, 6, 9.
     Note that 1 and 10 are not good numbers, since they remain unchanged after rotating.
     Note:

     N  will be in range [1, 10000].
     */

    // [ACCEPTED]
    public int rotatedDigits(int N) {
        int count = 0;
        for (int i = 1; i <= N; i++) {
            if(isGoodNumber(i)) {
                count++;
            }
        }
        return count;
    }

    private boolean isGoodNumber(int N) {
        int rotatedN = rotateNumber(N);
        return rotatedN != -1 && rotatedN != N;
    }

    private int rotateNumber(int N) {
        int ret = 0;
        int bit = 0;
        int digit;
        int num;
        while ((num = (int) (N / Math.pow(10, bit))) > 0) {
            digit = num % 10;
            if (digit == 0 || digit == 1 || digit == 8) {
                ret += digit * Math.pow(10, bit);
            } else if (digit == 2 || digit == 5) {
                ret += (7 ^ digit) * Math.pow(10, bit);
            } else if (digit == 6 || digit == 9) {
                ret += (15 ^ digit) * Math.pow(10, bit);
            } else {
                return -1;
            }
            bit++;
        }
        return ret;
    }
}
