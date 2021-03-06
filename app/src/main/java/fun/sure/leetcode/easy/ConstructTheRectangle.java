package fun.sure.leetcode.easy;

import java.util.Arrays;

/**
 * Created by sure on 2017/2/19.
 */

public class ConstructTheRectangle {

    /**
     * For a web developer, it is very important to know how to design a web page's size. So, given a specific rectangular web page’s area, your job by now is to design a rectangular web page, whose length L and width W satisfy the following requirements:
     * <p>
     * 1. The area of the rectangular web page you designed must equal to the given target area.
     * <p>
     * 2. The width W should not be larger than the length L, which means L >= W.
     * <p>
     * 3. The difference between length L and width W should be as small as possible.
     * You need to output the length L and the width W of the web page you designed in sequence.
     *
     * Example:
     * Input: 4
     * Output: [2, 2]
     * Explanation: The target area is 4, and all the possible ways to construct it are [1,4], [2,2], [4,1].
     * But according to requirement 2, [1,4] is illegal; according to requirement 3,  [4,1] is not optimal compared to [2,2]. So the length L is 2, and the width W is 2.
     * Note:
     * The given area won't exceed 10,000,000 and is a positive integer
     * The web page's width and length you designed must be positive integers.
     */

    // 1 先找到area的平方根，如果是整数即为所得
    // 2 从离平方根最近且小于它的整数开始向下遍历，如果能被area整除，即为W，L= area / W
    public int[] constructRectangle(int area) {
        int sqrt = (int) Math.ceil(Math.sqrt(area));
        for (int i = sqrt; i <= area; i++) {
            if (area % i == 0) {
                return new int[]{i, area / i};
            }
        }
        return null;
    }

    public static void main(String[] args) {
        int[] ret = new ConstructTheRectangle().constructRectangle(6);
        System.out.println(Arrays.toString(ret));
    }
}
