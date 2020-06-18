package fun.sure.leetcode.hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by wangshuo on 2020/6/15.
 */
class ContainVirus {

    /**
     * A virus is spreading rapidly, and your task is to quarantine the infected area by installing walls.
     * <p>
     * The world is modeled as a 2-D array of cells, where 0 represents uninfected cells, and 1 represents cells contaminated with the virus. A wall (and only one wall) can be installed between any two 4-directionally adjacent cells, on the shared boundary.
     * <p>
     * Every night, the virus spreads to all neighboring cells in all four directions unless blocked by a wall. Resources are limited. Each day, you can install walls around only one region -- the affected area (continuous block of infected cells) that threatens the most uninfected cells the following night. There will never be a tie.
     * <p>
     * Can you save the day? If so, what is the number of walls required? If not, and the world becomes fully infected, return the number of walls used.
     * <p>
     * Example 1:
     * Input: grid =
     * [[0,1,0,0,0,0,0,1],
     * [0,1,0,0,0,0,0,1],
     * [0,0,0,0,0,0,0,1],
     * [0,0,0,0,0,0,0,0]]
     * Output: 10
     * Explanation:
     * There are 2 contaminated regions.
     * On the first day, add 5 walls to quarantine the viral region on the left. The board after the virus spreads is:
     * <p>
     * [[0,1,0,0,0,0,1,1],
     * [0,1,0,0,0,0,1,1],
     * [0,0,0,0,0,0,1,1],
     * [0,0,0,0,0,0,0,1]]
     * <p>
     * On the second day, add 5 walls to quarantine the viral region on the right. The virus is fully contained.
     * Example 2:
     * Input: grid =
     * [[1,1,1],
     * [1,0,1],
     * [1,1,1]]
     * Output: 4
     * Explanation: Even though there is only one cell saved, there are 4 walls built.
     * Notice that walls are only built on the shared boundary of two different cells.
     * Example 3:
     * Input: grid =
     * [[1,1,1,0,0,0,0,0,0],
     * [1,0,1,0,1,1,1,1,1],
     * [1,1,1,0,0,0,0,0,0]]
     * Output: 13
     * Explanation: The region on the left only builds two new walls.
     * Note:
     * The number of rows and columns of grid will each be in the range [1, 50].
     * Each grid[i][j] will be either 0 or 1.
     * Throughout the described process, there is always a contiguous viral region that will infect strictly more uncontaminated squares in the next round.
     */

    /**
     * PASS 但是时空效率不高
     *
     * Runtime: 105 ms, faster than 6.06% of Java online submissions for Contain Virus.
     * Memory Usage: 49 MB, less than 6.15% of Java online submissions for Contain Virus.
     */
    public int containVirus(int[][] grid) {
        FlagGrid controlledGrid = new FlagGrid(grid); // 表示已经被墙包围的区域，失去了感染活性
        Wall wall = new Wall(grid);
        while (true) {
            List<InfectedArea> infectedAreaList = queryInfectedAreas(grid, controlledGrid);
            if (tryControlMostDangerousArea(infectedAreaList, grid, controlledGrid, wall)) {
                break;
            }
        }

        return wall.count;
    }

