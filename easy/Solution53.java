package com.LeetCode.easy;

public class Solution53 {
	//动态规划       99.98%  58.67%
	public int maxSubArray(int[] nums) {
		if(nums == null || nums.length == 0) return -1;
		int[] dp = nums.clone();
		int max = dp[0];
		for(int i = 1;i < dp.length;i++) {
			dp[i] = Math.max(nums[i], dp[i - 1] + nums[i]);
			if(max < dp[i]) max = dp[i];
		}
		return max;
    }
	//不申请额外数组，复用nums（工程上不能这么干）  99.98%  88.58%
	public int maxSubArray2(int[] nums) {
		if(nums == null || nums.length == 0) return -1;
		int max = nums[0];
		for(int i = 1;i < nums.length;i++) {
			nums[i] = Math.max(nums[i], nums[i - 1] + nums[i]);
			if(max < nums[i]) max = nums[i];
		}
		return max;
    }
}
