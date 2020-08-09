package `fun`.sure.leetcode.easy

/**
 * Created by wangshuo on 2020/8/9.
 */
class KthLargest(private val k: Int, private val nums: IntArray) {

    /**
     * Design a class to find the kth largest element in a stream. Note that it is the kth largest element in the sorted order, not the kth distinct element.

    Your KthLargest class will have a constructor which accepts an integer k and an integer array nums, which contains initial elements from the stream. For each call to the method KthLargest.add, return the element representing the kth largest element in the stream.

    Example:

    int k = 3;
    int[] arr = [4,5,8,2];
    KthLargest kthLargest = new KthLargest(3, arr);
    kthLargest.add(3);   // returns 4
    kthLargest.add(5);   // returns 5
    kthLargest.add(10);  // returns 5
    kthLargest.add(9);   // returns 8
    kthLargest.add(4);   // returns 8
    Note:
    You may assume that nums' length ≥ k-1 and k ≥ 1.
     */

    /**
     * Success
     * Runtime: 532 ms, faster than 54.55% of Kotlin online submissions for Kth Largest Element in a Stream.
     * Memory Usage: 63.4 MB, less than 9.09% of Kotlin online submissions for Kth Largest Element in a Stream.
     */

    // 维护一个长度为 K 的最小堆, 只维护最大的 K 个数，根值为第 K 大
    private val kthHeap = ArrayList<Int>(k)

    init {
        setupKthHeap()
    }

    private fun setupKthHeap() {
        nums.forEach { insertToHeap(it) }
    }

    // 返回值表示是否入堆
    private fun insertToHeap(value: Int) {
        when {
            kthHeap.size < k -> { // 堆未满，直接插入
                kthHeap.add(value)
                shiftUp()
            }
            value > kthHeap.first() -> { // 大于堆的最小值，替换掉最小值从上向下调整堆
                kthHeap[0] = value
                shiftDown()
            }
            else -> { // 堆已满且比最大值还大，忽略处理
                // no op
            }
        }
    }

    // 更新最后一个元素在堆中的位置
    private fun shiftUp() {
        var curIndex = kthHeap.size - 1
        var parentIndex = (curIndex - 1) / 2
        while (parentIndex >= 0 && kthHeap[curIndex] < kthHeap[parentIndex]) {
            swap(curIndex, parentIndex)
            curIndex = parentIndex
            parentIndex = (curIndex - 1) / 2
        }
    }

    // 更新第一个元素在堆中的位置
    private fun shiftDown() {
        var curIndex = 0
        var maxChild = findMinChild(curIndex)
        while (maxChild != null && kthHeap[curIndex] > maxChild.first) {
            swap(curIndex, maxChild.second)
            curIndex = maxChild.second
            maxChild = findMinChild(curIndex)
        }
    }

    private fun swap(i: Int, j: Int) {
        val temp = kthHeap[i]
        kthHeap[i] = kthHeap[j]
        kthHeap[j] = temp
    }

    private fun findMinChild(index: Int): Pair<Int, Int>? { // <MinValue, index>
        val leftChildIndex = index * 2 + 1
        val rightChildIndex = index * 2 + 2
        return when {
            leftChildIndex >= kthHeap.size -> null
            rightChildIndex >= kthHeap.size -> Pair(kthHeap[leftChildIndex], leftChildIndex)
            else -> {
                val isLeft = kthHeap[leftChildIndex] < kthHeap[rightChildIndex]
                val minValueIndex = if (isLeft) leftChildIndex else rightChildIndex
                Pair(kthHeap[minValueIndex], minValueIndex)
            }
        }
    }

    fun add(value: Int): Int {
        insertToHeap(value)
        return kthHeap[0]
    }
}
