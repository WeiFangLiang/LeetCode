package com.LeetCode.easy;

import java.util.Arrays;

/**
 * 分发饼干 
 * @author WeiFangLiang
 *
 */
public class Solution455 {
	public int findContentChildren(int[] g, int[] s) {
		Arrays.sort(g);
		Arrays.sort(s);
		//1,2   1,2,3
		int i = 0;//孩子数组的下标
		int j = 0;//饼干数组的下标
		while(i < g.length && j < s.length) {
			if(g[i] <= s[j]) {
				i++;
				j++;
			}else {
				j++;
			}
		}
		return i;
	}
}
