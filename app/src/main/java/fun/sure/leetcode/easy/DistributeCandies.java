package fun.sure.leetcode.easy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by sure on 2017/9/9.
 */

public class DistributeCandies {

    /**
     * Given an integer array with even length, where different numbers in this array represent different kinds of candies.
     * Each number means one candy of the corresponding kind. You need to distribute these candies equally in number to brother and sister.
     * Return the maximum number of kinds of candies the sister could gain.

     Example 1:
     Input: candies = [1,1,2,2,3,3]
     Output: 3

     Explanation:
     There are three different kinds of candies (1, 2 and 3), and two candies for each kind.
     Optimal distribution: The sister has candies [1,2,3] and the brother has candies [1,2,3], too.
     The sister has three different kinds of candies.

     Example 2:
     Input: candies = [1,1,2,3]
     Output: 2

     Explanation: For example, the sister has candies [2,3] and the brother has candies [1,1].
     The sister has two different kinds of candies, the brother has only one kind of candies.
     Note:

     The length of the given array is in range [2, 10,000], and will be even.
     The number in given array is in range [-100,000, 100,000].
     */

    /**
     * 思路：
     * 贪心法：先按 个数 排个序，从 小到大，然后逐一取知道一半
     */

    // [ACCEPTED]
    public int distributeCandies(int[] candies) {
        if (candies == null || candies.length == 0) {
            return 0;
        }
        int kind = 0;
        Map<Integer, Integer> map = new HashMap<>(); // <kind, count>
        for (int candy : candies) {
            if (map.containsKey(candy)) {
                map.put(candy, map.get(candy) + 1);
            } else {
                map.put(candy, 1);
            }
        }
        List<Integer> countList = new ArrayList<>(map.values());
        Collections.sort(countList);
        int sum = 0;
        int count;
        while (sum < candies.length / 2) {
            for (int i = 0; i < countList.size(); i++) {
                count = countList.get(i);
                if (count == 0) {
                    continue;
                }
                sum++;
                if (kind < countList.size()) {
                    kind++;
                }
                countList.set(i, count - 1);
                if (sum == candies.length / 2) {
                    break;
                }
            }
        }
        return kind;
    }
}
