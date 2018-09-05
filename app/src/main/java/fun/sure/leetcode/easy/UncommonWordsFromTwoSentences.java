package fun.sure.leetcode.easy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by sure on 2018/9/6.
 */

public class UncommonWordsFromTwoSentences {

    /**
     * We are given two sentences A and B.  (A sentence is a string of space separated words.  Each word consists only of lowercase letters.)

     A word is uncommon if it appears exactly once in one of the sentences, and does not appear in the other sentence.

     Return a list of all uncommon words.

     You may return the list in any order.



     Example 1:

     Input: A = "this apple is sweet", B = "this apple is sour"
     Output: ["sweet","sour"]
     Example 2:

     Input: A = "apple apple", B = "banana"
     Output: ["banana"]

     Note:

     0 <= A.length <= 200
     0 <= B.length <= 200
     A and B both contain only spaces and lowercase letters.
     */

    // [AC]
    public String[] uncommonFromSentences(String A, String B) {
        Map<String, Integer> mapA = parseSentence(A);
        Map<String, Integer> mapB = parseSentence(B);
        List<String> list = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : mapA.entrySet()) {
            if (entry.getValue() == 1 && !mapB.containsKey(entry.getKey())) {
                list.add(entry.getKey());
            }
        }
        for (Map.Entry<String, Integer> entry : mapB.entrySet()) {
            if (entry.getValue() == 1 && !mapA.containsKey(entry.getKey())) {
                list.add(entry.getKey());
            }
        }
        return list.toArray(new String[0]);
    }

    private Map<String, Integer> parseSentence(String A) {
        Map<String, Integer> map = new HashMap<>();
        String[] words = A.split("\\s+");
        for (String word : words) {
            if (!map.containsKey(word)) {
                map.put(word, 0);
            }
            map.put(word, map.get(word) + 1);
        }
        return map;
    }
}
