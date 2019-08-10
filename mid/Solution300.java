package com.LeetCode.mid;

/**
 * 最长上升子序列
 * @author WeiFangLiang
 *
 */
public class Solution300 {
	public int lengthOfLIS(int[] nums) {
		//超过7% 、32%。。。
		if (nums.length == 0) return 0;
		int[] dp = new int[nums.length]; //dp[i]代表以第 i 个元素为结尾的最长上升子序列的长度
		dp[0] = 1;
		int LIS = 1;
		for(int i = 1;i < nums.length;i++) {
			dp[i] = 1;
			for(int j = 0;j < i;j++) {
				if(nums[i] > nums[j] && dp[i] < dp[j] + 1) {
					dp[i] = dp[j] + 1;
				}
			}
			if(LIS < dp[i]) {
				LIS = dp[i];
			}
		}
		return LIS;
	}
	//解法二：使用栈，Java貌似不可以，因为需要获取栈的中间元素
}
