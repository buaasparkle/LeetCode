package fun.sure.leetcode.easy;

/**
 * Created by wangshuo on 2016/6/13.
 */
public class RectangleArea {

    /**
     * Find the total area covered by two rectilinear rectangles in a 2D plane.

     Each rectangle is defined by its bottom left corner and top right corner as shown in the figure.

     Rectangle Area
     Assume that the total area is never beyond the maximum possible value of int.

     */

    // [PASS]
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        int x = findOverlayLength(A, C, E, G);
        int y = findOverlayLength(B, D, F, H);
        return calcArea(A, B, C, D) + calcArea(E, F, G, H) - x * y;
    }

    private int calcArea(int a, int b, int c, int d) {
        return (c - a) * (d - b);
    }

    private int findOverlayLength(int l1, int r1, int l2, int r2) {
        int len = 0;
        if (l2 <= l1) {
            len = Math.max(Math.min(r2 - l1, r1 - l1), 0);
        } else if (l1 < l2 && l2 < r1) {
            len = Math.min(r1, r2) - l2;
        }
        return len;
    }

    public static void main(String[] args) {
        System.out.print(new RectangleArea().computeArea(-2, -2, 2, 2, -2, -2, 2, 2));
    }
}
