package fun.sure.leetcode.easy;

/**
 * Created by sure on 2017/10/17.
 */

public class BaseballGame {

    /**
     * You're now a baseball game point recorder.

     Given a list of strings, each string can be one of the 4 following types:

     Integer (one round's score): Directly represents the number of points you get in this round.
     "+" (one round's score): Represents that the points you get in this round are the sum of the last two valid round's points.
     "D" (one round's score): Represents that the points you get in this round are the doubled data of the last valid round's points.
     "C" (an operation, which isn't a round's score): Represents the last valid round's points you get were invalid and should be removed.
     Each round's operation is permanent and could have an impact on the round before and the round after.

     You need to return the sum of the points you could get in all the rounds.

     Example 1:
     Input: ["5","2","C","D","+"]
     Output: 30

     Explanation:
     Round 1: You could get 5 points. The sum is: 5.
     Round 2: You could get 2 points. The sum is: 7.
     Operation 1: The round 2's data was invalid. The sum is: 5.
     Round 3: You could get 10 points (the round 2's data has been removed). The sum is: 15.
     Round 4: You could get 5 + 10 = 15 points. The sum is: 30.

     Example 2:
     Input: ["5","-2","4","C","D","9","+","+"]
     Output: 27

     Explanation:
     Round 1: You could get 5 points. The sum is: 5.
     Round 2: You could get -2 points. The sum is: 3.
     Round 3: You could get 4 points. The sum is: 7.
     Operation 1: The round 3's data is invalid. The sum is: 3.
     Round 4: You could get -4 points (the round 3's data has been removed). The sum is: -1.
     Round 5: You could get 9 points. The sum is: 8.
     Round 6: You could get -4 + 9 = 5 points. The sum is 13.
     Round 7: You could get 9 + 5 = 14 points. The sum is 27.
     Note:
     The size of the input list will be between 1 and 1000.
     Every integer represented in the list will be between -30000 and 30000.
     */

    // [ACCEPTED]
    public int calPoints(String[] ops) {
        if (ops == null || ops.length == 0) {
            return 0;
        }
        int sum = 0;
        int[] values = new int[ops.length];
        boolean[] valids = new boolean[ops.length];

        for (int i = 0; i < ops.length; i++) {
            if ("C".equalsIgnoreCase(ops[i])) {
                valids[i] = false;
                for (int j = i - 1; j >= 0 ; j--) {
                    if (valids[j]) {
                        valids[j] = false;
                        sum -= values[j];
                        break;
                    }
                }
            } else if ("D".equalsIgnoreCase(ops[i])) {
                for (int j = i - 1; j >= 0 ; j--) {
                    if (valids[j]) {
                        values[i] = 2 * values[j];
                        valids[i] = true;
                        sum += values[i];
                        break;
                    }
                }
            } else if ("+".equals(ops[i])) {
                int value = 0;
                for (int j = i - 1; j >= 0 ; j--) {
                    if (value != 0 && valids[j]) {
                        value += values[j];
                        values[i] = value;
                        valids[i] = true;
                        sum += values[i];
                        break;
                    } else if (valids[j]) {
                        value = values[j];
                    }
                }
            } else {
                values[i] = Integer.valueOf(ops[i]);
                valids[i] = true;
                sum += values[i];
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        String[] ops = new String[]{
//                "5", "2", "C", "D", "+"
                "5","-2","4","C","D","9","+","+"
        };
        System.out.print(new BaseballGame().calPoints(ops));
    }
}
