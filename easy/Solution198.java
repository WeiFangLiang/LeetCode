package com.LeetCode.easy;
/**
 * 打家劫舍
 * @author WeiFangLiang
 *
 */
public class Solution198 {
	public int rob(int[] nums) {
		//牧码啦大佬的解法
		int len = nums.length;
        if(len == 0) return 0;          
        int[] dp = new int[len + 1];
        dp[0] = 0;
        dp[1] = nums[0]; //dp[i]表示 i 号房屋的最优解
        for(int i = 2; i <= len; i++) {
            dp[i] = Math.max(dp[i-1], dp[i-2] + nums[i-1]);
        }
        return dp[len];
    }
}
