package fun.sure.leetcode.easy;

public class AddStrings {

    /**
     * Given two non-negative integers num1 and num2 represented as string, return the sum of num1 and num2.
     *
     * Note:
     *
     * The length of both num1 and num2 is < 5100.
     * Both num1 and num2 contains only digits 0-9.
     * Both num1 and num2 does not contain any leading zero.
     * You must not use any built-in BigInteger library or convert the inputs to integer directly.
     */

    public String addStrings(String num1, String num2) {
        int len1 = num1.length();
        int len2 = num2.length();
        String ns = new StringBuilder(len1 < len2 ? num1 : num2).reverse().toString();
        String nl = new StringBuilder(len1 >= len2 ? num1 : num2).reverse().toString();
        int lens = Math.min(len1, len2);
        int lenl = Math.max(len1, len2);
        int carry = 0;
        int val;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < lenl; i++) {
            if (i < lens) {
                val = ns.charAt(i) - '0' + nl.charAt(i) - '0' + carry;
            } else {
                val = nl.charAt(i) - '0' + carry;
            }
            sb.append(val % 10);
            carry = val / 10;
        }
        if (carry > 0) {
            sb.append(carry);
        }
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(new AddStrings().addStrings("999", "1"));
    }
}
