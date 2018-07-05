package fun.sure.leetcode.easy;

import java.util.HashSet;

/**
 * Created by sure on 2018/7/6.
 */

public class UniqueMorseCodeWords {

    /**
     * International Morse Code defines a standard encoding where each letter is mapped to a series of dots and dashes, as follows: "a" maps to ".-", "b" maps to "-...", "c" maps to "-.-.", and so on.

     For convenience, the full table for the 26 letters of the English alphabet is given below:

     [".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."]
     Now, given a list of words, each word can be written as a concatenation of the Morse code of each letter. For example, "cab" can be written as "-.-.-....-", (which is the concatenation "-.-." + "-..." + ".-"). We'll call such a concatenation, the transformation of a word.

     Return the number of different transformations among all words we have.

     Example:
     Input: words = ["gin", "zen", "gig", "msg"]
     Output: 2
     Explanation:
     The transformation of each word is:
     "gin" -> "--...-."
     "zen" -> "--...-."
     "gig" -> "--...--."
     "msg" -> "--...--."

     There are 2 different transformations, "--...-." and "--...--.".

     Note:

     The length of words will be at most 100.
     Each words[i] will have length in range [1, 12].
     words[i] will only consist of lowercase letters.
     */

    // [ACCEPTED]
    private static String[] DICTIONARY = {
            ".-", "-...", "-.-.", "-..", ".", "..-.", "--.",
            "....", "..", ".---", "-.-", ".-..", "--", "-.",
            "---", ".--.", "--.-", ".-.", "...", "-",
            "..-", "...-", ".--", "-..-", "-.--", "--.."
    };

    public int uniqueMorseRepresentations(String[] words) {
        if (words == null || words.length == 0) {
            return 0;
        }
        HashSet<String> morseSet = new HashSet<>();
        for (int i = 0; i < words.length; i++) {
            morseSet.add(word2MorseCode(words[i]));
        }
        return morseSet.size();
    }

    private String word2MorseCode(String word) {
        if (word == null || word.length() == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        char c;
        int index;
        for (int i = 0; i < word.length(); i++) {
            c = word.charAt(i);
            index = c - 'a';
            if (index >= 0 && index < DICTIONARY.length) {
                sb.append(DICTIONARY[index]);
            }
        }
        return sb.toString();
    }
}
