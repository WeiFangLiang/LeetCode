package com.LeetCode.easy;
/**
 * 最小栈
 */
import java.util.Stack;

public class Solution155 {

}

//73.16%  55.35%
class MinStack {
	
	//数据栈
	private Stack<Integer> data;
	//辅助栈
	private Stack<Integer> helper;
	
    /** initialize your data structure here. */
    public MinStack() {
    	data = new Stack<>();
    	helper = new Stack<>();
    }
    
    //数据栈与辅助栈实时同步
    
    public void push(int x) {
        data.add(x);
        if(helper.isEmpty() || helper.peek() >= x) {
        	helper.add(x); //helper只入栈更小的值
        }else {
        	helper.add(helper.peek());  //否则用栈顶元素替代
        }
    }
    
    public void pop() {
        //两个栈都得pop
    	if(!data.isEmpty()) {
    		data.pop();
    		helper.pop();
    	}
    }
    
    public int top() {
        if(!data.isEmpty()) {
        	return data.peek();
        }else {
        	throw new RuntimeException("栈中元素为空，此操作非法！");
        }
    }
    
    public int getMin() {
        if(!helper.isEmpty()) {
        	return helper.peek();
        }else {
        	throw new RuntimeException("栈中元素为空，此操作非法！");
        }
    }
}
