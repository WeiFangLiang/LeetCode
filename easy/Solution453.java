package com.LeetCode.easy;
/**
 * 最小移动次数使数组元素相等
 * @author Administrator
 *
 */
public class Solution453 {
	public int minMoves(int[] nums) {
		//1 2 3 将除了一个元素之外的全部元素+1，等价于将该元素-1，因为我们只对元素的相对大小感兴趣。因此，该问题简化为需要进行的减法次数
		int moves = 0;
		int min = Integer.MAX_VALUE;
		for(int i = 0;i < nums.length;i++) {
			min = Math.min(min, nums[i]);
		}
		for(int i = 0;i < nums.length;i++) {
			moves += nums[i] - min;
		}
		return moves;
    }
}
