package fun.sure.leetcode.easy;

import java.util.Stack;

/**
 * Created by wangshuo on 2016/6/13.
 */
public class ImplementQueueUsingStacks {

    /**
     * Implement the following operations of a queue using stacks.
     * push(x) -- Push element x to the back of queue.
     * pop() -- Removes the element from in front of queue.
     * peek() -- Get the front element.
     * empty() -- Return whether the queue is empty.
     * <p/>
     * Notes:
     * You must use only standard operations of a stack -- which means only push to top, peek/pop from top, size, and is empty operations are valid.
     * Depending on your language, stack may not be supported natively. You may simulate a stack by using a list or deque (double-ended queue),
     * as long as you use only standard operations of a stack.
     * You may assume that all operations are valid (for example, no pop or peek operations will be called on an empty queue).
     */

    // [PASS]
    private Stack<Integer> pushStack = new Stack<>();
    private Stack<Integer> popStack = new Stack<>();

    // Push element x to the back of queue.
    public void push(int x) {
        getPushStack().push(x);
    }

    // Removes the element from in front of queue.
    public void pop() {
        getPopStack().pop();
    }

    // Get the front element.
    public int peek() {
        return getPopStack().peek();
    }

    // Return whether the queue is empty.
    public boolean empty() {
        return getPushStack().isEmpty() && getPopStack().isEmpty();
    }

    private Stack<Integer> getPushStack() {
        return pushStack;
    }

    private Stack<Integer> getPopStack() {
        if (popStack.isEmpty() && !pushStack.isEmpty()) {
            while (!pushStack.isEmpty()) {
                popStack.push(pushStack.pop());
            }
        }
        return popStack;
    }
}
