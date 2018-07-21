package fun.sure.leetcode.easy;

/**
 * Created by sure on 2018/7/21.
 */

public class ToLowerCase {

    /**
     * Implement function ToLowerCase() that has a string parameter str, and returns the same string in lowercase.



     Example 1:

     Input: "Hello"
     Output: "hello"
     Example 2:

     Input: "here"
     Output: "here"
     Example 3:

     Input: "LOVELY"
     Output: "lovely"
     */

    // [ACCEPTED]
    public String toLowerCase(String str) {
        if (str == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        char c;
        for (int i = 0; i < str.length(); i++) {
            c = str.charAt(i);
            if (c >= 'A' && c <= 'Z') {
                c = (char) (c - 'A' + 'a');
            }
            sb.append(c);
        }
        return sb.toString();
    }
}
