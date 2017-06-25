package fun.sure.leetcode.medium;

/**
 * Created by sure on 2017/6/24.
 */

public class BattleshipsInABoard {

    /**
     * Given an 2D board, count how many battleships are in it. The battleships are represented with 'X's, empty slots are represented with '.'s. You may assume the following rules:

     You receive a valid board, made of only battleships or empty slots.
     Battleships can only be placed horizontally or vertically. In other words, they can only be made of the shape 1xN (1 row, N columns) or Nx1 (N rows, 1 column), where N can be of
     any size. At least one horizontal or vertical cell separates between two battleships - there are no adjacent battleships.

     Example:
     X..X
     ...X
     ...X
     In the above board there are 2 battleships.

     Invalid Example:
     ...X
     XXXX
     ...X
     This is an invalid board that you will not receive - as battleships will always have a cell separating between them.

     Follow up:
     Could you do it in one-pass, using only O(1) extra memory and without modifying the value of the board?

     */

    public int countBattleships(char[][] board) {
        if (board == null || board.length == 0 || board[0].length == 0) {
            return 0;
        }
        int lenX = board.length;
        int lenY = board[0].length;
        int maxCount = 0;

        // 每行查看
        int count = 0;
        boolean preHasShips = false;
        boolean curHasShips = check(board, 0, 0, lenY, true);
        boolean nextHasShips = false;
        for (int i = 0; i < lenX - 1; i++) {
            nextHasShips = check(board, i + 1, 0, lenY, true);
            if (curHasShips && !preHasShips && !nextHasShips) {
                count++;
            }
            preHasShips = curHasShips;
            curHasShips = nextHasShips;
        }
        count += (curHasShips && !preHasShips) ? 1 : 0;
        maxCount = Math.max(maxCount, count);

        // 每列查看
        count = 0;
        preHasShips = false;
        curHasShips = check(board, 0, 0, lenX, false);
        nextHasShips = false;
        for (int i = 0; i < lenY - 1; i++) {
            nextHasShips = check(board, 0, i + 1, lenX, false);
            if (curHasShips && !preHasShips && !nextHasShips) {
                count++;
            }
            preHasShips = curHasShips;
            curHasShips = nextHasShips;
        }
        count += (curHasShips && !preHasShips) ? 1 : 0;
        maxCount = Math.max(maxCount, count);

        return maxCount;
    }

    private boolean check(char[][] board, int x, int y, int length, boolean horizontal) {
        for (int i = horizontal ? y : x; i < length; i++) {
            char cur = horizontal ? board[x][i] : board[i][y];
            if (cur == 'X') {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        char[][] board = {
                {'X', '.' , '.', 'X'},
        };
        System.out.print(new BattleshipsInABoard().countBattleships(board));
    }
}
