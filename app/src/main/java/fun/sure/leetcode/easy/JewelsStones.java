package fun.sure.leetcode.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by sure on 2018/3/22.
 */

public class JewelsStones {

    /**
     * You're given strings J representing the types of stones that are jewels, and S representing the stones you have.  Each character in S is a type of stone you have.  You want to know how many of the stones you have are also jewels.

     The letters in J are guaranteed distinct, and all characters in J and S are letters. Letters are case sensitive, so "a" is considered a different type of stone from "A".

     Example 1:

     Input: J = "aA", S = "aAAbbbb"
     Output: 3
     Example 2:

     Input: J = "z", S = "ZZ"
     Output: 0
     Note:

     S and J will consist of letters and have length at most 50.
     The characters in J are distinct.
     */

    // [PASS]
    public int numJewelsInStones(String J, String S) {
        if (J == null || J.length() == 0 || S == null || S.length() == 0) {
            return 0;
        }
        Map<Character, Boolean> JMap = new HashMap<>();
        for (int i = 0; i < J.length(); i++) {
            JMap.put(J.charAt(i), true);
        }
        int num = 0;
        Boolean hit;
        for (int i = 0; i < S.length(); i++) {
            hit = JMap.get(S.charAt(i));
            if (hit != null && hit) {
                num++;
            }
        }
        return num;
    }
}
