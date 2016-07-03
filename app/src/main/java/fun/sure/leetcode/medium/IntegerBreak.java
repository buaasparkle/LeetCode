package fun.sure.leetcode.medium;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by wangshuo on 2016/6/26.
 */
public class IntegerBreak {

    /**
     * Given a positive integer n, break it into the sum of at least two positive integers and
     * maximize the product of those integers. Return the maximum product you can get.

     For example, given n = 2, return 1 (2 = 1 + 1); given n = 10, return 36 (10 = 3 + 3 + 4).

     Note: you may assume that n is not less than 2.
     */

    // [PASS]
    private Map<Integer, Integer> map = new HashMap<>();

    public int integerBreak(int n) {
        if (map.containsKey(n)) {
            return map.get(n);
        }
        int max = 0;
        if (n == 2) {
            max = 1;
        } else if (n == 3) {
            max = 2;
        } else {
            int result;
            for (int i = 2; i <= n / 2; i++) {
                result = Math.max(i, integerBreak(i)) * Math.max(n - i, integerBreak(n - i));
                if (result > max) {
                    max = result;
                }
            }
        }
        map.put(n, max);
        return max;
    }

    public static void main(String[] args) {
        System.out.print(new IntegerBreak().integerBreak(8));
    }
}
