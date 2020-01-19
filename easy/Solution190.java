package com.LeetCode.easy;

public class Solution190 {
	
	public int reverseBits(int n) {
		int res = 0;
		for(int i = 0;i < 32;i++) {
			//res 左移一位是为了腾出一个空放置 n 的最后一位
			res = (res << 1) + (n & 1);
			// n 的最后一位处理完了，右移一位挤掉它
			n = n >> 1;
		}
		return res ;
    }
}
