package fun.sure.leetcode.easy;

/**
 * Created by sure on 2018/3/24.
 */

public class ReverseWordsStringIII {

    /**
     * Given a string, you need to reverse the order of characters in each word within a sentence
     * while still preserving whitespace and initial word order.

     Example 1:
     Input: "Let's take LeetCode contest"
     Output: "s'teL ekat edoCteeL tsetnoc"
     Note: In the string, each word is separated by single space and there will not be any extra space in the string.
     */

    // [PASS]
    public String reverseWords(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }
        String[] children = s.split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < children.length; i++) {
            sb.append(reverse(children[i]));
            if (i != children.length - 1) {
                sb.append(" ");
            }
        }
        return sb.toString();
    }

    private String reverse(String s) {
        if (s == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = s.length() - 1; i >= 0; i--) {
            sb.append(s.charAt(i));
        }
        return sb.toString();
    }
}
