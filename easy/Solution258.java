package com.LeetCode.easy;

public class Solution258 {
	public int addDigits(int num) {
		if(num < 10) {
			return num;
		}
		num = (num / 10) + (num % 10);
		int res = addDigits(num);
		return res;
	}
}
