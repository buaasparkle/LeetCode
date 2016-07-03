package fun.sure.leetcode.medium;

/**
 * Created by wangshuo on 2016/6/14.
 */
public class CountingBits {

    /**
     *Given a non negative integer number num. For every numbers i in the range 0 ≤ i ≤ num calculate the number of 1's in their
     * binary representation and return them as an array.

     Example:
     For num = 5 you should return [0,1,1,2,1,2].

     Follow up:

     It is very easy to come up with a solution with run time O(n*sizeof(integer)). But can you do it in linear time O(n) /possibly in a single pass?
     Space complexity should be O(n).
     Can you do it like a boss? Do it without using any builtin function like __builtin_popcount in c++ or in any other language.
     */

//        int bits[] = {
//                0, 1, 1, 2, 1, 2, 2, 3, 1, 2, 2, 3, 2, 3, 3, 4, 1,
//                0, 1, 2, 3, 4, 5, 6, 7, 8, 9,10,11,12,13,14,15,16
//        }
//        发现规律如下：
//        bits[2的幂] = 1，比如bits[1/2/4/8] = 1
//        bits[n] = bits[n - 最近的比n小的2的幂数] + 1，比如 bits[9] = bits[9-8] + 1, bits[6] = bits[6-4] + 1

    // [PASS]
    public int[] countBits(int num) {
        int[] bits = new int[num + 1];
        bits[0] = 0;
        int exp = 1; // exp(0)
        int expPrev = exp;
        for (int i = 1; i <= num ; i++) {
            if (i == exp) {
                bits[i] = 1;
                expPrev = exp;
                exp *= 2;
            } else if (i < exp) {
                bits[i] = bits[i - expPrev] + 1;
            }
        }
        return bits;
    }

    public static void main(String[] args) {
        int[] bits = new CountingBits().countBits(32);
        for (int bit : bits) {
            System.out.print(bit + " ");
        }
    }
}
