package fun.sure.leetcode.easy;

/**
 * Created by wangshuo on 2016/6/19.
 */
public class ExcelSheetColumnTitle {

    /**
     * Given a positive integer, return its corresponding column title as appear in an Excel sheet.

     For example:

     1 -> A
     2 -> B
     3 -> C
     ...
     26 -> Z
     27 -> AA
     28 -> AB
     */

    // [PASS]
    public String convertToTitle(int n) {
        return printTitle(n).trim();
    }

    private String printTitle(int n) {
        if (n <= 0) {
            return "";
        }
        boolean zero = n % 26 == 0;
        String c = String.format("%c", zero ? 'Z' : 'A' - 1 + n % 26);
        n /= 26;
        return printTitle(zero ? n - 1 : n) + c;
    }

    public static void main(String[] args) {
        System.out.print(new ExcelSheetColumnTitle().convertToTitle(52));
    }
}
