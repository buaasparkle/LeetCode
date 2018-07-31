package fun.sure.leetcode.common;

import java.util.List;

/**
 * Created by sure on 2018/7/31.
 */

public class Node {

    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val,List<Node> _children) {
        val = _val;
        children = _children;
    }
}
