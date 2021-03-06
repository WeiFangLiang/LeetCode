package com.LeetCode.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 有效的字母异位词   异位词：字母出现次数一样，但是顺序不一样
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
		char[] ct = t.toCharArray();
		Arrays.sort(ct);
		return Arrays.equals(cs, ct);  //比较俩数组是否相等
	}
	//方法三、 计数，官方解
	public static boolean isAnagram2(String s, String t) {
		if (s.length() != t.length()) {
	        return false;
	    }
	    int[] counter = new int[26];//对应26个英文字母
	    for (int i = 0; i < s.length(); i++) {
	        counter[s.charAt(i) - 'a']++;//遍历s，就将相应字母的计数 +1
	        counter[t.charAt(i) - 'a']--;//遍历t，就将相应字母的计数 -1
	    }
	    for (int count : counter) {//遍历计数器
	        if (count != 0) { //如果两个字符串的对应的字母同样多，那计数器数组应该全为0
	            return false;
	        }
	    }
	    return true;
	}
	
}
