package fun.sure.leetcode.easy;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by wangshuo on 2016/6/13.
 */
public class IsomorphicStrings {

    /**
     * Given two strings s and t, determine if they are isomorphic.

     Two strings are isomorphic if the characters in s can be replaced to get t.

     All occurrences of a character must be replaced with another character while preserving the order of characters.
     No two characters may map to the same character but a character may map to itself.

     For example,
     Given "egg", "add", return true.

     Given "foo", "bar", return false.

     Given "paper", "title", return true.

     Note:
     You may assume both s and t have the same length.
     */

    // [PASS]
    public boolean isIsomorphic(String s, String t) {
        if (s == null || t == null) {
            return false;
        }
        Map<Character, Set<Integer>> sMap = getMap(s);
        Map<Character, Set<Integer>> tMap = getMap(t);
        Map<Character, Boolean> visitMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char cs = s.charAt(i);
            char ct = t.charAt(i);
            if (visitMap.containsKey(cs)) {
                continue;
            }
            if (!sMap.get(cs).equals(tMap.get(ct))) {
                return false;
            }
            visitMap.put(cs, Boolean.TRUE);
        }
        return true;
    }

    private Map<Character, Set<Integer>> getMap(String s) {
        Map<Character, Set<Integer>> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!map.containsKey(c)) {
                Set<Integer> set = new HashSet<>();
                map.put(c, set);
            }
            map.get(c).add(i);
        }
        return map;
    }
}
