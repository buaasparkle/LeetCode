package fun.sure.leetcode.easy;

/**
 * Created by sure on 2017/2/18.
 */

public class HammingDistance {

    /**
     * The Hamming distance between two integers is the number of positions at which the corresponding bits are different.

     Given two integers x and y, calculate the Hamming distance.

     Note:
     0 ≤ x, y < 231.

     Example:

     Input: x = 1, y = 4

     Output: 2

     Explanation:
     1   (0 0 0 1)
     4   (0 1 0 0)
     ↑   ↑

     The above arrows point to positions where the corresponding bits are different.
     */

    // 因为最多32位，从最低位开始，每次右移1位比较
    public int hammingDistance(int x, int y) {
        int distance = 0;
        for (int i = 0; i < 31; i++) {
            distance += ((x & 0x1) == (y & 0x1)) ? 0 : 1;
            x >>= 1;
            y >>= 1;
        }
        return distance;

    }

    public static void main(String[] args) {
        System.out.println(new HammingDistance().hammingDistance(1, 4));
    }
}
