package com.LeetCode.easy;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution225 {

}
class MyStack {
	
	// 45.74%   61.53%
	Deque<Integer> deque;

    /** Initialize your data structure here. */
    public MyStack() {
        deque = new ArrayDeque<>(); // 换成LinkedList：64.91%，60%
    }
    
    /** Push element x onto stack. */
    public void push(int x) {
        deque.add(x);
    }
    
    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        int last = deque.getLast();
        deque.removeLast();
        return last;
    }
    
    /** Get the top element. */
    public int top() {
        return deque.getLast();
    }
    
    /** Returns whether the stack is empty. */
    public boolean empty() {
        return deque.isEmpty();
    }
}
