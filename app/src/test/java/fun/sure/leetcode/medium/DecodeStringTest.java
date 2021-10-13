package fun.sure.leetcode.medium;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by wangshuo on 2021/10/14.
 */
public class DecodeStringTest {

    private DecodeString target = new DecodeString();

    @Test
    public void decodeString() {
        assertEquals("aaabcbc", target.decodeString("3[a]2[bc]"));
        assertEquals("accaccacc", target.decodeString("3[a2[c]]"));
        assertEquals("abcabccdcdcdef", target.decodeString("2[abc]3[cd]ef"));
        assertEquals("abccdcdcdxyz", target.decodeString("abc3[cd]xyz"));
    }
}