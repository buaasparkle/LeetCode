package fun.sure.leetcode.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by sure on 2018/8/4.
 */

public class MostCommonWord {

    /**
     * Given a paragraph and a list of banned words, return the most frequent word that is not in the list of banned words.  It is guaranteed there is at least one word that isn't banned, and that the answer is unique.

     Words in the list of banned words are given in lowercase, and free of punctuation.  Words in the paragraph are not case sensitive.  The answer is in lowercase.

     Example:
     Input:
     paragraph = "Bob hit a ball, the hit BALL flew far after it was hit."
     banned = ["hit"]
     Output: "ball"
     Explanation:
     "hit" occurs 3 times, but it is a banned word.
     "ball" occurs twice (and no other word does), so it is the most frequent non-banned word in the paragraph.
     Note that words in the paragraph are not case sensitive,
     that punctuation is ignored (even if adjacent to words, such as "ball,"),
     and that "hit" isn't the answer even though it occurs more because it is banned.


     Note:

     1 <= paragraph.length <= 1000.
     1 <= banned.length <= 100.
     1 <= banned[i].length <= 10.
     The answer is unique, and written in lowercase (even if its occurrences in paragraph may have uppercase symbols, and even if it is a proper noun.)
     paragraph only consists of letters, spaces, or the punctuation symbols !?',;.
     Different words in paragraph are always separated by a space.
     There are no hyphens or hyphenated words.
     Words only consist of letters, never apostrophes or other punctuation symbols.
     */

    // [ACCEPTED]
    public String mostCommonWord(String paragraph, String[] banned) {
        String[] words = paragraph.split("[ !?',;.]");
        Map<String, Integer> wordCountMap = new HashMap<>();
        String word;
        String mostCommonWord = null;
        int maxCount = 0;
        for (int i = 0; i < words.length; i++) {
            word = words[i].toLowerCase();
            if (isBanned(banned, word) || word.isEmpty()) {
                continue;
            }
            int count = wordCountMap.containsKey(word) ? wordCountMap.get(word) + 1 : 0;
            wordCountMap.put(word, count);
            if (count > maxCount) {
                maxCount = count;
                mostCommonWord = word;
            }
        }
        return mostCommonWord;
    }

    private boolean isBanned(String[] banned, String word) {
        for (String ban : banned) {
            if (ban.equalsIgnoreCase(word)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        String paragraph = "Bob hit a ball, the hit BALL flew far after it was hit.";
        System.out.println(new MostCommonWord().mostCommonWord(paragraph, new String[]{"hit"}));
    }
}
