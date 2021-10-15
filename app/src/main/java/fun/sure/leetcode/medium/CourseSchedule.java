package fun.sure.leetcode.medium;

import java.util.HashSet;
import java.util.Set;

import fun.sure.leetcode.Topics;

/**
 * Created by wangshuo on 2021/10/15.
 */
class CourseSchedule implements Topics.DFS, Topics.BFS, Topics.Graph, Topics.TopologicalSort {

    /**
     * There are a total of numCourses courses you have to take, labeled from 0 to numCourses - 1. You are given an array prerequisites where prerequisites[i] = [ai, bi] indicates that you must take course bi first if you want to take course ai.
     * <p>
     * For example, the pair [0, 1], indicates that to take course 0 you have to first take course 1.
     * Return true if you can finish all courses. Otherwise, return false.
     * <p>
     * <p>
     * <p>
     * Example 1:
     * <p>
     * Input: numCourses = 2, prerequisites = [[1,0]]
     * Output: true
     * Explanation: There are a total of 2 courses to take.
     * To take course 1 you should have finished course 0. So it is possible.
     * Example 2:
     * <p>
     * Input: numCourses = 2, prerequisites = [[1,0],[0,1]]
     * Output: false
     * Explanation: There are a total of 2 courses to take.
     * To take course 1 you should have finished course 0, and to take course 0 you should also have finished course 1. So it is impossible.
     * <p>
     * <p>
     * Constraints:
     * <p>
     * 1 <= numCourses <= 105
     * 0 <= prerequisites.length <= 5000
     * prerequisites[i].length == 2
     * 0 <= ai, bi < numCourses
     * All the pairs prerequisites[i] are unique.
     */

    /*
     * 思路： DFS
     *
     * 从入度为 0 的节点开始遍历
     * 如果拓扑图有环即表明无法完成
     * 最后全部可能可达即为成功
     */
    /*
    Success
    Runtime: 27 ms, faster than 9.97% of Java online submissions for Course Schedule.
    Memory Usage: 44.7 MB, less than 34.70% of Java online submissions for Course Schedule.
     */
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if (prerequisites == null || prerequisites.length == 0) {
            return true;
        }
        Boolean[] canFinishList = new Boolean[numCourses];
        HashSet<Integer> courseWithoutPrerequisiteSet = new HashSet<>();
        // 课程的入度数
        boolean[] courses = new boolean[numCourses];
        for (int i = 0; i < prerequisites.length; i++) {
            int c = prerequisites[i][0];
            if (c == prerequisites[i][1]) { // 漏了这个 case
                return false;
            }
            courses[c] = true;
        }
        for (int i = 0; i < numCourses; i++) {
            if (!courses[i]) {
                courseWithoutPrerequisiteSet.add(i);
            }
        }
        // 从没有入度的节点开始遍历, 漏掉这个
        if (!courseWithoutPrerequisiteSet.isEmpty()) {
            for (int course : courseWithoutPrerequisiteSet) {
                Set<Integer> visitedSet = new HashSet<>();
                if (!dfs(prerequisites, course, canFinishList, visitedSet)) {
                    return false;
                }
            }
            for (int i = 0; i < canFinishList.length; i++) {
                if (canFinishList[i] == null || !canFinishList[i]) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    private boolean dfs(int[][] prerequisites, int course, Boolean[] canFinishList, Set<Integer> visitedSet) {
        if (canFinishList[course] != null) {
            return canFinishList[course];
        }
        if (visitedSet.contains(course)) {
            canFinishList[course] = false;
            return false;
        }
        for (int i = 0; i < prerequisites.length; i++) {
            if (prerequisites[i][1] == course) {
                visitedSet.add(course);
                if (dfs(prerequisites, prerequisites[i][0], canFinishList, visitedSet)) {
                    visitedSet.remove(course); // 漏掉这步
                } else {
                    return false;
                }
            }
        }
        canFinishList[course] = true;
        return true;
    }
}
