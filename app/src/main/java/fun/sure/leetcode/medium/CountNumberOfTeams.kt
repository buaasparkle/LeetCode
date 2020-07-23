package `fun`.sure.leetcode.medium

/**
 * Created by wangshuo on 2020/7/23.
 */
class CountNumberOfTeams {

    /**
     * There are n soldiers standing in a line. Each soldier is assigned a unique rating value.

    You have to form a team of 3 soldiers amongst them under the following rules:

    Choose 3 soldiers with index (i, j, k) with rating (rating[i], rating[j], rating[k]).
    A team is valid if:  (rating[i] < rating[j] < rating[k]) or (rating[i] > rating[j] > rating[k]) where (0 <= i < j < k < n).
    Return the number of teams you can form given the conditions. (soldiers can be part of multiple teams).



    Example 1:

    Input: rating = [2,5,3,4,1]
    Output: 3
    Explanation: We can form three teams given the conditions. (2,3,4), (5,4,1), (5,3,1).
    Example 2:

    Input: rating = [2,1,3]
    Output: 0
    Explanation: We can't form any team given the conditions.
    Example 3:

    Input: rating = [1,2,3,4]
    Output: 4


    Constraints:

    n == rating.length
    1 <= n <= 200
    1 <= rating[i] <= 10^5
     */

    /*
     * 思路
     * 暴力法，首先计算每个 index 位置之前（大于/小于）当前值的个数
     * 然后双层循环遍历数组得到 3 个元素的单调序列个数
     * 时间复杂度 O(n2): 计算有序数组个数 n2, 最后遍历 n2, O(n2 + n2) = O(n2)
     */

    /*
     * Success
     * Details
     * Runtime: 352 ms, faster than 21.43% of Kotlin online submissions for Count Number of Teams.
     * Memory Usage: 52.7 MB, less than 25.00% of Kotlin online submissions for Count Number of Teams.
     */
    fun numTeams(rating: IntArray): Int {
        if (rating.size < 3) {
            return 0
        }
        val largerCountList = genOrderCountList(rating) { left, right -> left > right }
        val smallerCountList = genOrderCountList(rating) { left, right -> left < right }
        var numberOfTeams = 0
        for (i in 2 until rating.size) {
            for (j in 1 until i) {
                if (rating[i] > rating[j]) {
                    numberOfTeams += smallerCountList[j]
                } else if (rating[i] < rating[j]) {
                    numberOfTeams += largerCountList[j]
                }
            }
        }
        return numberOfTeams
    }

    // 返回一个 Int 数组，Int[i] 表示 index 从 0 开始到 i - 1 中，比 i 大/小的数字个数
    // 比如大于的情况 [1, 3, 2] -> [0, 0，1]
    private fun genOrderCountList(ratingArray: IntArray, predicate: (Int, Int) -> Boolean): List<Int> {
        val countArray = arrayListOf<Int>()
        ratingArray.forEachIndexed { index, rating ->
            countArray.add(ratingArray.sliceArray(0..index).filter { predicate(it, rating) }.size)
        }
        return countArray
    }

}