package com.LeetCode.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * 思路：过滤字符串，只留下字母和数字，再分成前后两部分对比
 * @author WeiFangLiang
 *
 */
public class Solution125 {
	public static boolean isPalindrome(String s) {
		//"A man, a plan, a canal: Panama"  ---true
		if(s == null) {
			return true;
		}
		//难就难在如何过滤字符串
		//我是将 a~~z  0~~9全加到 map 里
		Map<Character,Boolean> map = new HashMap<>();
		map.put('a',true);
		map.put('b',true);
		map.put('c',true);
		map.put('d',true);
		map.put('e',true);
		map.put('f',true);
		map.put('g',true);
		map.put('h',true);
		map.put('i',true);
		map.put('j',true);
		map.put('k',true);
		map.put('l',true);
		map.put('m',true);
		map.put('n',true);
		map.put('o',true);
		map.put('p',true);
		map.put('q',true);
		map.put('r',true);
		map.put('s',true);
		map.put('t',true);
		map.put('u',true);
		map.put('v',true);
		map.put('w',true);
		map.put('x',true);
		map.put('y',true);
		map.put('z',true);
		map.put('0',true);
		map.put('1',true);
		map.put('2',true);
		map.put('3',true);
		map.put('4',true);
		map.put('5',true);
		map.put('6',true);
		map.put('7',true);
		map.put('8',true);
		map.put('9',true);
		String ss = s.toLowerCase();   //字母一律换成小写，反正不考虑大小写问题
		char[] temp = ss.toCharArray();
		StringBuilder sum = new StringBuilder();   //用于接收最后的纯字母和数字
		for(int i = 0;i < temp.length;i++) {
			if(map.containsKey(temp[i])) {
				sum.append(temp[i]);
			}
		}
		//   sum = "amanaplana    c    analpanama"  ---true
		for(int i = 0;i < sum.length() / 2;i++) {
			if(sum.charAt(i) != sum.charAt(sum.length()-1-i)) {
				return false;
			}
		}
		return true;
	}
	public static void main(String[] args) {
		boolean b = isPalindrome("A man, a plan, a canal: Panama");
		System.out.println(b);
	}
}
/*
 * 小结：
 * java.lang.Character.isLetterOrDigit(char c)方法的声明
 * 这个方法就是专门验证，如果字符是字母或数字此方法返回true，否则为false。
 */
