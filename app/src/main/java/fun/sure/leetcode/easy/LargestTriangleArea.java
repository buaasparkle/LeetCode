package fun.sure.leetcode.easy;

/**
 * Created by sure on 2018/7/21.
 */

public class LargestTriangleArea {

    /**
     * ou have a list of points in the plane. Return the area of the largest triangle that can be formed by any 3 of the points.

     Example:
     Input: points = [[0,0],[0,1],[1,0],[0,2],[2,0]]
     Output: 2
     Explanation:
     The five points are show in the figure below. The red triangle is the largest.


     Notes:

     3 <= points.length <= 50.
     No points will be duplicated.
     -50 <= points[i][j] <= 50.
     Answers within 10^-6 of the true value will be accepted as correct.
     */

    /**
     * Hint: https://en.wikipedia.org/wiki/Shoelace_formula
     */

    // [ACCEPTED]
    public double largestTriangleArea(int[][] points) {
        int N = points.length;
        double area = 0f;
        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                for (int k = j + 1; k < N; k++) {
                    area = Math.max(area, shoelaceFormula(points[i], points[j], points[k]));
                }
            }
        }
        return area;
    }

    private double shoelaceFormula(int[] x, int[] y, int[] z) {
        // A = 1/2 | x1y2 + x2y3 + x3y1 - x2y1 - x3y2 - x1y3 |
        return 0.5f * Math.abs(x[0] * y[1] + y[0] * z[1] + z[0] * x[1] - y[0] * x[1] - z[0] * y[1] - x[0] * z[1]);
    }
}
