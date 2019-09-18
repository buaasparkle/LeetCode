package fun.sure.leetcode.easy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BinaryWatch {

    /**
     * A binary watch has 4 LEDs on the top which represent the hours (0-11), and the 6 LEDs on the bottom represent the minutes (0-59).
     *
     * Each LED represents a zero or one, with the least significant bit on the right.
     *
     * Given a non-negative integer n which represents the number of LEDs that are currently on, return all possible times the watch could represent.
     *
     * Example:
     *
     * Input: n = 1
     * Return: ["1:00", "2:00", "4:00", "8:00", "0:01", "0:02", "0:04", "0:08", "0:16", "0:32"]
     * Note:
     * The order of output does not matter.
     * The hour must not contain a leading zero, for example "01:00" is not valid, it should be "1:00".
     * The minute must be consist of two digits and may contain a leading zero, for example "10:2" is not valid, it should be "10:02".
     */

    // [AC]
    public List<String> readBinaryWatch(int num) {
        Map<Integer, List<String>> hourDic = new HashMap<>();
        Map<Integer, List<String>> minDic = new HashMap<>();
        buildHourMap(hourDic);
        buildMinMap(minDic);
        List<String> result = new ArrayList<>();
        int len = Math.min(num, 4);
        for (int i = 0; i <= len; i++) {
            List<String> hours = hourDic.get(i);
            List<String> mins = minDic.get(num - i);
            if (hours == null || mins == null) {
                continue;
            }
            for (String hour : hours) {
                for (String min : mins) {
                    result.add(String.format("%s:%s", hour, min));
                }
            }
        }
        return result;
    }

    private void buildHourMap(Map<Integer, List<String>> hourDic) {
        for (int i = 0; i < 12; i++) {
            int ones = numOfOnes(i);
            if (!hourDic.containsKey(ones)) {
                hourDic.put(ones, new ArrayList<String>());
            }
            hourDic.get(ones).add(String.valueOf(i));
        }
    }

    private void buildMinMap(Map<Integer, List<String>> minDic) {
        for (int i = 0; i < 60; i++) {
            int ones = numOfOnes(i);
            if (!minDic.containsKey(ones)) {
                minDic.put(ones, new ArrayList<String>());
            }
            minDic.get(ones).add(String.format("%02d", i));
        }
    }

    private int numOfOnes(int num) {
        int ones = 0;
        while (num > 0) {
            ones += num & 0x01;
            num >>= 1;
        }
        return ones;
    }

    public static void main(String[] args) {
        System.out.println(new BinaryWatch().readBinaryWatch(6));
    }
}
