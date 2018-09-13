package fun.sure.leetcode.common;

/**
 * Created by sure on 2018/9/13.
 */

public class DoublyNodeWithChild {

    public int val;
    public DoublyNodeWithChild prev;
    public DoublyNodeWithChild next;
    public DoublyNodeWithChild child;

    public DoublyNodeWithChild() {
    }

    public DoublyNodeWithChild(int _val, DoublyNodeWithChild _prev, DoublyNodeWithChild _next, DoublyNodeWithChild _child) {
        val = _val;
        prev = _prev;
        next = _next;
        child = _child;
    }
}
