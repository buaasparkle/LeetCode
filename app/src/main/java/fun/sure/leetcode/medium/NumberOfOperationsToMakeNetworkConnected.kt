package `fun`.sure.leetcode.medium

/**
 * Created by wangshuo on 2020/9/5.
 */
class NumberOfOperationsToMakeNetworkConnected {

    /**
     * https://leetcode.com/problems/number-of-operations-to-make-network-connected/
     *
     * There are n computers numbered from 0 to n-1 connected by ethernet cables connections
     * forming a network where connections[i] = [a, b] represents a connection between computers a and b.
     * Any computer can reach any other computer directly or indirectly through the network.

    Given an initial computer network connections. You can extract certain cables between two directly connected computers,
    and place them between any pair of disconnected computers to make them directly connected.
    Return the minimum number of times you need to do this in order to make all the computers connected.
    If it's not possible, return -1.



    Example 1:



    Input: n = 4, connections = [[0,1],[0,2],[1,2]]
    Output: 1
    Explanation: Remove cable between computer 1 and 2 and place between computers 1 and 3.
    Example 2:



    Input: n = 6, connections = [[0,1],[0,2],[0,3],[1,2],[1,3]]
    Output: 2
    Example 3:

    Input: n = 6, connections = [[0,1],[0,2],[0,3],[1,2]]
    Output: -1
    Explanation: There are not enough cables.
    Example 4:

    Input: n = 5, connections = [[0,1],[0,2],[3,4],[2,3]]
    Output: 0


    Constraints:

    1 <= n <= 10^5
    1 <= connections.length <= min(n*(n-1)/2, 10^5)
    connections[i].length == 2
    0 <= connections[i][0], connections[i][1] < n
    connections[i][0] != connections[i][1]
    There are no repeated connections.
    No two computers are connected by more than one cable.
     */

    /*
     *  思路：
     *  1. 找出联通的集群数 M，以及集合内联通的边数 E
     *  2. 找出孤立的节点数，假如有 N 个，则需要 N - 1 个边将这些点联通
     *  3. 已联通的集群 M 与 新组建的孤立节点集群全部相连需要 M 个边 （相当于有 M + 1 个集群）
     *  4. 总需要 M + N - 1 条边，冗余的边为每个集群内 E - （节点数 - 1）
     *  5. 若没有孤立节点返回 0；若所需 > 冗余总数，返回 -1；否则返回 M + N - 1
     *
     *  对于联通集群的处理：
     *  1. 构建集合包含联通边的两端，如果集合中不包含连接两端的任意一个，则两端组成新的集合
     *  2. 记录集合包含的边，如果融入结合，+1；否则，新建集合边数初始化为 1
     */

    /**
     * Success
     * Details
     * Runtime: 3548 ms, faster than 25.00% of Kotlin online submissions for Number of Operations to Make Network Connected.
     * Memory Usage: 71.2 MB, less than 100.00% of Kotlin online submissions for Number of Operations to Make Network Connected.
     */
    fun makeConnected(n: Int, connections: Array<IntArray>): Int {
        val setCountList = connectedSetCount(connections)
        val totalSet = (0 until n).toMutableSet()
        val soloSet = setCountList.map { it.set }
                .fold(totalSet, { acc, mutableSet -> (acc - mutableSet) as MutableSet<Int> })
        val soloCount = if (soloSet.isNotEmpty()) { soloSet.size } else return 0
        val extraCount = setCountList.fold(0, { acc, setCount -> acc + setCount.count - (setCount.set.size - 1) })
        val needCount = setCountList.size + soloCount - 1
        return if (extraCount >= needCount) needCount else -1
    }

    private fun connectedSetCount(connections: Array<IntArray>): Set<SetCount> {
        val setCountSet = mutableSetOf<SetCount>()
        connections.forEach { conn ->
            val setCount = setCountSet.find { it.set.contains(conn[0]) || it.set.contains(conn[1]) }
                    ?: SetCount().also { setCountSet.add(it) }
            setCount.set.addAll(conn.asList())
            setCount.count++
        }
        return mergeSet(setCountSet)
    }

    // 需要将集合中包含的部分 merge 为新的集合
    private fun mergeSet(setCountSet: Set<SetCount>): Set<SetCount> {
        var list = setCountSet.toMutableList()
        val mergedSet = mutableSetOf<SetCount>()
        var lastSetSize = -1
        while (list.size != lastSetSize) {
            lastSetSize = list.size
            while (list.isNotEmpty()) {
                val setCount = list.removeAt(0)
                val it = list.iterator()
                while (it.hasNext()) {
                    val sc = it.next()
                    if (setCount.set.intersect(sc.set).isNotEmpty()) {
                        setCount.set.addAll(sc.set)
                        setCount.count += sc.count
                        it.remove()
                    }
                }
                mergedSet.add(setCount)
            }
            list = mergedSet.toMutableList()
            mergedSet.clear()
        }
        return list.toSet()
    }

    inner class SetCount(val set: MutableSet<Int> = mutableSetOf(), var count: Int = 0)
}