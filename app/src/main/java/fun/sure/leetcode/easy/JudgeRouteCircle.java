package fun.sure.leetcode.easy;

/**
 * Created by sure on 2017/9/9.
 */

public class JudgeRouteCircle {

    /**
     * Initially, there is a Robot at position (0, 0). Given a sequence of its moves, judge if this
     * robot makes a circle, which means it moves back to the original place.

     The move sequence is represented by a string. And each move is represent by a character.
     The valid robot moves are R (Right), L (Left), U (Up) and D (down).
     The output should be true or false representing whether the robot makes a circle.

     Example 1:
     Input: "UD"
     Output: true

     Example 2:
     Input: "LL"
     Output: false
     */

    enum MOVE {
        UP('U', 1),
        DOWN('D', -1),
        LEFT('L', 1),
        RIGHT('R', -1);

        private char move;
        private int value;

        MOVE(char move, int value) {
            this.move = move;
            this.value = value;
        }

        static boolean isHorizontal(char move) {
            return move == 'l' || move == 'L' || move == 'r' || move == 'R';
        }

        static int getStepValue(char move) {
            for (MOVE m : values()) {
                if (m.move == move) {
                    return m.value;
                }
            }
            return 0;
        }
    }

    public boolean judgeCircle(String moves) {
        if (moves == null || moves.length() == 0) {
            return true;
        }
        int horizontalStep = 0;
        int verticalStep = 0;
        for (char c : moves.toCharArray()) {
            int step = MOVE.getStepValue(c);
            if (MOVE.isHorizontal(c)) {
                horizontalStep += step;
            } else {
                verticalStep += step;
            }
        }
        return horizontalStep == 0 && verticalStep == 0;
    }
}
