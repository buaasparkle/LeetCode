package fun.sure.leetcode.medium;

import fun.sure.leetcode.Topics;

/**
 * Created by wangshuo on 2021/10/13.
 */
class DecodeString implements Topics.String, Topics.Stack, Topics.Recursion {

    /**
     * Given an encoded string, return its decoded string.
     * <p>
     * The encoding rule is: k[encoded_string], where the encoded_string inside the square brackets is being repeated exactly k times. Note that k is guaranteed to be a positive integer.
     * <p>
     * You may assume that the input string is always valid; No extra white spaces, square brackets are well-formed, etc.
     * <p>
     * Furthermore, you may assume that the original data does not contain any digits and that digits are only for those repeat numbers, k. For example, there won't be input like 3a or 2[4].
     * <p>
     * <p>
     * <p>
     * Example 1:
     * <p>
     * Input: s = "3[a]2[bc]"
     * Output: "aaabcbc"
     * Example 2:
     * <p>
     * Input: s = "3[a2[c]]"
     * Output: "accaccacc"
     * Example 3:
     * <p>
     * Input: s = "2[abc]3[cd]ef"
     * Output: "abcabccdcdcdef"
     * Example 4:
     * <p>
     * Input: s = "abc3[cd]xyz"
     * Output: "abccdcdcdxyz"
     * <p>
     * <p>
     * Constraints:
     * <p>
     * 1 <= s.length <= 30
     * s consists of lowercase English letters, digits, and square brackets '[]'.
     * s is guaranteed to be a valid input.
     * All the integers in s are in the range [1, 300].
     */

    /*
    Success
    Runtime: 0 ms, faster than 100.00% of Java online submissions for Decode String.
    Memory Usage: 37.2 MB, less than 64.71% of Java online submissions for Decode String.
     */
    public String decodeString(String s) {
        StringBuilder sb = new StringBuilder();
        StringBuilder token = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                token.append(c);
            } else if (Character.isLetter(c)) {
                sb.append(c);
            } else if (c == '[') {
                int digit = Integer.parseInt(token.toString());
                token = new StringBuilder(); // reset
                // find pair
                int pairCount = 0;
                int j;
                for (j = i + 1; j < s.length(); j++) {
                    if (s.charAt(j) == ']') {
                        if (pairCount == 0) {
                            break;
                        } else {
                            pairCount--;
                        }
                    }
                    if (s.charAt(j) == '[') {
                        pairCount++;
                    }
                }
                String recur = s.substring(i + 1, j);
                String innerResult = decodeString(recur);
                for (int k = 0; k < digit; k++) {
                    sb.append(innerResult);
                }
                i = j;
            } else {
                // ']' do nothing
            }
        }
        return sb.toString();
    }
}
