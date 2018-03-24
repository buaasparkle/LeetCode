package fun.sure.leetcode.medium;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by sure on 2018/3/23.
 */

public class PartitionLabels {

    /**
     * A string S of lowercase letters is given. We want to partition this string into as many parts as possible so that each letter appears in at most one part, and return a list of integers representing the size of these parts.

     Example 1:
     Input: S = "ababcbacadefegdehijhklij"
     Output: [9,7,8]
     Explanation:
     The partition is "ababcbaca", "defegde", "hijhklij".
     This is a partition so that each letter appears in at most one part.
     A partition like "ababcbacadefegde", "hijhklij" is incorrect, because it splits S into less parts.
     Note:

     S will have length in range [1, 500].
     S will consist of lowercase letters ('a' to 'z') only.
     */

    // 1. 找到每个char的left - right
    // 2. 对所有 char 归并
    //    步骤：两两合并, 如果有交集，去两头，否则不合并
    //    例子：a:[0,8], b:[1-5] 合并后为： ab:[0-8]
    public List<Integer> partitionLabels(String S) {
        List<Integer> partitionList = new ArrayList<>();

        // 1. build letter range map
        Map<String, Range> rangeMap = new LinkedHashMap<>();
        for (int i = 0; i < S.length(); i++) {
            String letter = String.valueOf(S.charAt(i));
            if (!rangeMap.containsKey(letter)) {
                Range range = new Range(i, i);
                rangeMap.put(String.valueOf(letter), range);
            } else {
                rangeMap.get(letter).setEnd(i);
            }
        }
        // 2. merge
        if (rangeMap.size() == 1) {
            partitionList.add(S.length());
        } else {
            while (true) {
                Iterator<Map.Entry<String, Range>> it = rangeMap.entrySet().iterator();
                if (!it.hasNext()) {
                    break;
                }
                Range targetRange = it.next().getValue();
                it.remove();
                while (it.hasNext()) {
                    Range range = it.next().getValue();
                    if (isIntersect(targetRange, range)) {
                        targetRange.setStart(Math.min(targetRange.start, range.start));
                        targetRange.setEnd(Math.max(targetRange.end, range.end));
                        it.remove();
                    }
                }
                partitionList.add(targetRange.length());
            }
        }
        return partitionList;
    }

    private boolean isIntersect(Range a, Range b) {
        return !(a.start > b.end || b.start > a.end);
    }

    /**
     * Range
     */
    private static class Range {
        int start;
        int end;

        Range(int start, int end) {
            this.start = start;
            this.end = end;
        }

        void setStart(int start) {
            this.start = start;
        }

        void setEnd(int end) {
            this.end = end;
        }

        int length() {
            return end - start + 1;
        }

        @Override
        public String toString() {
            return String.format("(%d, %d)", start, end);
        }
    }

    public static void main(String[] args) {
        String S = "ababcbacadefegdehijhklij";
        List<Integer> partitionList = new PartitionLabels().partitionLabels(S);
        System.out.print(partitionList.toString());
    }
}
