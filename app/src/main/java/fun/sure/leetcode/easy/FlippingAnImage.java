package fun.sure.leetcode.easy;

/**
 * Created by sure on 2018/7/6.
 */

public class FlippingAnImage {

    /**
     * Given a binary matrix A, we want to flip the image horizontally, then invert it, and return the resulting image.

     To flip an image horizontally means that each row of the image is reversed.  For example, flipping [1, 1, 0] horizontally results in [0, 1, 1].

     To invert an image means that each 0 is replaced by 1, and each 1 is replaced by 0. For example, inverting [0, 1, 1] results in [1, 0, 0].

     Example 1:

     Input: [[1,1,0],[1,0,1],[0,0,0]]
     Output: [[1,0,0],[0,1,0],[1,1,1]]
     Explanation: First reverse each row: [[0,1,1],[1,0,1],[0,0,0]].
     Then, invert the image: [[1,0,0],[0,1,0],[1,1,1]]
     Example 2:

     Input: [[1,1,0,0],[1,0,0,1],[0,1,1,1],[1,0,1,0]]
     Output: [[1,1,0,0],[0,1,1,0],[0,0,0,1],[1,0,1,0]]
     Explanation: First reverse each row: [[0,0,1,1],[1,0,0,1],[1,1,1,0],[0,1,0,1]].
     Then invert the image: [[1,1,0,0],[0,1,1,0],[0,0,0,1],[1,0,1,0]]
     Notes:

     1 <= A.length = A[0].length <= 20
     0 <= A[i][j] <= 1
     */

    // [ACCEPTED]
    public int[][] flipAndInvertImage(int[][] A) {
        return invertMatrix(filpMatrix(A));
    }

    private int[][] filpMatrix(int[][] A) {
        for (int i = 0; i < A.length; i++) {
            for (int j = 0, k = A[i].length - 1; j < k; j++, k--) {
                int temp = A[i][j];
                A[i][j] = A[i][k];
                A[i][k] = temp;
            }
        }
        return A;
    }

    private int[][] invertMatrix(int[][] A) {
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A[i].length; j++) {
                A[i][j] ^= 1;
            }
        }
        return A;
    }
}