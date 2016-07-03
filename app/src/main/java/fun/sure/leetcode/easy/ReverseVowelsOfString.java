package fun.sure.leetcode.easy;

/**
 * Created by wangshuo on 2016/6/12.
 */
public class ReverseVowelsOfString {

    /**
     *Write a function that takes a string as input and reverse only the vowels of a string.

     Example 1:
     Given s = "hello", return "holle".

     Example 2:
     Given s = "leetcode", return "leotcede".
     */

    // [PASS]
    public String reverseVowels(String s) {
        if (s == null || s.length() <= 1) {
            return s;
        }
        int i = 0;
        int j = s.length() - 1;
        char[] charArray = s.toCharArray();
        while (i < j) {
            while (i < j && !isVowel(charArray[i])) {
                i++;
            }
            while (i < j && !isVowel(charArray[j])) {
                j--;
            }
            if (i < j) {
                char temp = charArray[i];
                charArray[i] = charArray[j];
                charArray[j] = temp;
                i++;
                j--;
            } else {
                break;
            }
        }
        return String.copyValueOf(charArray);
    }

    private boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u'
                || c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U';
    }
}
