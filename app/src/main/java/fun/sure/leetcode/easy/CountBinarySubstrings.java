package fun.sure.leetcode.easy;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * Created by sure on 2018/8/4.
 */

public class CountBinarySubstrings {

    /**
     * Give a string s, count the number of non-empty (contiguous) substrings that have the same number of 0's and 1's, and all the 0's and all the 1's in these substrings are grouped consecutively.

     Substrings that occur multiple times are counted the number of times they occur.

     Example 1:
     Input: "00110011"
     Output: 6
     Explanation: There are 6 substrings that have equal number of consecutive 1's and 0's: "0011", "01", "1100", "10", "0011", and "01".

     Notice that some of these substrings repeat and are counted the number of times they occur.

     Also, "00110011" is not a valid substring because all the 0's (and 1's) are not grouped together.
     Example 2:
     Input: "10101"
     Output: 4
     Explanation: There are 4 substrings: "10", "01", "10", "01" that have equal number of consecutive 1's and 0's.
     Note:

     s.length will be between 1 and 50,000.
     s will only consist of "0" or "1" characters.
     */

    // [ACCEPTED]
    public int countBinarySubstrings(String s) {
        int count = 0;
        int[] consecutive = new int[] {0, 0}; // 0, 1
        char c;
        Character lastC = null;
        int index;
        for (int j = 0; j < s.length(); j++) {
            c = s.charAt(j);
            index = c - '0';
            if (lastC == null || lastC == c) {
                consecutive[index]++;
            } else {
                count += Math.min(consecutive[0], consecutive[1]);
                consecutive[index] = 1;
            }
            lastC = c;
        }
        count += Math.min(consecutive[0], consecutive[1]);
        return count;
    }

    // [Memory Limit Exceeded ]
    public int countBinarySubstrings2(String s) {
        Stack<Character> stack = new Stack<>();
        Map<String ,Integer> map = new HashMap<>();
        char cur;
        char c;
        for (int i = 0; i < s.length();) {
            c = s.charAt(i);
            if (stack.isEmpty() || stack.peek() == c) {
                stack.push(c);
                i++;
            } else {
                cur = c;
                String subStr;
                Stack<Character> tmpStack = new Stack<>();
                int j;
                for (j = i; j < s.length(); j++) {
                    c = s.charAt(j);
                    if (c != cur) {
                        break;
                    }
                    tmpStack.push(c);
                    subStr = makeSubString(stack.pop(), c, j - i + 1);
                    if (map.containsKey(subStr)) {
                        map.put(subStr, map.get(subStr) + 1);
                    } else {
                        map.put(subStr, 1);
                    }
                    if (stack.isEmpty()) {
                        j++;
                        break;
                    }
                }
                i = j;
                stack.clear();
                stack.addAll(tmpStack);
            }
        }
        int count = 0;
        for (Integer number : map.values()) {
            count += number;
        }
        return count;
    }

    private String makeSubString(char front, char end, int count) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < count; i++) {
            sb.append(front);
        }
        for (int i = 0; i < count; i++) {
            sb.append(end);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String s = "10101";
        System.out.println(new CountBinarySubstrings().countBinarySubstrings(s));
    }
}
