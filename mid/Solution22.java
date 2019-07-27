package com.LeetCode.mid;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * 括号生成（不会）
 * 		谷歌的代码规范：缩进是俩空格，if 等关键字 后面要空一格，大括号小括号之间空一格
 * @author WeiFangLiang
 *
 */
public class Solution22 {
	public static List<String> generateParenthesis(int n) {
		//回溯思想，需要加强练习
		List<String> result = new ArrayList<>();
		generateOneByOne("",result,n,n);
		return result;
    }
	/**
	 * 
	 * @param sublist
	 * @param result  结果集
	 * @param left  还剩多少左括号
	 * @param right  还剩多少右括号
	 */
	public static void generateOneByOne(String sublist ,List<String> result, int left,int right) {
		if (left == 0 && right == 0) {   // 括号都用完了，sublist组装完毕
			result.add(sublist);
			return ;
		}
		if (left > 0) {
			generateOneByOne(sublist + "(", result, left-1, right);
		}
		if (right > left) {
			generateOneByOne(sublist + ")", result, left, right-1);
		}
	}
	
	public static void main(String[] args) {
		List<String> result = generateParenthesis(3);
		Iterator<String> it = result.iterator();
		while(it.hasNext()) {
			System.out.println(it.next());
		}
	}
}
