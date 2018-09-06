package fun.sure.leetcode.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by sure on 2018/9/7.
 */

public class FindAndReplacePattern {

    /**
     * You have a list of words and a pattern, and you want to know which words in words matches the pattern.

     A word matches the pattern if there exists a permutation of letters p so that after replacing every letter x in the pattern with p(x), we get the desired word.

     (Recall that a permutation of letters is a bijection from letters to letters: every letter maps to another letter, and no two letters map to the same letter.)

     Return a list of the words in words that match the given pattern.

     You may return the answer in any order.



     Example 1:

     Input: words = ["abc","deq","mee","aqq","dkd","ccc"], pattern = "abb"
     Output: ["mee","aqq"]
     Explanation: "mee" matches the pattern because there is a permutation {a -> m, b -> e, ...}.
     "ccc" does not match the pattern because {a -> c, b -> c, ...} is not a permutation,
     since a and b map to the same letter.


     Note:

     1 <= words.length <= 50
     1 <= pattern.length = words[i].length <= 20
     */

    // [AC]
    public List<String> findAndReplacePattern(String[] words, String pattern) {
        List<String> list = new ArrayList<>();
        for (String word : words) {
            if (matchPattern(word, pattern)) {
                list.add(word);
            }
        }
        return list;
    }

    private boolean matchPattern(String word, String pattern) {
        if (word.length() != pattern.length()) {
            return false;
        }
        Map<Character, Character> map_w2p = new HashMap<>();
        Map<Character, Character> map_p2w = new HashMap<>();
        Character c_w;
        Character c_p;
        for (int i = 0; i < word.length(); i++) {
            c_w = word.charAt(i);
            c_p = pattern.charAt(i);
            if (!map_w2p.containsKey(c_w) && !map_p2w.containsKey(c_p)) {
                map_w2p.put(c_w, c_p);
                map_p2w.put(c_p, c_w);
                continue;
            }
            if (c_p != map_w2p.get(c_w) || c_w != map_p2w.get(c_p)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String[] words = {
                "abc", "deq"
        };
        String pattern = "abb";
        new FindAndReplacePattern().findAndReplacePattern(words, pattern);
    }
}
