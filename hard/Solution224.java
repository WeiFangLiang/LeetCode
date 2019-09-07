package com.LeetCode.hard;
/**
 * 暂时没看懂，修炼修炼再看，自己写一个
 */
import java.util.Stack;

public class Solution224 {
	
	public int calculate(String s) {
		//78.68%		84.11%
		Stack<Integer> stack = new Stack<Integer>();
        // sign 代表正负
        int sign = 1, res = 0;
        int length = s.length();  //表达式的长度
        for (int i = 0; i < length; i++) {  
            char ch = s.charAt(i);
            if (Character.isDigit(ch)) { //验证该字符是否为数字
                int cur = ch - '0';  // char 转为 int
                while (i + 1 < length && Character.isDigit(s.charAt(i + 1)))
                    cur = cur * 10 + s.charAt(++i) - '0';
                res = res + sign * cur;
            } else if (ch == '+') {
                sign = 1;
            } else if (ch == '-') {
                sign = -1;
            } else if (ch == '(') {
                stack.push(res);
                res = 0;
                stack.push(sign);
                sign = 1;
            } else if (ch == ')') {
                res = stack.pop() * res + stack.pop();
            }
        }
        return res;
    }
}
