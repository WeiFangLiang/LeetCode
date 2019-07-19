package com.LeetCode.easy;

import java.util.Stack;

/**
 * 用栈实现队列
 * 			不会做，这是听了讲解，仿照评论区写出来的
 * @author WeiFangLiang
 *
 */
public class Solution232 {
	public static void main(String[] args) {
		MyQueue queue = new MyQueue();
		queue.push(1);
		queue.push(2);
		queue.push(3);
//		System.out.println(queue.peek());
		System.out.println(queue.peek());
		System.out.println(queue.empty());
	}
}

class MyQueue{
	private Stack<Integer> s1;  //申请两个栈 ，push看s1的
	private Stack<Integer> s2;// pop、peek看s2的
	
	public MyQueue() {
		s1 = new Stack<>(); //别忘了初始化栈
		s2 = new Stack<>();
	}
	
	public void push(int x) {
		s1.push(x);  //遇到 push 就往 s1放
	}
	
	public int pop() { //遇到 pop和peek 就把 s1的全放到s2中
		if(!s2.isEmpty()) {
			return s2.pop();  //只要s2不为空，就pop s2的
		}else if(!s1.isEmpty()){  //s2空，s1不空
			while(!s1.isEmpty()) {
				s2.push(s1.pop()); //那就把s1的全部放到s2
			}
			return s2.pop();
		}else {   //两个栈都是空
			return -1;
		}
	}
	
	public int peek() {
		if(!s2.isEmpty()) {
			return s2.peek();  //只要s2不为空，就pop s2的
		}else if(!s1.isEmpty()){  //s2空，s1不空
			while(!s1.isEmpty()) {
				s2.push(s1.pop());
			}
			return s2.peek();
		}else {
			return -1;
		}
	}
	
	public boolean empty() {
		return s1.isEmpty() && s2.isEmpty();
	}
}
