package fun.sure.leetcode.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by wangshuo on 2016/6/19.
 */
public class _CountPrimes {

    /**
     * Count the number of prime numbers less than a non-negative number, n.
     */

    // [TLE, 999983]
    public int countPrimes(int n) {
        if (n <= 1) {
            return 0;
        }
        Map<Integer, Boolean> map = new HashMap<>();
        int count = 0;
        for (int i = 2; i < n; i++) {
            if (map.containsKey(i)) {
                continue;
            } else {
                count++;
                for (int j = 1; j <= n / i; j++) {
                    map.put(i * j, true);
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.print(new _CountPrimes().countPrimes(12));
    }
}
