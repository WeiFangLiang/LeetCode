package com.LeetCode.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 有效的字母异位词
 * @author WeiFangLiang
 *
 */
public class Solution242 {
	//这是我自己做的，击败了 5%
	public static boolean isAnagram(String s, String t) {
		if(s.length() != t.length()) {
			return false;
		}
        List<Character> list = new ArrayList<>();
        for(int i = 0;i < s.length();i++) {
        	list.add(s.charAt(i));  //遍历s 加入list
        }
        for(int i = 0;i < t.length();i++) { //遍历t 
        	if(list.contains(t.charAt(i))) {  
        		int j = list.indexOf(t.charAt(i));
        		list.remove(j);  //如果 list中包含 t 的字符，从list 中移除
        	}
        }
        if(list.size() == 0) {
        	return true;
        }
        return false;
    }
	//方法二、排序   击败了26%
	public static boolean isAnagram1(String s, String t) {
		char[] cs = s.toCharArray();  //字符串转数组
		Arrays.sort(cs); //排序
		//String css = Arrays.toString(cs); //再转回字符串
		char[] ct = t.toCharArray();
		Arrays.sort(ct);
		//String ctt = Arrays.toString(ct);  //其实无需再转回字符串
		
		//return css.equals(ctt);
		return Arrays.equals(cs, ct);  //比较俩数组是否相等
	}
	//方法三、利用Map 计数，看官方解
//	public static boolean isAnagram2(String s, String t) {
//		
//	}
	
	public static void main(String[] args) {
		String s = "a";
		String t = "b";
		boolean flag = isAnagram1(s,t);
		System.out.println(flag);
	}
}
