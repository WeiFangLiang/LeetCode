package com.LeetCode.easy;

public class Solution14 {
	
	public String longestCommonPrefix(String[] strs) {
		if(strs == null || strs.length == 0) return "";
		int minLen = Integer.MAX_VALUE;
		for(int i = 0;i < strs.length;i++) {
			if(minLen > strs[i].length()) minLen = strs[i].length(); 
		}
		int index = 0;//截取的位置
		for(int i = 0;i < minLen;i++) {
			char c = strs[0].charAt(i);
			for(int j = 1;j < strs.length;j++) {
				if(strs[j].charAt(i) != c) return strs[0].substring(0, index);
			}
			index++;
		}
		return strs[0].substring(0, index);
    }
}
