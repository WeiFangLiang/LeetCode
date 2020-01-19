package com.LeetCode.easy;

public class Solution191 {
	//方法 1
	public int hammingWeight(int n) {
        int count = 0;
        while(n != 0) {
        	n = n & (n - 1);//将最低位的1变为0
        	count++;//变一次，+1
        }
        return count;
    }
	//方法2
	public int hammingWeight2(int n) {
	    int count = 0;
	    int mask = 1;
	    for (int i = 0; i < 32; i++) {//int 类型是32位，所以循环32次
	        if ((n & mask) != 0) {
	            count++;
	        }
	        mask <<= 1;
	    }
	    return count;
	}
}
