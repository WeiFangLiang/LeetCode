package com.LeetCode.easy;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
/**
 * 匹配括号：
 * 		小结：
 * 				1、一直以来，我都理解错了String类中的 indexOf(int ch)的用法！！charAt(int i) 才是返回字符
 * 				2、我的算法思路漏洞百出，思维不缜密，代码属于傻级的，所以一定要先理清思路！！
 * @author WeiFangLiang
 *
 */
public class Solution20 {
	public static boolean isValid(String s) {
		//"() {} []"
        Deque<Character> stack = new LinkedList<>();
        Map<Character,Character> map = new HashMap<>();
        map.put('(',')');
        map.put('{','}');
        map.put('[',']');
        char[] cs = s.toCharArray();
        int n = s.length();
        int size =0;
        if( n < 1) {
        	return true;
        }else if(n == 1) {
        	return false;
        }
        if(cs[0] == ')' || cs[0]  == '}' || cs[0]  == ']') {
        	return false;
        }
        for(int i = 0;i < n;i++) {  
        	if(cs[i] == '(' || cs[i]  == '{' || cs[i]  == '[' ) { //左括号入栈
        		stack.push(cs[i] );
        		size++;
        	}else {   //右括号出栈匹配
        		if(size == 0) {
        			return false;
        		}
        		char pop = stack.pop();
        		size--;
        		if( !(map.get(pop).equals(cs[i]))) {
        			return false;
        		}
        	}    	
        }
        if(size == 0) {        	
        	return true;
        }else {
        	return false;
        }
    }
	public static void main(String[] args) {
		String s ="()";
		boolean r = isValid(s);
		System.out.println(r);
	}
}
