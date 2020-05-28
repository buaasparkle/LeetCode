package fun.sure.leetcode.medium;
/**
 * Date: 2020-05-28
 */

/* 
Question:

You are given two strings s and t of the same length. You want to change s to t. Changing the i-th character of s to i-th character of t costs |s[i] - t[i]| that is, the absolute difference between the ASCII values of the characters.

You are also given an integer maxCost.

Return the maximum length of a substring of s that can be changed to be the same as the corresponding substring of twith a cost less than or equal to maxCost.

If there is no substring from s that can be changed to its corresponding substring from t, return 0.

Example 1:

Input: s = "abcd", t = "bcdf", maxCost = 3
Output: 3
Explanation: "abc" of s can change to "bcd". That costs 3, so the maximum length is 3.
Example 2:

Input: s = "abcd", t = "cdef", maxCost = 3
Output: 1
Explanation: Each character in s costs 2 to change to charactor in t, so the maximum length is 1.
Example 3:

Input: s = "abcd", t = "acde", maxCost = 0
Output: 1
Explanation: You can't make any change, so the maximum length is 1.
 

Constraints:

1 <= s.length, t.length <= 10^5
0 <= maxCost <= 10^6
s and t only contain lower case English letters.
*/

/**
 * Solution:

 1. 逐位计算 dist，放到一个数组里
 2. 数组从小到大排序
 3. reduce 数组直到和小于等于 maxCost, 如果没有符合要求的返回 0

 */

public class GetEqualSubstringsWithinBudget {
    
    public int equalSubstringX(String s, String t, int maxCost) {
        int length = s.length();
        int[] costs = new int[length];
        for (int i = 0; i < length; i++) {
            costs[i] = Math.abs(s.charAt(i) - t.charAt(i));
        }
        int max = 0;
        int sum;
        for (int i = 0; i < length; i++) {
            sum = 0;
            int j = i;
            for (; j < length; j++) {
                if (sum + costs[j] > maxCost) {
                    break;
                }
                sum += costs[j];
            }
            max = Math.max(max, j - i);
        }
        return max;
    }

    // 滑动窗口方式
    public int equalSubstring(String s, String t, int maxCost) {
        int length = s.length();
        int[] costs = new int[length];
        for (int i = 0; i < length; i++) {
            costs[i] = getCost(s, t, i);
        }
        int left = 0;
        int right = 0;
        int max = 0;
        int sum = 0;
        for (; right < length; right++) {
            sum += costs[right];
            if (sum > maxCost) {
                max = Math.max(right - left, max);
                while (sum > maxCost) {
                    sum -= getCost(s, t, left);
                    left++;
                }
            }
        }
        max = Math.max(right - left, max);
        return max;
    }

    private int getCost(String s, String t, int index) {
        return Math.abs(s.charAt(index) - t.charAt(index));
    }

    public static void main(String[] args) {
        System.out.println(new GetEqualSubstringsWithinBudget().equalSubstring("krrgw", "zjxss", 19));
        System.out.println(new GetEqualSubstringsWithinBudget().equalSubstring("abcd", "bcdf", 3));
        System.out.println(new GetEqualSubstringsWithinBudget().equalSubstring("abcd", "cdef", 3));
        System.out.println(new GetEqualSubstringsWithinBudget().equalSubstring("abcd", "acde", 0));
        System.out.println(new GetEqualSubstringsWithinBudget().equalSubstring("krpgjbjjznpzdfy", "nxargkbydxmsgby", 14));
    }
}

