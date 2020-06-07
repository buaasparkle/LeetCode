package fun.sure.leetcode.hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by wangshuo on 2020-06-07.
 */
public class SplitArrayWithSameAverage {

    /**
     * In a given integer array A, we must move every element of A to either list B or list C. (B and C initially start empty.)
     *
     * Return true if and only if after such a move, it is possible that the average value of B is equal to the average value of C, and B and C are both non-empty.
     *
     * Example :
     * Input:
     * [1,2,3,4,5,6,7,8]
     * Output: true
     * Explanation: We can split the array into [1,4,5,8] and [2,3,6,7], and both of them have the average of 4.5.
     * Note:
     *
     * The length of A will be in the range [1, 30].
     * A[i] will be in the range of [0, 10000].
     */

    // [Out Of Time]
    // 指数级的时间复杂度
    public boolean splitArraySameAverage2(int[] A) {
        int maxNum = (int) (Math.pow(2, (A.length) + 1) / 2);
        for (int i = 1; i < maxNum - 1; i++) {
            SumLength[] sumLengths = subListSumCounts(A, i);
            if (sumLengths[0].averageEqual(sumLengths[1])) {
                System.out.println(sumLengths[0].toString());
                System.out.println(sumLengths[1].toString());
                return true;
            }
        }
        return false;
    }

    // 将 num 转为 二进制 数字后，位为 1 的组成 list B，位为 0 的组成 list C
    // num 最大为 pow(2, listA.length) - 1
    // @return <Sum, Count> // 数字的和，以及数字的个数
    private SumLength[] subListSumCounts(int[] A, int num) {
        SumLength[] sumLength = {
                new SumLength(),
                new SumLength()
        };
        int index = 0;
        while (index < A.length) {
            int choose = (num & 0x1) > 0 ? 0 : 1;
            sumLength[choose].accNum(A[index]);
            sumLength[choose].incLength();
            num >>= 1;
            index++;
        }
        return sumLength;
    }

    // 记录序列的 sum 和 length
    private static class SumLength {
        int sum;
        int length;

        private List<Integer> record;

        SumLength() {
            this(0, 0);
        }

        SumLength(int sum, int length) {
            this.sum = sum;
            this.length = length;
        }

        void accNum(int num) {
            sum += num;
            getRecord().add(num);
        }

        void incLength() {
            length++;
        }

        double getAverage() {
            if (length == 0) {
                return 0;
            }
            return sum * 1f / length;
        }

        boolean averageEqual(SumLength that) {
            if (that == null) {
                return false;
            }
            return sum * that.length == length * that.sum;
        }

        private List<Integer> getRecord() {
            if (record == null) {
                record = new ArrayList<>();
            }
            return record;
        }

        @Override
        public String toString() {
            return "SumLength{" +
                    "sum=" + sum +
                    ", length=" + length +
                    ", record=" + (record != null ? Arrays.toString(record.toArray()) : "[]") +
                    '}';
        }
    }

    // region 优化后
    // 参考 https://leetcode.com/problems/split-array-with-same-average/discuss/486095/Java-Backtrack-Solution-Beats-99.67-Using-Same-Idea-in-Subsets-II
    // 几个点之前没有想到：
    // 1. 如果两个子数组的平均值相等，其值一定等于整个数组的平均值
    // 2. 按挑选出 i 个数字的方式遍历，而且可以通过 平均值 * i 是否接近一个整数值过滤掉不可能的数量
    // 3. 递归的方式在一个数组 A[] 中从 startIndex 开始找出 n 个数字满足其和 == target
    public boolean splitArraySameAverage(int[] A) {
        if (A == null || A.length <= 1) {
            return false;
        }
        int sum = sum(A);
        double average = sum * 1f / A.length;
        int length = (A.length + 1) / 2;
        for (int i = 1; i <= length; i++) {
            // 检查取 i 个数字与平均值乘积结果是否接近整数，如果不是则跳过
            double realSum = average * i;
            int roundSum = (int) Math.round(realSum);
            if (Math.abs(realSum - roundSum) > 0.001) {
                continue;
            }

            if (traverse(A, i, roundSum, 0)) {
                return true;
            }
        }
        return false;
    }

    // 从 A[] 的 start 下标开始找出 num 个数，满足它们的和 == target
    private boolean traverse(int[] A, int num, int target, int start) {
        if (num == 0 && target == 0) {
            return true;
        }
        if (num == 0) {
            return false;
        }
        for (int i = start; i <= A.length - num; i++) {
            if (traverse(A, num - 1, target - A[i], i + 1)) {
                return true;
            }
            while (i < A.length - num && A[i] == A[i + 1]) { // 过滤掉相同的
                i++;
            }
        }
        return false;
    }


    private int sum(int[] A) {
        int sum = 0;
        for (int i = 0; i < A.length; i++) {
            sum += A[i];
        }
        return sum;
    }

    // endregion


    public static void main(String[] args) {
//        int [] testArray = {1, 2, 3, 4, 5, 6, 7, 8};
//        int[] testArray = {6, 8, 18, 3, 1};
//        int[] testArray = {18, 0, 16, 2};
//        int[] testArray = {0};
        int[] testArray = {12, 1, 17, 8, 2};
//        int[] testArray = {60, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30,
//                30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30};
        SplitArrayWithSameAverage solution = new SplitArrayWithSameAverage();
        System.out.println(solution.splitArraySameAverage(testArray));
    }
}
