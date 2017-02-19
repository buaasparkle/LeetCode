package fun.sure.leetcode.easy;

/**
 * Created by sure on 2017/2/18.
 */

public class NumberComplement {

    /**
     * Given a positive integer, output its complement number. The complement strategy is to flip the bits of its binary representation.

     Note:
     The given integer is guaranteed to fit within the range of a 32-bit signed integer.
     You could assume no leading zero bit in the integer’s binary representation.
     Example 1:
     Input: 5
     Output: 2
     Explanation: The binary representation of 5 is 101 (no leading zero bits), and its complement is 010. So you need to output 2.
     Example 2:
     Input: 1
     Output: 0
     Explanation: The binary representation of 1 is 1 (no leading zero bits), and its complement is 0. So you need to output 0.
     */

    // 先找到num的bit位数，并计算得到该位数最大的值（即全1的值）fullOne，然后num与fullOne异或的结果即为所得
    public int findComplement(int num) {
        int bits = getNumBits(num);
        int fullOne = (int) (Math.pow(2, bits) - 1);
        return num ^ fullOne;
    }

    private int getNumBits(int num) {
        int bits = 0;
        do {
            bits++;
            num >>= 1;
        } while (num > 0);
        return bits;
    }

    public static void main(String[] args) {
        System.out.println(new NumberComplement().findComplement(8));
    }
}
