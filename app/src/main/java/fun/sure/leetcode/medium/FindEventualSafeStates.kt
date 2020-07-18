package `fun`.sure.leetcode.medium

/**
 * Created by wangshuo on 2020/7/18.
 */
class FindEventualSafeStates {

    /**
     * In a directed graph, we start at some node and every turn, walk along a directed edge of the graph.  If we reach a node that is terminal (that is, it has no outgoing directed edges), we stop.

    Now, say our starting node is eventually safe if and only if we must eventually walk to a terminal node.  More specifically, there exists a natural number K so that for any choice of where to walk, we must have stopped at a terminal node in less than K steps.

    Which nodes are eventually safe?  Return them as an array in sorted order.

    The directed graph has N nodes with labels 0, 1, ..., N-1, where N is the length of graph.  The graph is given in the following form: graph[i] is a list of labels j such that (i, j) is a directed edge of the graph.

    Example:
    Input: graph = [[1,2],[2,3],[5],[0],[5],[],[]]
    Output: [2,4,5,6]
    Here is a diagram of the above graph.

    Illustration of graph

    Note:

    graph will have length at most 10000.
    The number of edges in the graph will not exceed 32000.
    Each graph[i] will be a sorted list of different integers, chosen within the range [0, graph.length - 1].
     */

    /*
     * 思考：
     * 最终可达表明路径中完全无环，但凡有环的节点都不可达
     * 如果形成环，那么环内所有节点都不会在结果中
     *
     * 实现：
     * 变相找环，剩下的按顺序就是结果
     * DFS
     */

    /*
     * Success
     *
     * Runtime: 952 ms, faster than 14.29% of Kotlin online submissions for Find Eventual Safe States.
     * Memory Usage: 98.1 MB, less than 33.33% of Kotlin online submissions for Find Eventual Safe States.
     */

    // <Index, Res>
    enum class Reachable {
        UNKNOWN,
        YES,
        NO
    }

    private val reachableFlags = mutableListOf<Reachable>()

    fun eventualSafeNodes(graph: Array<IntArray>): List<Int> {
        initMap(graph)
        val res = mutableListOf<Int>()
        val visitArray = IntArray(graph.size) { 0 }
        for (index in graph.indices) {
            if (dfsGraph(graph, index, index, visitArray)) {
                res.add(index)
            }
        }
        return res
    }

    private fun initMap(graph: Array<IntArray>) {
        graph.forEachIndexed { index, labels ->
            reachableFlags.add(index, if (labels.isEmpty()) {
                Reachable.YES
            } else {
                Reachable.UNKNOWN
            })
        }
    }

    private fun dfsGraph(graph: Array<IntArray>, index: Int, startIndex: Int, visitArray: IntArray): Boolean {
        // 走到已知结果节点，后面也不用再走了
        if (reachableFlags[index] == Reachable.YES) {
            return true
        }
        if (visited(visitArray, index)) {
            // 已访问过，标记为不可达
            reachableFlags[index] = Reachable.NO
            return false
        }
        visitArray[index] = 1
        val labels = graph[index]
        labels.forEach {
            if (!dfsGraph(graph, it, startIndex, visitArray)) {
                reachableFlags[index] = Reachable.NO
                return false
            }
        }
        reachableFlags[index] = Reachable.YES
        return true
    }

    private fun visited(visitArray: IntArray, index: Int): Boolean {
        return visitArray[index] == 1
    }

}