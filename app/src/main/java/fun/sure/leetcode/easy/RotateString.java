package fun.sure.leetcode.easy;

/**
 * Created by sure on 2018/3/22.
 */

public class RotateString {

    /**
     * We are given two strings, A and B.

     A shift on A consists of taking string A and moving the leftmost character to the rightmost position. For example, if A = 'abcde', then it will be 'bcdea' after one shift on A. Return True if and only if A can become B after some number of shifts on A.

     Example 1:
     Input: A = 'abcde', B = 'cdeab'
     Output: true

     Example 2:
     Input: A = 'abcde', B = 'abced'
     Output: false
     Note:

     A and B will have length at most 100.
     */

    // [PASS]
    public boolean rotateString(String A, String B) {
        if (A == null && B == null) {
            return true;
        } else if (A == null || B == null) {
            return false;
        }
        if (A.length() == 0 && B.length() == 0) {
            return true;
        }
        if (A.length() != B.length()) {
            return false;
        }
        char firstCharInB = B.charAt(0);
        char charInA;
        for (int i = 0; i < A.length(); i++) {
            charInA = A.charAt(i);
            if (charInA == firstCharInB) {
                String rotatedA = String.format("%s%s", A.substring(i), A.substring(0, i));
                if (B.equals(rotatedA)) {
                    return true;
                }
            }
        }
        return false;
    }
}
