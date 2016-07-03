package fun.sure.leetcode.easy;

/**
 * Created by wangshuo on 2016/6/19.
 */
public class ReverseBits {

    /**
     * Reverse bits of a given 32 bits unsigned integer.

     For example, given input 43261596 (represented in binary as 00000010100101000001111010011100),
     return 964176192 (represented in binary as 00111001011110000010100101000000).

     Follow up:
     If this function is called many times, how would you optimize it?
     */

    // you need treat n as an unsigned value
    // [PASS] 符号位要先处理掉，>>操作是不移动符号位的，所以要先把n去掉符号位，即按整数来处理
    public int reverseBits(int n) {
        int[] bits = new int[32];
        int sign = n >= 0 ? 0 : 1;
        n &= 0x7fffffff;
        for (int i = 0; i < 31; i++) {
            bits[i] = n % 2;
            n >>= 1;
        }
        bits[31] = sign;
        int result = 0;
        for (int i = 0; i < 32; i++) {
            result += bits[i];
            if (i != 31) {
                result <<= 1;
            }
        }
        if (bits[0] == 1) {
            result |= 0x80000000;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.print(new ReverseBits().reverseBits(0xffffffff));
    }
}
