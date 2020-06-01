package fun.sure.leetcode.medium;

import java.util.Arrays;

/**
 * Created by wangshuo on 2020-06-01.
 */
public class UTF8Validation {

    /**
     * https://leetcode.com/problems/utf-8-validation
     * <p>
     * A character in UTF8 can be from 1 to 4 bytes long, subjected to the following rules:
     * <p>
     * For 1-byte character, the first bit is a 0, followed by its unicode code.
     * For n-bytes character, the first n-bits are all one's, the n+1 bit is 0, followed by n-1 bytes with most significant 2 bits being 10.
     * This is how the UTF-8 encoding would work:
     * <p>
     * Char. number range  |        UTF-8 octet sequence
     * (hexadecimal)    |              (binary)
     * --------------------+---------------------------------------------
     * 0000 0000-0000 007F | 0xxxxxxx
     * 0000 0080-0000 07FF | 110xxxxx 10xxxxxx
     * 0000 0800-0000 FFFF | 1110xxxx 10xxxxxx 10xxxxxx
     * 0001 0000-0010 FFFF | 11110xxx 10xxxxxx 10xxxxxx 10xxxxxx
     * Given an array of integers representing the data, return whether it is a valid utf-8 encoding.
     * <p>
     * Note:
     * The input is an array of integers. Only the least significant 8 bits of each integer is used to store the data. This means each integer represents only 1 byte of data.
     * <p>
     * Example 1:
     * <p>
     * data = [197, 130, 1], which represents the octet sequence: 11000101 10000010 00000001.
     * <p>
     * Return true.
     * It is a valid utf-8 encoding for a 2-bytes character followed by a 1-byte character.
     * Example 2:
     * <p>
     * data = [235, 140, 4], which represented the octet sequence: 11101011 10001100 00000100.
     * <p>
     * Return false.
     * The first 3 bits are all one's and the 4th bit is 0 means it is a 3-bytes character.
     * The next byte is a continuation byte which starts with 10 and that's correct.
     * But the second continuation byte does not start with 10, so it is invalid.
     */

    // [PASS]
    private static int LEAST_EIGHT = 0x000000FF;
    private static int[] VALID_ONES = {0, 2, 3, 4};

    public static void main(String[] args) {
        int[][] data = {
                {197, 130, 1},
                {235, 140, 4},
                {237},
                {145},
        };
        long start = System.nanoTime();
        for (int i = 0; i < data.length; i++) {
            System.out.print("test: " + Arrays.toString(data[i]));
            System.out.println("--" + new UTF8Validation().validUtf8(data[i]));
        }
        System.out.print("time cost: " + (System.nanoTime() - start));
    }

    public boolean validUtf8(int[] data) {
        int checkFollowingCount = 0; // checkFollowingCount 表示第一个 byte 合法，检查后续 byte 的个数
        for (int i = 0; i < data.length; i++) {
            int value = data[i];
            if (checkFollowingCount > 0) {
                if (!startWithBitOneZero(value)) {
                    return false;
                }
                checkFollowingCount--;
            } else {
                int num = numOfHeadOnes(value);
                if (!validOnes(num)) {
                    return false;
                }
                checkFollowingCount = Math.max(num - 1, 0);
            }
        }
        return checkFollowingCount == 0;
    }

    // 计算 1个 byte 头部包含几个连续的 1
    private int numOfHeadOnes(int data) {
        data = data & LEAST_EIGHT;
        int count = 0;
        int shift = 7;
        int flagBit = 1;
        while (((flagBit << shift) & data) > 0) {
            count++;
            shift--;
        }
        return count;
    }

    // 判断一个 byte 头两位是不是 10
    private boolean startWithBitOneZero(int data) {
        data = data & LEAST_EIGHT;
        return ((data >> 6) ^ 2) == 0;
    }

    private boolean validOnes(int num) {
        for (int i = 0; i < VALID_ONES.length; i++) {
            if (num == VALID_ONES[i]) {
                return true;
            }
        }
        return false;
    }
}
