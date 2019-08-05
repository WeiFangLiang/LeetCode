package com.LeetCode.mid;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 去掉K位数字
 * @author WeiFangLiang
 *
 */
public class Solution402 {
	public static String removeKdigits(String num, int k) {
        Deque<Integer> stack = new ArrayDeque<>();
        StringBuilder result = new StringBuilder(""); //结果字符串
        for(int i = 0;i < num.length();i++) { //从最高位遍历num
        	int number = num.charAt(i) - '0'; //将字符型转为int型
        	while(stack.size() != 0 && stack.peek() > number && k > 0) {
        		stack.pop();//总是贪婪的删除较高位的较大者
        		k--;
        	}
        	//针对100200  k=1这样有0的情况
        	if(number != 0 || stack.size() != 0) {
        		stack.push(number); //如果number为0且栈为空，那入栈也没意义
        	}
        }
        //针对 12345  k=3这样的
        while(stack.size() != 0 && k > 0) { //如果栈不空，且仍可以删数字
        	stack.pop();
        	k--;
        }
        //至此，栈中元素即为最终结果
        
        int len = stack.size();
        for(int i = 0;i < len;i++) { //遍历栈，放入result，此时的result是倒序添加的
        	result.append(stack.pop());
        }
        //注意：StringBuilder没有重写equals方法，所以需要先转为String
        if(result.toString().equals(""))  result.append("0"); //如果result为空，result即为0
        
        result.reverse();
        return result.toString(); //StringBuilder转为String
    }
	
	public static void main(String[] args) {
		String re = removeKdigits("10",2);
		System.out.println(re);
	}
}
