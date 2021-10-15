package fun.sure.leetcode.medium;

import android.util.Pair;
import android.widget.ArrayAdapter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import fun.sure.leetcode.Topics;

/**
 * Created by wangshuo on 2021/10/15.
 */
class CourseScheduleII implements Topics.DFS, Topics.BFS, Topics.Graph, Topics.TopologicalSort {
    /**
     * There are a total of numCourses courses you have to take, labeled from 0 to numCourses - 1. You are given an array prerequisites where prerequisites[i] = [ai, bi] indicates that you must take course bi first if you want to take course ai.
     * <p>
     * For example, the pair [0, 1], indicates that to take course 0 you have to first take course 1.
     * Return the ordering of courses you should take to finish all courses. If there are many valid answers, return any of them. If it is impossible to finish all courses, return an empty array.
     * <p>
     * <p>
     * <p>
     * Example 1:
     * <p>
     * Input: numCourses = 2, prerequisites = [[1,0]]
     * Output: [0,1]
     * Explanation: There are a total of 2 courses to take. To take course 1 you should have finished course 0. So the correct course order is [0,1].
     * Example 2:
     * <p>
     * Input: numCourses = 4, prerequisites = [[1,0],[2,0],[3,1],[3,2]]
     * Output: [0,2,1,3]
     * Explanation: There are a total of 4 courses to take. To take course 3 you should have finished both courses 1 and 2. Both courses 1 and 2 should be taken after you finished course 0.
     * So one correct course order is [0,1,2,3]. Another correct ordering is [0,2,1,3].
     * Example 3:
     * <p>
     * Input: numCourses = 1, prerequisites = []
     * Output: [0]
     */

    /*
     * 思路：BFS
     *
     * 基于 I 中的 DFS 没想到怎么处理入度 > 1 的情况如何遍历，所有改成 BFS 的方式
     * 保存了两个 Map 方便做依赖关系的更新
     /

    /*
    Success
    Runtime: 58 ms, faster than 5.04% of Java online submissions for Course Schedule II.
    Memory Usage: 66.7 MB, less than 5.09% of Java online submissions for Course Schedule II.
     */
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] emptyResult = new int[0];
        int[] result = new int[numCourses];
        if (prerequisites == null || prerequisites.length == 0) {
            for (int i = 0; i < numCourses; i++) {
                result[i] = i;
            }
            return result;
        }
        // build map
        HashMap<Integer, List<Integer>> preMap = new HashMap<>();
        HashMap<Integer, List<Integer>> postMap = new HashMap<>();
        for (int i = 0; i < prerequisites.length; i++) {
            int cur = prerequisites[i][0];
            int pre = prerequisites[i][1];
            if (!preMap.containsKey(cur)) {
                preMap.put(cur, new ArrayList<>());
            }
            preMap.get(cur).add(pre);
            if (!postMap.containsKey(pre)) {
                postMap.put(pre, new ArrayList<>());
            }
            postMap.get(pre).add(cur);
        }
        List<Integer> learnPath = new ArrayList<>();
        boolean[] learned = new boolean[numCourses];
        bfs(numCourses, preMap, postMap, learnPath, learned);
        if (allLearned(learned)) {
            return listToArray(learnPath);
        }
        return emptyResult;
    }

    void bfs(int numCourses,
             HashMap<Integer, List<Integer>> preMap,
             HashMap<Integer, List<Integer>> postMap,
             List<Integer> learnPath,
             boolean[] learned) {
        // 找入度为 0 的 课程
        List<Integer> courseCouldLearnList = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            if (learned[i]) {
                continue;
            }
            if (!preMap.containsKey(i)) {
                courseCouldLearnList.add(i);
                learnPath.add(i);
                learned[i] = true;
            }
        }
        if (courseCouldLearnList.isEmpty()) {
            return;
        }
        // 学习完，更新 map 以便下次遍历
        for (Integer course : courseCouldLearnList) {
            if (postMap.containsKey(course)) {
                for (Integer postCourse : postMap.get(course)) {
                    preMap.get(postCourse).remove(course);
                    if (preMap.get(postCourse).isEmpty()) {
                        preMap.remove(postCourse);
                    }
                }
                postMap.remove(course);
            }
        }
        bfs(numCourses, preMap, postMap, learnPath, learned);
    }

    private boolean allLearned(boolean[] learned) {
        for (int i = 0; i < learned.length; i++) {
            if (!learned[i]) {
                return false;
            }
        }
        return true;
    }

    private int[] listToArray(List<Integer> learnPath) {
        int[] ret = new int[learnPath.size()];
        for (int i = 0; i < ret.length; i++) {
            ret[i] = learnPath.get(i);
        }
        return ret;
    }
}
