package fun.sure.leetcode.easy;

import android.support.annotation.NonNull;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by sure on 2017/2/18.
 */

public class KeyboardRowAdd {

    /**
     * Given a List of words, return the words that can be typed using letters of alphabet on only
     * one row's of American keyboard like the image below.


     American keyboard


     Example 1:
     Input: ["Hello", "Alaska", "Dad", "Peace"]
     Output: ["Alaska", "Dad"]
     Note:
     You may use one character in the keyboard more than once.
     You may assume the input string will only contain letters of alphabet.

     */

    private static final String[] topRow = {
            "q", "w", "e", "r", "t", "y", "u", "i", "o", "p"
    };

    private static final String[] middleRow = {
            "a", "s", "d", "f", "g", "h", "j", "k", "l"
    };

    private static final String[] bottomRow = {
            "z", "x", "c", "v", "b", "n", "m"
    };

    public String[] findWords(String[] words) {
        List<String> ret = new ArrayList<>();
        if (words != null) {
            for (String word : words) {
                if (canAssembleFromOneRow(word)) {
                    ret.add(word);
                }
            }
        }
        return ret.toArray(new String[0]);
    }

    private boolean canAssembleFromOneRow(String word) {
        return canAssembleFromRow(word, getRowOfFirstChar(word));
    }

    private String[] getRowOfFirstChar(String word) {
        if (word == null || word.length() == 0) {
            return null;
        }
        String firstChar = String.valueOf(word.charAt(0)).toLowerCase();
        if (contains(topRow, firstChar)) {
            return topRow;
        } else if (contains(middleRow, firstChar)) {
            return middleRow;
        } else if (contains(bottomRow, firstChar)) {
            return bottomRow;
        }
        return null;
    }

    private boolean canAssembleFromRow(String word, String[] row) {
        if (word == null || word.length() == 0 || row == null) {
            return false;
        }
        for (int i = 0; i < word.length(); i++) {
            String c = String.valueOf(word.charAt(i)).toLowerCase();
            if (!contains(row, c)) {
                return false;
            }
        }
        return true;
    }

    private boolean contains(String[] row, String c) {
        boolean find = false;
        for (String s : row) {
            if (s.equalsIgnoreCase(c)) {
                find = true;
                break;
            }
        }
        return find;
    }

    public static void main(String[] args) {
        String[] words = {
                "Hello", "Alaska", "Dad", "Peace"
        };
        String[] ret = new KeyboardRowAdd().findWords(words);
        System.out.println(Arrays.toString(ret));
    }
}
