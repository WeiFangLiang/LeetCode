package com.LeetCode.easy;
/**
 * x 的平方根
 * 		返回值改为double也要会做
 * @author WeiFangLiang
 *
 */
public class Solution69 {
	public int mySqrt(int x) {
		//二分查找
        if (x == 0 || x == 1) return x;
        int l = 1;
        int r = x;
        int res = -1;
        while(l <= r) {
        	int m = (l+r)/2;
        	if(m == x/m) {
        		return m;
        	}else if(m > x/m) {
        		r = m-1;
        	}else {
        		l = m+1;
        		res = m;
        	}
        }
        return res;
    }
}
