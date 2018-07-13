package fun.sure.leetcode.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by sure on 2018/7/7.
 */

public class ShortestDistanceToACharacter {

    /**
     * Given a string S and a character C, return an array of integers representing the shortest distance from the character C in the string.

     Example 1:

     Input: S = "loveleetcode", C = 'e'
     Output: [3, 2, 1, 0, 1, 0, 0, 1, 2, 2, 1, 0]


     Note:

     S string length is in [1, 10000].
     C is a single character, and guaranteed to be in string S.
     All letters in S and C are lowercase.
     */

    // [ACCEPTED]
    public int[] shortestToChar(String S, char C) {
        List<Integer> charIndexList = new ArrayList<>();
        char c;
        for (int i = 0; i < S.length(); i++) {
            c = S.charAt(i);
            if (c == C) {
                charIndexList.add(i);
            }
        }
        int[] result = new int[S.length()];
        int right = charIndexList.get(0);
        for (int i = 0; i <= right; i++) {
            result[i] = right - i;
        }
        int left = right;
        for (int i = 1; i < charIndexList.size(); i++) {
            right = charIndexList.get(i);
            for (int j = left; j <= right; j++) {
                result[j] = Math.min(j - left, right - j);
            }
            left = right;
        }
        for (int i = left + 1; i < S.length() ; i++) {
            result[i] = i - left;
        }
        return result;
    }

    public static void main(String[] args) {
        String S = "loveleetcode";
        char C = 'e';
        System.out.println(Arrays.toString(new ShortestDistanceToACharacter().shortestToChar(S, C)));
    }
}
