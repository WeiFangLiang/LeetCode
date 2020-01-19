package com.LeetCode.easy;

public class Solution231 {
	//就是让你判断 n 的二进制表示中，是否 有且仅有一个 1
	public boolean isPowerOfTwo(int n) {
		if(n <= 0) return false;
		int count = 0;
        while(n != 0) {
        	n = n & (n - 1);
        	count++;
        }
        return count == 1;
    }
}
