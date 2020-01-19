package com.LeetCode.mid;

import java.util.Arrays;

public class Solution338 {
	//位运算+动态规划
	public int[] countBits(int num) {
		int[] bits = new int[num + 1]; 
		Arrays.fill(bits, 0);
		for(int i = 1;i <= num;i++) {
			bits[i] += bits[i & ( i - 1)] + 1;
		}
		return bits;
    }
}
