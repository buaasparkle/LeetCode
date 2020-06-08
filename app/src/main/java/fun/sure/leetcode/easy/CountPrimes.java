package fun.sure.leetcode.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by wangshuo on 2016/6/19.
 */
public class CountPrimes {

    /**
     * Count the number of prime numbers less than a non-negative number, n.
     */

    // [TLE, 999983]
    public int countPrimes(int n) {
        if (n <= 2) {
            return 0;
        }
        long startTime = System.currentTimeMillis();
        Map<Integer, Boolean> map = new HashMap<>();
        int count = 0;
        for (int i = 2; i < n; i++) {
            if (map.containsKey(i)) { // 这步费啊
                continue;
            } else {
                count++;
                for (int j = 1; j <= n / i; j++) {
                    map.put(i * j, true);
                }
            }
        }
        System.out.println(System.currentTimeMillis() - startTime);
        return count;
    }

    /**
     * [PASS]
     *
     * Runtime: 483 ms, faster than 14.31% of Java online submissions for Count Primes.
     * Memory Usage: 45.1 MB, less than 5.01% of Java online submissions for Count Primes.
     */
    public int countPrimes1(int n) {
        if (n <= 2) { return 0; }
        long startTime = System.currentTimeMillis();
        List<Integer> primeCache = new ArrayList<>();
        primeCache.add(2);
        for (int i = 3; i < n; i += 2) {
            if (checkPrimeWithCachedPrimeList(i, primeCache)) {
                primeCache.add(i);
            }
        }
//        System.out.println(Arrays.toString(primeCache.toArray(new Integer[0])));
        System.out.println(System.currentTimeMillis() - startTime);
        return primeCache.size();
    }

    // cache 默认是由小到大排序
    private boolean checkPrimeWithCachedPrimeList(int n, List<Integer> cache) {
        if (n <= 1) {
            return false;
        }
        int startPoint = 2;
        // check cached first
        if (cache != null && !cache.isEmpty()) {
            int prime;
            for (int i = 0; i < cache.size(); i++) {
                prime = cache.get(i);
                if (n % prime == 0) {
                    return false;
                }
                if (prime * prime > n) {
                    break;
                }
            }
            startPoint = cache.get(cache.size() - 1) + 1;
        }
        // 如果是大于 2 的偶数，跳到下一个奇数
        startPoint = startPoint > 2 && startPoint % 2 == 0 ? startPoint + 1 : startPoint;

        int sqrtN = (int) Math.sqrt(n);
        for (int i = startPoint; i <= sqrtN; i += 2) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    /**
     * 讨论区中给出的答案，这个速度更快
     * https://leetcode.com/problems/count-primes/discuss/673594/Java-implementation-of-sieve-of-Eratosthenes-O(nlog(n))
     */
    public int countPrimes2(int n) {
        if(n <= 2) {
            return 0;
        }
        long startTime = System.currentTimeMillis();
        int count = 1;
        boolean[] isNotPrime = new boolean[n+1];
        for (int i=3; i*i<=n; i+=2) {
            //Only consider odd numbers >= 3
            if (!isNotPrime[i]) {
                //values that have not been sieved
                for (int j=i*i; j<=n; j+=2*i) {
                    //sieve values, again only consider odd number
                    isNotPrime[j] = true;
                }
            }
        }
        for (int i=3; i<n; i+=2) {
            if (!isNotPrime[i]) {
                count++;
            }
        }
        System.out.println(System.currentTimeMillis() - startTime);
        return count;
    }

    public static void main(String[] args) {
        System.out.print(new CountPrimes().countPrimes(1500000));
    }
}
