package fun.sure.leetcode.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sure on 2018/7/21.
 */

public class LetterCasePermutation {

    /**
     * Given a string S, we can transform every letter individually to be lowercase or uppercase to create another string.  Return a list of all possible strings we could create.

     Examples:
     Input: S = "a1b2"
     Output: ["a1b2", "a1B2", "A1b2", "A1B2"]

     Input: S = "3z4"
     Output: ["3z4", "3Z4"]

     Input: S = "12345"
     Output: ["12345"]
     Note:

     S will be a string with length at most 12.
     S will consist only of letters or digits.
     */

    // [ACCEPTED]
    public List<String> letterCasePermutation(String S) {
        List<String> ret = new ArrayList<>();
        if (S == null) {
            return ret;
        } else if (S.length() == 0) {
            ret.add(S);
            return ret;
        }
        char c = S.charAt(0);
        List<String> subList = S.length() > 1 ? letterCasePermutation(S.substring(1)) : new ArrayList<String>();
        int kind = c >= 'a' && c <= 'z' || c >= 'A' && c <= 'Z' ? 2 : 1;
        String cs = String.valueOf(c);
        if (subList.size() == 0) {
            if (kind == 1) {
                ret.add(cs);
            } else {
                ret.add(cs.toLowerCase());
                ret.add(cs.toUpperCase());
            }
        } else {
            for (int i = 0; i < kind; i++) {
                for (String s : subList) {
                    ret.add((kind == 1 ? cs : i % 2 == 0 ? cs.toUpperCase() : cs.toLowerCase()) + s);
                }
            }
        }
        return ret;
    }
}
