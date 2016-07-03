package fun.sure.leetcode.easy;

/**
 * Created by wangshuo on 2016/6/7.
 */
public class ExcelSheetColumnNumber {

    /**
     * Related to question Excel Sheet Column Title

     Given a column title as appear in an Excel sheet, return its corresponding column number.

     For example:

     A -> 1
     B -> 2
     C -> 3
     ...
     Z -> 26
     AA -> 27
     AB -> 28
     */

    // 感觉就是个26进制
    // [PASS]
    public int titleToNumber(String s) {
        int number = 0;
        int exp = 1;
        s = s.toUpperCase();
        for (int i = s.length() - 1; i >= 0; i--) {
            int c = s.charAt(i) - 'A' + 1;
            number += c * exp;
            exp *= 26;
        }
        return number;
    }
}
