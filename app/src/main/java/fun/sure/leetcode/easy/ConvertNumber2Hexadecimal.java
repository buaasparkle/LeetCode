package fun.sure.leetcode.easy;

public class ConvertNumber2Hexadecimal {

    /**
     * Given an integer, write an algorithm to convert it to hexadecimal. For negative integer, two’s complement method is used.
     *
     * Note:
     *
     * All letters in hexadecimal (a-f) must be in lowercase.
     * The hexadecimal string must not contain extra leading 0s. If the number is zero, it is represented by a single zero character '0'; otherwise, the first character in the hexadecimal string will not be the zero character.
     * The given number is guaranteed to fit within the range of a 32-bit signed integer.
     * You must not use any method provided by the library which converts/formats the number to hex directly.
     * Example 1:
     *
     * Input:
     * 26
     *
     * Output:
     * "1a"
     * Example 2:
     *
     * Input:
     * -1
     *
     * Output:
     * "ffffffff"
     */

    // [AC]
    public String toHex(int num) {
        int[] bits = new int[32];
        boolean positive = num >= 0;
        int n = num;
        if (!positive) {
            n = num * -1 - 1;
        }
        for (int i = 0; i < 31; i++) {
            int val = n & 0x1;
            bits[i] = positive ? val : 1 - val;
            n >>= 1;
        }
        bits[31] = positive ? 0 : 1;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 32; i += 4) {
            int val = 8 * bits[i + 3] + 4 * bits[i + 2] + 2 * bits[i + 1] + bits[i];
            char c = (char) (val >= 10 ? val - 10 + 'a' : '0' + val);
            sb.append(c);
        }
        for (int i = 7; i > 0 ; i--) {
            if (sb.charAt(i) != '0') {
                break;
            } else {
                sb.deleteCharAt(i);
            }
        }
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(new ConvertNumber2Hexadecimal().toHex(-2));
    }
}
