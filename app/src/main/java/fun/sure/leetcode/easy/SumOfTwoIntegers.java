package fun.sure.leetcode.easy;

/**
 * Created by sure on 2018/7/29.
 */

public class SumOfTwoIntegers {

    /**
     * Calculate the sum of two integers a and b, but you are not allowed to use the operator + and -.

     Example:
     Given a = 1 and b = 2, return 3.
     */

    // [ACCEPTED]
    public int getSum(int a, int b) {
        int carry = (a & b) << 1; // 进位
        a = a ^ b;
        b = carry;
        while (carry != 0) {
            carry = (a & b) << 1;
            a = a ^ b;
            b = carry;
        }
        return a;
    }

    public static void main(String[] args) {
        int a = 1;
        int b = 2;
        System.out.println(new SumOfTwoIntegers().getSum(a, b));
    }
}
