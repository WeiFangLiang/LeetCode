package com.LeetCode.easy;
/**
 * x 的平方根
 * 		返回值改为double也要会做
 * @author WeiFangLiang
 *
 */
public class Solution69 {
	public int mySqrt(int x) {
		//方法1：二分法： 80%   75%
		if (x == 1 || x == 0) return x;
        int start = 1;
        int end = x / 2 + 1; //最终结果一定是在 start 和 end 之间
        int mid = 0;
        while (start <= end) {
            mid = start + (end - start) / 2;
            //防止越界
            if (mid <= x / mid && (mid + 1) > x / (mid + 1)) return mid;
            if (mid > x / mid) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return 99999;//最后这个随便return
    }
	//方法2：牛顿迭代法	80%  79%
	public int mySqrt2(int x) {
		long r = x;
		while(r * r > x) { //循环结束时，说明 r * r 第一次 <= x，也就是最终结果
			r = (r + x / r) / 2;
		}
		return (int)r;
	}
}
