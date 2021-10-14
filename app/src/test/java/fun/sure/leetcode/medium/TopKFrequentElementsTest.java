package fun.sure.leetcode.medium;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by wangshuo on 2021/10/14.
 */
public class TopKFrequentElementsTest {

    private TopKFrequentElements target = new TopKFrequentElements();

    @Test
    public void topKFrequent() {
        assertArrayEquals(new int[]{1, 2}, target.topKFrequent(new int[]{1, 1, 1, 2, 2, 3}, 2));
        assertArrayEquals(new int[]{-1, 2}, target.topKFrequent(new int[]{4, 1, -1, 2, -1, 2, 3}, 2));
    }
}