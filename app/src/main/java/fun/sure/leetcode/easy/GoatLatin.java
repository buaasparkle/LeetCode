package fun.sure.leetcode.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sure on 2018/7/13.
 */

public class GoatLatin {

    /**
     * A sentence S is given, composed of words separated by spaces. Each word consists of lowercase and uppercase letters only.

     We would like to convert the sentence to "Goat Latin" (a made-up language similar to Pig Latin.)

     The rules of Goat Latin are as follows:

     If a word begins with a vowel (a, e, i, o, or u), append "ma" to the end of the word.
     For example, the word 'apple' becomes 'applema'.

     If a word begins with a consonant (i.e. not a vowel), remove the first letter and append it to the end, then add "ma".
     For example, the word "goat" becomes "oatgma".

     Add one letter 'a' to the end of each word per its word index in the sentence, starting with 1.
     For example, the first word gets "a" added to the end, the second word gets "aa" added to the end and so on.
     Return the final sentence representing the conversion from S to Goat Latin.



     Example 1:

     Input: "I speak Goat Latin"
     Output: "Imaa peaksmaaa oatGmaaaa atinLmaaaaa"
     Example 2:

     Input: "The quick brown fox jumped over the lazy dog"
     Output: "heTmaa uickqmaaa rownbmaaaa oxfmaaaaa umpedjmaaaaaa overmaaaaaaa hetmaaaaaaaa azylmaaaaaaaaa ogdmaaaaaaaaaa"


     Notes:

     S contains only uppercase, lowercase and spaces. Exactly one space between each word.
     1 <= S.length <= 150.
     */

    private static final String SURFIX = "ma";

    private static List<Character> vowelList = new ArrayList<>();
    static {
        vowelList.add('a');
        vowelList.add('e');
        vowelList.add('i');
        vowelList.add('o');
        vowelList.add('u');
        vowelList.add('A');
        vowelList.add('E');
        vowelList.add('I');
        vowelList.add('O');
        vowelList.add('U');
    }

    public String toGoatLatin(String S) {
        String[] words = S.split(" ");
        StringBuilder sb = new StringBuilder();
        sb.append(covertStringPerRule(words[0], 1));
        for (int i = 1; i < words.length; i++) {
            sb.append(" ").append(covertStringPerRule(words[i], i + 1));
        }
        return sb.toString();
    }

    private String covertStringPerRule(String s, int index) {
        char c = s.charAt(0);
        StringBuilder sb = new StringBuilder();
        if (vowelList.contains(c)) {
            sb.append(s);
        } else {
            sb.append(s.substring(1)).append(c);
        }
        sb.append(SURFIX);
        for (int i = 0; i < index; i++) {
            sb.append('a');
        }
        return sb.toString();
    }
}
