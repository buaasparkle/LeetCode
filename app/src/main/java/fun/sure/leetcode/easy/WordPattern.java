package fun.sure.leetcode.easy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by wangshuo on 2016/6/13.
 */
public class WordPattern {

    /**
     * Given a pattern and a string str, find if str follows the same pattern.

     Here follow means a full match, such that there is a bijection between a letter in pattern and a non-empty word in str.

     Examples:
     pattern = "abba", str = "dog cat cat dog" should return true.
     pattern = "abba", str = "dog cat cat fish" should return false.
     pattern = "aaaa", str = "dog cat cat dog" should return false.
     pattern = "abba", str = "dog dog dog dog" should return false.
     Notes:
     You may assume pattern contains only lowercase letters, and str contains lowercase letters separated by a single space.

     */

    // [PASS]
    public boolean wordPattern(String pattern, String str) {
        if (pattern == null || str == null) {
            return false;
        }
        String[] strs = str.split(" ");
        if (pattern.length() != strs.length) {
            return false;
        }
        List<Character> list = new ArrayList<>();
        for (int i = 0; i < pattern.length(); i++) {
            list.add(pattern.charAt(i));
        }
        Map<Character, Set<Integer>> mapPattern = getMap(list.toArray(new Character[0]));
        Map<String, Set<Integer>> mapStr = getMap(strs);
        for (int i = 0; i < pattern.length(); i++) {
            char cPattern = pattern.charAt(i);
            String s = strs[i];
            if (!mapPattern.get(cPattern).equals(mapStr.get(s))) {
                return false;
            }
        }
        return true;
    }

    private <T> Map<T, Set<Integer>> getMap(T[] list) {
        Map<T, Set<Integer>> map = new HashMap<>();
        for (int i = 0; i < list.length; i++) {
            T t = list[i];
            if (!map.containsKey(t)) {
                Set<Integer> set = new HashSet<>();
                map.put(t, set);
            }
            map.get(t).add(i);
        }
        return map;
    }

}
