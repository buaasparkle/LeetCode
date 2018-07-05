package fun.sure.leetcode.easy;

/**
 * Created by sure on 2018/7/6.
 */

public class PeakIndexInAMountainArray {

    /**
     * Let's call an array A a mountain if the following properties hold:

     A.length >= 3
     There exists some 0 < i < A.length - 1 such that A[0] < A[1] < ... A[i-1] < A[i] > A[i+1] > ... > A[A.length - 1]
     Given an array that is definitely a mountain, return any i such that A[0] < A[1] < ... A[i-1] < A[i] > A[i+1] > ... > A[A.length - 1].

     Example 1:

     Input: [0,1,0]
     Output: 1
     Example 2:

     Input: [0,2,1,0]
     Output: 1
     Note:

     3 <= A.length <= 10000
     0 <= A[i] <= 10^6
     A is a mountain, as defined above.

     */

    // [ACCEPTED]
    public int peakIndexInMountainArray(int[] A) {
        int low = 0;
        int high = A.length - 1;
        int mid = 0;
        while (low <= high) {
            mid = (low + high) / 2;
            if (mid == 0 || mid == A.length - 1) {
                break;
            } else if (A[mid - 1] < A[mid] && A[mid] > A[mid + 1]) {
                break; // find id
            } else if (A[mid - 1] < A[mid] && A[mid] < A[mid + 1]) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return mid;
    }
}
