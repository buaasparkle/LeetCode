package `fun`.sure.leetcode.medium

import `fun`.sure.leetcode.Topics

/**
 * Created by wangshuo on 2021/10/11.
 */
class LRUCache(capacity: Int) : Topics.HashTable, Topics.LinkedList, Topics.DoublyLinkedList, Topics.Design {

    /**
     *
     * Design a data structure that follows the constraints of a Least Recently Used (LRU) cache.

    Implement the LRUCache class:

    LRUCache(int capacity) Initialize the LRU cache with positive size capacity.
    int get(int key) Return the value of the key if the key exists, otherwise return -1.
    void put(int key, int value) Update the value of the key if the key exists. Otherwise, add the key-value pair to the cache. If the number of keys exceeds the capacity from this operation, evict the least recently used key.
    The functions get and put must each run in O(1) average time complexity.



    Example 1:

    Input
    ["LRUCache", "put", "put", "get", "put", "get", "put", "get", "get", "get"]
    [[2], [1, 1], [2, 2], [1], [3, 3], [2], [4, 4], [1], [3], [4]]
    Output
    [null, null, null, 1, null, -1, null, -1, 3, 4]

    Explanation
    LRUCache lRUCache = new LRUCache(2);
    lRUCache.put(1, 1); // cache is {1=1}
    lRUCache.put(2, 2); // cache is {1=1, 2=2}
    lRUCache.get(1);    // return 1
    lRUCache.put(3, 3); // LRU key was 2, evicts key 2, cache is {1=1, 3=3}
    lRUCache.get(2);    // returns -1 (not found)
    lRUCache.put(4, 4); // LRU key was 1, evicts key 1, cache is {4=4, 3=3}
    lRUCache.get(1);    // return -1 (not found)
    lRUCache.get(3);    // return 3
    lRUCache.get(4);    // return 4


    Constraints:

    1 <= capacity <= 3000
    0 <= key <= 104
    0 <= value <= 105
    At most 2 * 105 calls will be made to get and put.
     */

    /**
     * Your LRUCache object will be instantiated and called as such:
     * var obj = LRUCache(capacity)
     * var param_1 = obj.get(key)
     * obj.put(key,value)
     */


    /*
    Success
    Runtime: 924 ms, faster than 81.19% of Kotlin online submissions for LRU Cache.
    Memory Usage: 134 MB, less than 93.56% of Kotlin online submissions for LRU Cache.
     */
    private var head: DoubleLinkedNode? = null
    private var rear: DoubleLinkedNode? = null
    private var size = 0
    private var capacity = capacity
    private val hashMap = HashMap<Int, DoubleLinkedNode>()

    fun get(key: Int): Int {
        if (hashMap.containsKey(key)) {
            val node = hashMap[key] ?: return -1
            removeNodeAdjustHeadRear(node)
            insertHeadAndAdjustRear(node)
            return node.value
        }
        return -1
    }

    fun put(key: Int, value: Int) {
        if (hashMap.containsKey(key)) {
            val node = hashMap[key] ?: return
            node.value = value
            removeNodeAdjustHeadRear(node)
            insertHeadAndAdjustRear(node)
        } else {
            val node = DoubleLinkedNode(key, value)
            if (size < capacity) {
                size++
            } else {
                rear?.let {
                    hashMap.remove(it.key)
                    removeNodeAdjustHeadRear(it)
                }
            }
            insertHeadAndAdjustRear(node)
            hashMap[key] = node
        }
    }

    // 此方法对应 testcase 未通过的处理，调整 head rear 位置
    private fun removeNodeAdjustHeadRear(node: DoubleLinkedNode): DoubleLinkedNode? {
        if (node === head) {
            head = node.next
        }
        if (node === rear) {
            rear = node.pre
        }
        return node.removeSelf()
    }

    // 此方法对应 testcase 未通过的处理，调整 head rear 位置
    private fun insertHeadAndAdjustRear(node: DoubleLinkedNode) {
        head = node.insertHead(head)
        if (rear == null) {
            rear = node
        }
    }

    inner class DoubleLinkedNode(val key: Int, var value: Int) {
        var pre: DoubleLinkedNode? = null
        var next: DoubleLinkedNode? = null

        fun removeSelf(): DoubleLinkedNode? {
            pre?.next = next
            next?.pre = pre
            reset()
            return pre
        }

        fun insertHead(node: DoubleLinkedNode?): DoubleLinkedNode {
            pre = null
            next = node
            node?.pre = this
            return this
        }

        private fun reset() {
            pre = null
            next = null
        }
    }
}