package `fun`.sure.leetcode.medium

import org.junit.Test

import org.junit.Assert.*

/**
 * Created by wangshuo on 2021/10/11.
 */
class LRUCacheTest {

    @Test
    fun case() {
//        ["LRUCache", "put", "put", "get", "put", "get", "put", "get", "get", "get"]
//        [[2], [1, 1], [2, 2], [1], [3, 3], [2], [4, 4], [1], [3], [4]]
//        Output
//        [null, null, null, 1, null, -1, null, -1, 3, 4]
        val lruCache = LRUCache(2)
        lruCache.put(1, 1)
        lruCache.put(2, 2)
        var ret = lruCache.get(1)
        assertEquals(1, ret)
        lruCache.put(3, 3)
        ret = lruCache.get(2)
        assertEquals(-1, ret)
        lruCache.put(4, 4)
        ret = lruCache.get(1)
        assertEquals(-1, ret)
        ret = lruCache.get(3)
        assertEquals(3, ret)
        ret = lruCache.get(4)
        assertEquals(4, ret)
    }

    @Test
    fun case2() {
//        ["LRUCache","put","get","put","get","get"]
//        [[1],[2,1],[2],[3,2],[2],[3]]
        val lruCache = LRUCache(1)
        lruCache.put(2, 1)
        var ret = lruCache.get(2)
        assertEquals(1, ret)
        lruCache.put(3,2)
        ret = lruCache.get(2)
        assertEquals(-1, ret)
        ret = lruCache.get(3)
        assertEquals(2, ret)
    }
}