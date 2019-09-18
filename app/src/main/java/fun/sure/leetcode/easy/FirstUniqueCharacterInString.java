package fun.sure.leetcode.easy;

import java.util.HashMap;
import java.util.Map;

public class FirstUniqueCharacterInString {

    /**
     * Given a string, find the first non-repeating character in it and return it's index. If it doesn't exist, return -1.
     *
     * Examples:
     *
     * s = "leetcode"
     * return 0.
     *
     * s = "loveleetcode",
     * return 2.
     * Note: You may assume the string contain only lowercase letters.
     */

    // [AC]
    public int firstUniqChar(String s) {
        Map<Character, Integer> map = new HashMap();
        char c;
        for (int i = 0; i < s.length(); i++) {
            c = s.charAt(i);
            if (!map.containsKey(c)) {
                map.put(c, 0);
            }
            map.put(c, map.get(c) + 1);
        }
        for (int i = 0; i < s.length(); i++) {
            if (map.get(s.charAt(i)) == 1) {
                return i;
            }
        }
        return -1;
    }
}
