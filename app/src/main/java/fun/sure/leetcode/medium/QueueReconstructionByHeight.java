package fun.sure.leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by sure on 2017/6/25.
 */

public class QueueReconstructionByHeight {

    /**
     * Suppose you have a random list of people standing in a queue. Each person is described by a pair of integers (h, k),
     * where h is the height of the person and k is the number of people in front of this person who have a height greater
     * than or equal to h. Write an algorithm to reconstruct the queue.

     Note:
     The number of people is less than 1,100.

     Example

     Input:
     [[7,0], [4,4], [7,1], [5,0], [6,1], [5,2]]

     Output:
     [[5,0], [7,0], [5,2], [6,1], [4,4], [7,1]]
     */

    /**
     * 思路：
     * 1. 先排序，height由大到小，height相同，k小的在前 (？？为啥这么排，观察发现的，还没有细想原理)
     * 2. 类似插入排序法，逐一比较然后放在合适的位置
     */

    private static class Pair<F, S> {
        F first;
        S second;

        public Pair(F first, S second) {
            this.first = first;
            this.second = second;
        }
    }

    public int[][] reconstructQueue(int[][] people) {
        if (people == null) {
            return people;
        }
        List<Pair<Integer, Integer>> queue = new ArrayList<>();
        array2Pair(queue, people);
        sort(queue);
        pair2array(queue, people);
        queue.clear();
        for (int i = 0; i < people.length; i++) {
            insert(queue, people[i][0], people[i][1]);
        }
        pair2array(queue, people);
        return people;
    }

    private void sort(List<Pair<Integer, Integer>> queue) {
        Collections.sort(queue, new Comparator<Pair<Integer, Integer>>() {
            @Override
            public int compare(Pair<Integer, Integer> o1, Pair<Integer, Integer> o2) {
                if (o1.first > o2.first) {
                    return -1;
                } else if (o1.first < o2.first) {
                    return 1;
                } else {
                    return o1.second - o2.second;
                }
            }
        });
    }

    private void insert(List<Pair<Integer, Integer>> queue, int height, int k) {
        int count = 0;
        int i = 0;
        int index = 0;
        for (Pair<Integer, Integer> one : queue) {
            if (one.first >= height) {
                count++;
            }
            i++;
            if (count == k) {
                index = i;
                break;
            }
        }
        if (count < k) {
            index = queue.size();
        }
        queue.add(index, new Pair<>(height, k));
    }

    private void array2Pair(List<Pair<Integer, Integer>> queue, int[][] people) {
        queue.clear();
        for (int[] one : people) {
            queue.add(new Pair<>(one[0], one[1]));
        }
    }

    private void pair2array(List<Pair<Integer, Integer>> queue, int[][] people) {
        for (int i = 0; i < queue.size(); i++) {
            Pair<Integer, Integer> one = queue.get(i);
            people[i][0] = one.first;
            people[i][1] = one.second;
        }
    }

    public static void main(String[] args) {
        int[][] people = {
                {7, 0},
                {4, 4},
                {7, 1},
                {5, 0},
                {6, 1},
                {5, 2},
        };
        int[][] queue = new QueueReconstructionByHeight().reconstructQueue(people);
        for (int[] one : queue) {
            System.out.println(Arrays.toString(one));
        }
    }
}
