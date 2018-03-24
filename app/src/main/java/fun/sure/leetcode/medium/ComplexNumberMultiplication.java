package fun.sure.leetcode.medium;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by sure on 2018/3/24.
 */

public class ComplexNumberMultiplication {

    /**
     * Given two strings representing two complex numbers.

     You need to return a string representing their multiplication. Note i2 = -1 according to the definition.

     Example 1:
     Input: "1+1i", "1+1i"
     Output: "0+2i"
     Explanation: (1 + i) * (1 + i) = 1 + i2 + 2 * i = 2i, and you need convert it to the form of 0+2i.
     Example 2:
     Input: "1+-1i", "1+-1i"
     Output: "0+-2i"
     Explanation: (1 - i) * (1 - i) = 1 + i2 - 2 * i = -2i, and you need convert it to the form of 0+-2i.
     Note:

     The input strings will not have extra blank.
     The input strings will be given in the form of a+bi, where the integer a and b will both belong to
     the range of [-100, 100]. And the output should be also in this form.
     */

    // [PASS]

    private Pattern PATTERN_COMPLEX = Pattern.compile("(-?\\d+)\\+(-?\\d+)i");

    public String complexNumberMultiply(String a, String b) {
        int[] realAB = new int[2];
        int[] complexAB = new int[2];
        for (int i = 0; i < 2; i++) {
            String target = (i == 0) ? a : b;
            Matcher matcher = PATTERN_COMPLEX.matcher(target);
            if (matcher.find()) {
                realAB[i] = Integer.valueOf(matcher.group(1));
                complexAB[i] = Integer.valueOf(matcher.group(2));
            }
        }
        int real = realAB[0] * realAB[1] - complexAB[0] * complexAB[1];
        int complex = realAB[0] * complexAB[1] + complexAB[0] * realAB[1];
        return String.format("%d+%di", real, complex);
    }

    public static void main(String[] args) {
        String a = "1+-1i";
        String b = "1+-1i";
        String result = new ComplexNumberMultiplication().complexNumberMultiply(a, b);
        System.out.print(result);
    }
}