    // 遍历 grid，找出已感染的连续区域
    public List<InfectedArea> queryInfectedAreas(int[][] grid, FlagGrid controlledGrid) {
        List<InfectedArea> infectedAreas = new ArrayList<>();
        int row = grid.length;
        int column = grid[0].length;
        FlagGrid visitGrid = new FlagGrid(grid); // 用于记录 Pos 是否访问过

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                // 如果之前没有访问过，同时又被感染了，新建一个 infectedArea 并深度优先搜索
                if (!visitGrid.isMarked(i, j) // 没有访问过
                        && !controlledGrid.isMarked(i, j) // 尚未失去活性
                        && Utils.isInfected(grid, i, j)) {
                    InfectedArea infectedArea = new InfectedArea();
                    visitGrid(grid, i, j, visitGrid, controlledGrid, infectedArea);
                    infectedAreas.add(infectedArea);
                }
            }
        }

        return infectedAreas;
    }

    private void visitGrid(int[][] grid, int i, int j, FlagGrid visitGrid, FlagGrid controlledGrid, InfectedArea infectedArea) {
        if (!Utils.checkValid(grid, i, j)) {
            return;
        }
        if (visitGrid.isMarked(i, j) || controlledGrid.isMarked(i, j)) {
            return;
        }
        visitGrid.mark(i, j);
        // 如果当前坐标 i，j 被感染，则查看他的四周是否被感染
        if (Utils.isInfected(grid, i, j)) {
            infectedArea.add(i, j);
            visitGrid(grid, i, j + 1, visitGrid, controlledGrid, infectedArea);
            visitGrid(grid, i + 1, j, visitGrid, controlledGrid, infectedArea);
            visitGrid(grid, i, j - 1, visitGrid, controlledGrid, infectedArea);
            visitGrid(grid, i - 1, j, visitGrid, controlledGrid, infectedArea);
        }
    }

    // 这个方法的副作用是修改了 grid 和 controlledGrid 的值
    // Grid 执行后变为除了最大风险区被控制，其余地区为实际一天后感染状态
    // controlledGrid 执行后变为加入标记了最大风险区
    // 返回值为 true 表示控制住了，否则还有新增的感染
    private boolean tryControlMostDangerousArea(List<InfectedArea> infectedAreaList, int[][] grid, FlagGrid controlledGrid, Wall wall) {
        int mostDangerousAreaIndex = -1;
        int maxAffectCount = 0;
        List<SimulateInfectedAreaAndWall> infectedAreaAndWalls = new ArrayList<>();
        for (int i = 0; i < infectedAreaList.size(); i++) {
            InfectedArea infectedArea = infectedAreaList.get(i);
            SimulateInfectedAreaAndWall infectedAreaAndWall = simulateInfectedAreaAfterOneDay(infectedArea, grid);
            if (infectedAreaAndWall.newInfectedArea.count() > maxAffectCount) {
                maxAffectCount = infectedAreaAndWall.newInfectedArea.count();
                mostDangerousAreaIndex = i;
            }
            infectedAreaAndWalls.add(infectedAreaAndWall);
        }

        // 说明感染控制住了，没有新增
        if (mostDangerousAreaIndex == -1) {
            return true;
        }
        // 需要将风险最高地区隔离
        SimulateInfectedAreaAndWall mostNewInfectedArea = infectedAreaAndWalls.remove(mostDangerousAreaIndex);
        isolateMostInfectedArea(mostNewInfectedArea, controlledGrid, wall);
        // 更新新感染区域
        if (!infectedAreaAndWalls.isEmpty()) {
            updateInfectedGrid(grid, infectedAreaAndWalls);
            return false;
        } else {
            return true;
        }
    }

    // 模拟一天之后的感染区域
    private SimulateInfectedAreaAndWall simulateInfectedAreaAfterOneDay(InfectedArea infectedArea, int[][] grid) {
        InfectedArea newInfectedArea = new InfectedArea();
        Wall wall = new Wall(grid);
        FlagGrid visitGrid = new FlagGrid(grid);
        for (Pos pos : infectedArea.area) {
            visitGrid.mark(pos.i, pos.j);
            if (checkInfected(grid, pos.i - 1, pos.j, visitGrid, newInfectedArea)) {
                wall.build(Wall.VERTICAL, pos.i - 1, pos.j);
            }
            if (checkInfected(grid, pos.i + 1, pos.j, visitGrid, newInfectedArea)) {
                wall.build(Wall.VERTICAL, pos.i, pos.j);
            }
            if (checkInfected(grid, pos.i, pos.j - 1, visitGrid, newInfectedArea)) {
                wall.build(Wall.HORIZONTAL, pos.i, pos.j - 1);
            }
            if (checkInfected(grid, pos.i, pos.j + 1, visitGrid, newInfectedArea)) {
                wall.build(Wall.HORIZONTAL, pos.i, pos.j);
            }
        }
        return new SimulateInfectedAreaAndWall(infectedArea, newInfectedArea, wall);
    }

    // 检查位置 i，j 是否感染，如果没有，加到待感染 area 中
    private boolean checkInfected(int[][] grid, int i, int j, FlagGrid visitGrid, InfectedArea area) {
        if (!Utils.checkValid(grid, i, j)) {
            return false;
        }
        if (area.contains(i, j)) {
            return true;
        }
        if (visitGrid.isMarked(i, j)) {
            return false;
        }
        visitGrid.mark(i, j);
        if (!Utils.isInfected(grid, i, j)) {
            area.add(i, j);
            return true;
        }
        return false;
    }

    private void isolateMostInfectedArea(SimulateInfectedAreaAndWall infectedAreaAndWall, FlagGrid controlledGrid, Wall wall) {
        // 标记已控制区域
        for (Pos pos : infectedAreaAndWall.infectedArea.area) {
            controlledGrid.mark(pos.i, pos.j);
        }
        // 更新建墙信息
        wall.mergeWall(infectedAreaAndWall.wall);
    }

    private void updateInfectedGrid(int[][] grid, List<SimulateInfectedAreaAndWall> infectedAreaAndWalls) {
        for (SimulateInfectedAreaAndWall areaAndWall : infectedAreaAndWalls) {
            for (Pos pos : areaAndWall.newInfectedArea.area) {
                grid[pos.i][pos.j] = 1;
            }
        }
    }

    // 记录感染区域
    public static class InfectedArea {
        private List<Pos> area; // Pair 中记录的分别为 (i, j) 坐标

        public InfectedArea() {
            this.area = new ArrayList<>();
        }

        public InfectedArea(List<Pos> area) {
            this.area = new ArrayList<>(area);
        }

        public void add(int i, int j) {
            area.add(new Pos(i, j));
        }

        public boolean contains(int i, int j) {
            for (Pos pos : area) {
                if (pos.i == i && pos.j == j) {
                    return true;
                }
            }
            return false;
        }

        public int count() {
            return area.size();
        }

        @Override
        public String toString() {
            return "InfectedArea{" +
                    "area=" + Arrays.toString(area.toArray()) +
                    '}';
        }
    }

    public static class Wall {
        private static final int ORIENTATION = 2;
        private static final int HORIZONTAL = 0;
        private static final int VERTICAL = 1;

        // 三维数组 [k][i][j]
        // k: 0 - 左右之间的墙， 1 - 上下之间的墙
        // i,j 即为单元格位置，如果是横向表示右边的墙，如果纵向表示下面的墙
        private int[][][] walls;
        private int row;
        private int column;
        private int count = 0;

        public Wall(int[][] grid) {
            this.row = grid.length;
            this.column = grid[0].length;
            walls = new int[ORIENTATION][row][column];
            for (int i = 0; i < ORIENTATION; i++) {
                for (int j = 0; j < row; j++) {
                    Arrays.fill(walls[i][j], 0);
                }
            }
        }

        public void build(int orientation, int i, int j) {
            if (isValid(orientation, i, j)) {
                // 因为向下向右算墙，所以边本来就是墙，不计入
                if (reachBorder(orientation, i, j)) {
                    return;
                }
                walls[orientation][i][j] = 1;
                count++;
            }
        }

        public void mergeWall(Wall wall) {
            for (int k = 0; k < ORIENTATION; k++) {
                for (int i = 0; i < row; i++) {
                    for (int j = 0; j < column; j++) {
                        if (wall.hasWall(k, i, j)) {
                            build(k, i, j);
                        }
                    }
                }
            }
        }

        public boolean hasWall(int orientation, int i, int j) {
            return isValid(orientation, i, j) &&
                    (reachBorder(orientation, i, j) || walls[orientation][i][j] == 1);
        }

        public int count() {
            return count;
        }

        private boolean reachBorder(int orientation, int i, int j) {
            return (orientation == VERTICAL && i == row - 1)
                    || (orientation == HORIZONTAL && j == column - 1);
        }

        private boolean isValid(int orientation, int i, int j) {
            return Utils.checkValid(row, column, i, j)
                    && (orientation == HORIZONTAL || orientation == VERTICAL);
        }
    }

    // 包装类，包含可能的新感染区域，以及可能的建墙位置
    private static class SimulateInfectedAreaAndWall {
        InfectedArea infectedArea;
        InfectedArea newInfectedArea;
        Wall wall;

        public SimulateInfectedAreaAndWall(InfectedArea infectedArea, InfectedArea newInfectedArea, Wall wall) {
            this.infectedArea = infectedArea;
            this.newInfectedArea = newInfectedArea;
            this.wall = wall;
        }
    }

    public static class FlagGrid {
        private int[][] grid;
        private int row;
        private int column;

        public FlagGrid(int[][] grid) {
            this(grid.length, grid[0].length);
        }

        public FlagGrid(int row, int column) {
            this.row = row;
            this.column = column;
            this.grid = new int[row][column];
            for (int i = 0; i < row; i++) {
                Arrays.fill(this.grid[i], 0);
            }
        }


        public void mark(int i, int j) {
            if (Utils.checkValid(grid, i, j)) {
                grid[i][j] = 1;
            }
        }

        public boolean isMarked(int i, int j) {
            return Utils.checkValid(grid, i, j) && grid[i][j] > 0;
        }
    }

    public static class Utils {
        public static boolean checkValid(int[][] grid, int i, int j) {
            return checkValid(grid.length, grid[0].length, i, j);
        }

        public static boolean checkValid(int row, int column, int i, int j) {
            return i >= 0 && i < row &&
                    j >= 0 && j < column;
        }

        public static boolean isInfected(int[][] grid, int i, int j) {
            return grid[i][j] == 1;
        }
    }

    public static class Pos {
        int i;
        int j;

        public Pos(int i, int j) {
            this.i = i;
            this.j = j;
        }

        @Override
        public String toString() {
            return "Pos{" +
                    "i=" + i +
                    ", j=" + j +
                    '}';
        }
    }
}
