package fun.sure.leetcode.easy;

/**
 * Created by sure on 2018/9/6.
 */

public class MonotonicArray {

    /**
     * An array is monotonic if it is either monotone increasing or monotone decreasing.

     An array A is monotone increasing if for all i <= j, A[i] <= A[j].  An array A is monotone decreasing if for all i <= j, A[i] >= A[j].

     Return true if and only if the given array A is monotonic.

     Example 1:

     Input: [1,2,2,3]
     Output: true
     Example 2:

     Input: [6,5,4,4]
     Output: true
     Example 3:

     Input: [1,3,2]
     Output: false
     Example 4:

     Input: [1,2,4,5]
     Output: true
     Example 5:

     Input: [1,1,1]
     Output: true
     */

    // [AC]
    public boolean isMonotonic(int[] A) {
        if (A == null || A.length == 0) {
            return false;
        }
        int INIT = 0;
        int INC = 1;
        int DEC = 2;

        int cur = INIT;
        int left = A[0];
        int right;
        for (int i = 1; i < A.length; i++) {
            right = A[i];
            if (cur == INIT) {
                cur = (left == right) ? INIT
                        : left > right ? DEC : INC;
            } else if (cur == INC) {
                if (left > right) {
                    return false;
                }
            } else { // DEC
                if (left < right) {
                    return false;
                }
            }
            left = right;
        }
        return true;
    }
}
