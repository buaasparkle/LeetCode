package fun.sure.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sure on 2018/3/22.
 */

public class AllPathsFromSource2Target {

    /**
     * Given a directed, acyclic graph of N nodes.  Find all possible paths from node 0 to node N-1, and return them in any order.

     The graph is given as follows:  the nodes are 0, 1, ..., graph.length - 1.  graph[i] is a list of all nodes j for which the edge (i, j) exists.

     Example:
     Input: [[1,2], [3], [3], []]
     Output: [[0,1,3],[0,2,3]]
     Explanation: The graph looks like this:
     0--->1
     |    |
     v    v
     2--->3
     There are two paths: 0 -> 1 -> 3 and 0 -> 2 -> 3.
     Note:

     The number of nodes in the graph will be in the range [2, 15].
     You can print different paths in any order, but you should keep the order of nodes inside one path.
     */

    // [PASS]
    private List<List<Integer>> allPaths = new ArrayList<>();

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<Integer> pathList = new ArrayList<>();
        pathList.add(0);
        traversalGraph(graph, pathList, 0);
        return allPaths;
    }

    private void traversalGraph(int[][] graph, List<Integer> path, int nodeIndex) {
        if (nodeIndex == graph.length - 1) {
            List<Integer> validPath = new ArrayList<>();
            validPath.addAll(path);
            allPaths.add(validPath);
            return;
        }
        int[] nodes = graph[nodeIndex];
        if (nodes == null || nodes.length == 0) {
            return;
        }
        for (int node : nodes) {
            path.add(Integer.valueOf(node));
            traversalGraph(graph, path, node);
            path.remove(Integer.valueOf(node));
        }
    }

    public static void main(String[] args) {
        int[][] graph = new int[][] {
                {1, 2},
                {3},
                {3},
                {}
        };
        List<List<Integer>> allPaths = new AllPathsFromSource2Target().allPathsSourceTarget(graph);
        System.out.print(allPaths.toString());
    }
}
