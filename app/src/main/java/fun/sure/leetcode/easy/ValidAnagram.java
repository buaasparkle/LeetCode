package fun.sure.leetcode.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by wangshuo on 2016/6/7.
 */
public class ValidAnagram {

    /**
     * Given two strings s and t, write a function to determine if t is an anagram of s.
     * For example,
     * s = "anagram", t = "nagaram", return true.
     * s = "rat", t = "car", return false.
     * Note:
     * You may assume the string contains only lowercase alphabets.
     */

    // [PASS]
    public boolean isAnagram(String s, String t) {
        if (s == null || t == null || s.length() != t.length()) {
            return false;
        }
        Map<Character, Integer> maps = getCharCountMap(s);
        Map<Character, Integer> mapt = getCharCountMap(t);
        return maps.equals(mapt);
    }

    private Map<Character, Integer> getCharCountMap(String s) {
        Map<Character, Integer> map = new HashMap<>();
        if (s != null) {
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                map.put(c, map.containsKey(c) ? map.get(c) + 1 : 1);
            }
        }
        return map;
    }


}
