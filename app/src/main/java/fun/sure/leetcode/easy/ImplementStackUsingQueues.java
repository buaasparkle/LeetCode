package fun.sure.leetcode.easy;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * Created by wangshuo on 2016/6/13.
 */
public class ImplementStackUsingQueues {

    /**
     *Implement the following operations of a stack using queues.

     push(x) -- Push element x onto stack.
     pop() -- Removes the element on top of the stack.
     top() -- Get the top element.
     empty() -- Return whether the stack is empty.
     Notes:
     You must use only standard operations of a queue -- which means only push to back, peek/pop from front, size, and is empty operations are valid.
     Depending on your language, queue may not be supported natively. You may simulate a queue by using a list or deque (double-ended queue), as long as you use only standard operations of a queue.
     You may assume that all operations are valid (for example, no pop or top operations will be called on an empty stack).

     */

    // [PASS]
    private Queue<Integer> queue = new ArrayDeque<>();
    private int top = -1;

    // Push element x onto stack.
    public void push(int x) {
        queue.offer(x);
        top++;
    }

    // Removes the element on top of the stack.
    public void pop() {
        int temp = top;
        while (temp > 0) {
            queue.offer(queue.poll());
            temp--;
        }
        queue.poll();
        top--;
    }

    // Get the top element.
    public int top() {
        int temp = top;
        int t = 0;
        while (temp >= 0) {
            t = queue.poll();
            queue.offer(t);
            temp--;
        }
        return t;
    }

    // Return whether the stack is empty.
    public boolean empty() {
        return queue.isEmpty();
    }
}
