package com.LeetCode.easy;
/**
 * 搜索插入位置
 * 小结：
 * 		我这个算是暴力解法，最优解应该用二分查找
 * @author WeiFangLiang
 *
 */
public class Solution35 {
	public static int searchInsert(int[] nums, int target) {
	        //[1,3,5,6]  2 --->1    0--->0   7--->4
		int i = 0;
		for(;i < nums.length;i++) {
			if(nums[i] == target) {
				return i;
			}else if(nums[i] > target){
				return i;
			}
		}
		return i;
	}
}
