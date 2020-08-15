package `fun`.sure.leetcode.medium

/**
 * Created by wangshuo on 2020/8/13.
 */
class KthLargestElementInAnArray {

    /**
     * Find the kth largest element in an unsorted array. Note that it is the kth largest element in the sorted order, not the kth distinct element.

    Example 1:

    Input: [3,2,1,5,6,4] and k = 2
    Output: 5
    Example 2:

    Input: [3,2,3,1,2,4,5,5,6] and k = 4
    Output: 4
    Note:
    You may assume k is always valid, 1 ≤ k ≤ array's length.
     */

    /**
     * 最大 K 个元素的最小堆
     *
     * Success
     * Runtime: 212 ms, faster than 89.93% of Kotlin online submissions for Kth Largest Element in an Array.
     * Memory Usage: 35 MB, less than 84.89% of Kotlin online submissions for Kth Largest Element in an Array.
     */
    fun findKthLargest0(nums: IntArray, k: Int): Int {
        val heap = ArrayList<Int>()
        nums.forEach { updateHeap(heap, k, it) }
        return heap[0]
    }

    private fun updateHeap(heap: ArrayList<Int>, k: Int, num: Int) {
        when {
            heap.size < k -> {
                heap.add(num)
                shiftUp(heap)
            }
            num > heap[0] -> {
                heap[0] = num
                shiftDown(heap)
            }
            else -> {
                // no op
            }
        }
    }

    private fun shiftUp(heap: ArrayList<Int>) {
        var index = heap.lastIndex
        var parentIndex = (index - 1) / 2
        while (parentIndex >= 0 && heap[index] < heap[parentIndex]) {
            swap(heap, index, parentIndex)
            index = parentIndex
            parentIndex = (index - 1) / 2
        }
    }

    private fun shiftDown(heap: ArrayList<Int>) {
        var index = 0
        var minChildIndex = minChildIndex(heap, index)
        while (minChildIndex > 0 && heap[index] > heap[minChildIndex]) {
            swap(heap, index, minChildIndex)
            index = minChildIndex
            minChildIndex = minChildIndex(heap, index)
        }
    }

    private fun minChildIndex(heap: ArrayList<Int>, index: Int): Int {
        val leftChildIndex = index * 2 + 1
        val rightChildIndex = index * 2 + 2
        return when {
            leftChildIndex >= heap.size -> {
                -1
            }
            rightChildIndex >= heap.size -> {
                leftChildIndex
            }
            else -> {
                if (heap[leftChildIndex] < heap[rightChildIndex]) leftChildIndex else rightChildIndex
            }
        }
    }

    private fun swap(heap: ArrayList<Int>, i: Int, j: Int) {
        val temp = heap[i]
        heap[i] = heap[j]
        heap[j] = temp
    }

    /**
     * 快排 Partition 方式
     *
     * Runtime: 280 ms, faster than 54.74% of Kotlin online submissions for Kth Largest Element in an Array.
     * Memory Usage: 34.7 MB, less than 91.24% of Kotlin online submissions for Kth Largest Element in an Array.
     */

    fun findKthLargest(nums: IntArray, k: Int): Int {
        var index = partition(nums, 0, nums.size - 1)
        while (index != -1) {
            index = when {
                index == k - 1 -> {
                    return nums[index]
                }
                index < k - 1 -> {
                    partition(nums, index + 1, nums.size - 1)
                }
                else -> {
                    partition(nums, 0, index - 1)
                }
            }
        }
        return -1
    }

    // 取 start 元素对 [start, end] 区间进行分割，返回 start 元素的 index
    private fun partition(num: IntArray, start: Int, end: Int): Int {
        if (start > end) {
            return -1
        }
        if (start == end) {
            return start
        }
        var i = start + 1
        var j = end
        val target = num[start]
        while (i <= j) {
            while (num[i] >= target && i < end) i++
            while (num[j] <= target && j > start) j--
            if (i < j) {
                swap(num, i, j)
            } else {
                break
            }
        }
        swap(num, start, j)
        return j
    }

    private fun swap(num: IntArray, i: Int, j: Int) {
        val temp = num[i]
        num[i] = num[j]
        num[j] = temp
    }
}