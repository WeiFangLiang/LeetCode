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
 * 				3、栈的  peek() 是获取但不删除栈顶元素
 * @author WeiFangLiang
 *
 */
public class Solution20 {
	//原创傻级代码, 6ms
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
       return size == 0;
    }
	
	//大佬的超简洁代码，时间复杂度差点  126ms
	public static boolean isValid1(String s) {
		int length;
		do {
			length = s.length();
			s = s.replace("()", "").replace("{}", "").replace("[]", "");  //精华所在！，只要有配对的括号，全部消掉！
		}while(length != s.length()); //上一步使得长度改变 和 length 不一致
			return s.length() == 0;
	}
	
	public static void main(String[] args) {
		String s ="()";
		boolean r = isValid1(s);
		System.out.println(r);
	}
}
