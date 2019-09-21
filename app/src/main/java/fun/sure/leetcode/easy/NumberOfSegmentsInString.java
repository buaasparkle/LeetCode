package fun.sure.leetcode.easy;

public class NumberOfSegmentsInString {

    /**
     * Count the number of segments in a string, where a segment is defined to be a contiguous sequence of non-space characters.
     *
     * Please note that the string does not contain any non-printable characters.
     *
     * Example:
     *
     * Input: "Hello, my name is John"
     * Output: 5
     */

    // [AC]
    public int countSegments(String s) {
        int segment = 0;
        if (s != null && s.length() > 0) {
            char lastC = s.charAt(0);
            segment += isSpaceChar(lastC) ? 0 : 1;
            for (int i = 1; i < s.length(); i++) {
                char c = s.charAt(i);
                if (!isSpaceChar(c) && isSpaceChar(lastC)) {
                    segment++;
                }
                lastC = c;
            }
        }
        return segment;
    }

    private boolean isSpaceChar(char c) {
        return c == ' ';
    }
}
