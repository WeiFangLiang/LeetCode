package com.LeetCode.mid;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Solution17 {
	//93.7%   74.5%
	public List<String> letterCombinations(String digits) {
		if(digits == null || digits.length() == 0) return new ArrayList<String>();
		Map<Character, String> map = new HashMap<>();
		map.put('2', "abc");
		map.put('3', "def");
		map.put('4', "ghi");
		map.put('5', "jkl");
		map.put('6', "mno");
		map.put('7', "pqrs");
		map.put('8', "tuv");
		map.put('9', "wxyz");
		List<String> res = new LinkedList<>();
		search("", digits, 0, res, map);
		return res;
    }
	//digits长度为n，就是处理n个格子，标号0---n-1
	//index 代表递归层次，也就是当前处理的格子标号
	private void search(String subResult, String digits, int index, List<String> res, Map<Character, String> map) {
		if(index == digits.length()) {//说明所有的数字都处理完了
			res.add(subResult);
			return ;
		}
		String letters = map.get(digits.charAt(index));//获取该数字对应的字母序列
		for(int j = 0;j < letters.length();j++) {
			search(subResult + letters.charAt(j), digits, index + 1, res, map);
		}
	}
}	
