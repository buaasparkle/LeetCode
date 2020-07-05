package fun.sure.leetcode.medium;

import android.os.Build;
import android.support.annotation.RequiresApi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by wangshuo on 2020/6/24.
 */
class MatchsticksToSquare {

    /**
     * Remember the story of Little Match Girl? By now, you know exactly what matchsticks the little match girl has, please find out a way you can make one square by using up all those matchsticks. You should not break any stick, but you can link them up, and each matchstick must be used exactly one time.
     *
     * Your input will be several matchsticks the girl has, represented with their stick length. Your output will either be true or false, to represent whether you could make one square using all the matchsticks the little match girl has.
     *
     * Example 1:
     * Input: [1,1,2,2,2]
     * Output: true
     *
     * Explanation: You can form a square with length 2, one side of the square came two sticks with length 1.
     *
     * Example 2:
     * Input: [3,3,3,3,4]
     * Output: false
     *
     * Explanation: You cannot find a way to form a square with all the matchsticks.
     *
     * Note:
     * The length sum of the given matchsticks is in the range of 0 to 10^9.
     * The length of the given matchstick array will not exceed 15.
     */

    public boolean makesquare(int[] nums) {
        if (nums == null || nums.length == 0) {
            return false;
        }
        long perimeter = perimeterOfSticks(nums);
        if (perimeter % 4 != 0) { // 不能被 4 整除
            return false;
        }
        long sideLength = perimeter / 4;

        if (hasLargerOneThanSide(nums, sideLength)) { // 有比边长还长的
            return false;
        }
        List<Integer> sortedNums = toSortedList(nums);
        return dfs(sortedNums, new int[4], 0, sideLength);
    }

    private long perimeterOfSticks(int[] nums) {
        long sum = 0;
        for (int num : nums) {
            sum += num;
        }
        return sum;
    }

    private boolean hasLargerOneThanSide(int[] nums, long sideLength) {
        for (int num : nums) {
            if (num > sideLength) {
                return true;
            }
        }
        return false;
    }

    private List<Integer> toSortedList(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for (int num : nums) {
            list.add(num);
        }
        Collections.sort(list);
        Collections.reverse(list);
        return list;
    }

    // 从数组中找出和是 target 的数字组合
    private boolean findTargetSum(List<Integer> sortedNums, List<Integer> resIndexes, long target, long curSum, int startIndex) {
        for (int i = startIndex; i < sortedNums.size(); i++) {
            int val = sortedNums.get(i);
            long sum = curSum + val;
            if (sum == target) {
                resIndexes.add(i);
                return true;
            } else if (sum < target) {
                resIndexes.add(i);
                curSum += val;
                boolean find = findTargetSum(sortedNums, resIndexes, target, curSum, i + 1);
                if (find) {
                    return true;
                } else {
                    resIndexes.remove(resIndexes.size() - 1);
                    curSum -= val;
                }
            } else {
                break;
            }
        }
        return false;
    }

    private boolean findMatchedSide(List<Integer> sortedNums, long target) {
        List<Integer> sticks = new ArrayList<>(sortedNums);
        for (int j = 0; j < sortedNums.size(); j++) {
            for (int i = 0; i < 4; i++) {
                List<Integer> resList = new ArrayList<>();
                if (findTargetSum(sticks, resList, target, 0, j)) {
                    removeAllExactly(sticks, resList);
                } else {
                    break;
                }
            }
            if (sticks.isEmpty()) {
                return true;
            }
        }
        return false;
    }

    private void removeAllExactly(List<Integer> allList, List<Integer> indexList) {
        for (int i = indexList.size() - 1; i >= 0; i--) {
            int idx = indexList.get(i);
            allList.remove(idx);
        }
    }

    // Copy Solution
    public boolean dfs(List<Integer> nums, int[] sums, int index, long target) {
        // If we have exhausted all our matchsticks, check if all sides of the square are of equal length
        if (index == nums.size()) {
            return sums[0] == sums[1] && sums[1] == sums[2] && sums[2] == sums[3];
        }

        // Get current matchstick.
        int element = nums.get(index);

        // Try adding it to each of the 4 sides (if possible)
        for(int i = 0; i < 4; i++) {
            if (sums[i] + element <= target) {
                sums[i] += element;
                if (dfs(nums, sums, index + 1, target)) {
                    return true;
                }
                sums[i] -= element;
            }
        }

        return false;
    }

    /*
    public List<Integer> nums;
    public int[] sums;
    public int possibleSquareSide;

    public MatchsticksToSquare() {
        this.sums = new int[4];
    }

    // Depth First Search function.
    public boolean dfs(int index) {

        // If we have exhausted all our matchsticks, check if all sides of the square are of equal length
        if (index == this.nums.size()) {
            return sums[0] == sums[1] && sums[1] == sums[2] && sums[2] == sums[3];
        }

        // Get current matchstick.
        int element = this.nums.get(index);

        // Try adding it to each of the 4 sides (if possible)
        for(int i = 0; i < 4; i++) {
            if (this.sums[i] + element <= this.possibleSquareSide) {
                this.sums[i] += element;
                if (this.dfs(index + 1)) {
                    return true;
                }
                this.sums[i] -= element;
            }
        }

        return false;
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public boolean makesquare(int[] nums) {
        // Empty matchsticks.
        if (nums == null || nums.length == 0) {
            return false;
        }

        // Find the perimeter of the square (if at all possible)
        int L = nums.length;
        int perimeter = 0;
        for(int i = 0; i < L; i++) {
            perimeter += nums[i];
        }

        this.possibleSquareSide =  perimeter / 4;
        if (this.possibleSquareSide * 4 != perimeter) {
            return false;
        }

        // Convert the array of primitive int to ArrayList (for sorting).
        this.nums = Arrays.stream(nums).boxed().collect(Collectors.toList());
        Collections.sort(this.nums, Collections.reverseOrder());
        return this.dfs(0);
    }

     */
}
