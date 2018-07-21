package fun.sure.leetcode.easy;

/**
 * Created by sure on 2018/7/21.
 */

public class DetectCapital {

    /**
     * Given a word, you need to judge whether the usage of capitals in it is right or not.

     We define the usage of capitals in a word to be right when one of the following cases holds:

     All letters in this word are capitals, like "USA".
     All letters in this word are not capitals, like "leetcode".
     Only the first letter in this word is capital if it has more than one letter, like "Google".
     Otherwise, we define that this word doesn't use capitals in a right way.
     Example 1:
     Input: "USA"
     Output: True
     Example 2:
     Input: "FlaG"
     Output: False
     Note: The input will be a non-empty word consisting of uppercase and lowercase latin letters.
     */

    // [ACCEPTED]
    public boolean detectCapitalUse(String word) {
        char first = word.charAt(0);
        if (isLowerCase(first)) {
            for (int i = 1; i < word.length(); i++) {
                if (isUpperCase(word.charAt(i))) {
                    return false;
                }
            }
            return true;
        } else {
            boolean hasLower = false;
            boolean hasUpper = false;
            char c;
            for (int i = 1; i < word.length(); i++) {
                c = word.charAt(i);
                if (!hasLower && isLowerCase(c)) {
                    hasLower = true;
                }
                if (!hasUpper && isUpperCase(c)) {
                    hasUpper = true;
                }
                if (isUpperCase(c) && hasLower || isLowerCase(c) && hasUpper) {
                    return false;
                }
            }
            return true;
        }
    }

    private boolean isLowerCase(char c) {
        return c >= 'a' && c <= 'z';
    }

    private boolean isUpperCase(char c) {
        return c >= 'A' && c <= 'Z';
    }
}
