package fun.sure.leetcode.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by sure on 2018/8/4.
 */

public class RansomNote {

    /**
     * Given an arbitrary ransom note string and another string containing letters from all the magazines, write a function that will return true if the ransom note can be constructed from the magazines ; otherwise, it will return false.

     Each letter in the magazine string can only be used once in your ransom note.

     Note:
     You may assume that both strings contain only lowercase letters.

     canConstruct("a", "b") -> false
     canConstruct("aa", "ab") -> false
     canConstruct("aa", "aab") -> true
     */

    // [ACCEPTED]
    public boolean canConstruct(String ransomNote, String magazine) {
        Map<Character, Integer> magazineMap = new HashMap<>();
        char c;
        if (magazine != null && magazine.length() > 0) {
            for (int i = 0; i < magazine.length(); i++) {
                c = magazine.charAt(i);
                if (magazineMap.containsKey(c)) {
                    magazineMap.put(c, magazineMap.get(c) + 1);
                } else {
                    magazineMap.put(c, 1);
                }
            }
        }
        if (ransomNote == null) {
            return false;
        }
        int count;
        for (int i = 0; i < ransomNote.length(); i++) {
            c = ransomNote.charAt(i);
            if (!magazineMap.containsKey(c)) {
                return false;
            }
            count = magazineMap.get(c);
            if (count == 0) {
                return false;
            }
            count--;
            magazineMap.put(c, count);
        }
        return true;
    }
}
