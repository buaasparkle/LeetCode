package fun.sure.leetcode.easy;

/**
 * Created by wangshuo on 2016/6/13.
 */
public class FactorialTrailingZeroes {

    /**
     * Given an integer n, return the number of trailing zeroes in n!.
     * Note: Your solution should be in logarithmic time complexity.
     */

    // 末尾有几个零，就可能凑出来多少个10(2 x 5)，由于是n!，所以2的数量肯定多过5，就看有多少个5
    // [PASS] 踩坑点：exp5开始声明为int，但是会越界，改成long后通过
    public int trailingZeroes(int n) {
        int count = 0;
        long exp5 = 5;
        while (n / exp5 > 0) {
            count += n / exp5;
            exp5 *= 5;
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.print(new FactorialTrailingZeroes().trailingZeroes(1808548329));
    }
}
