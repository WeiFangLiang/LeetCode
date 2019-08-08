package com.LeetCode.mid;
/**
 * 零钱兑换
 * @author WeiFangLiang
 *
 */
public class Solution322 {
	//超过36%  有能力自己优化
	public int coinChange(int[] coins, int amount) {
		//coins = [1,2,5,7,10]   金额14
        int[] dp = new int[amount+1];
        for(int i = 0;i <= amount;i++) {
        	dp[i] = -1; //最初所有金额的最优解均为-1（不可到达）
        }
        //dp = [-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1]     
        dp[0] = 0; //金额0 的最优解为0
        //dp = [0,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1]
        for(int i = 1;i <= amount;i++) { //循环各个面值，找到dp[i]额最优解
        	for(int j = 0;j < coins.length;j++) {
        		if(i - coins[j] >= 0 && dp[i-coins[j]] != -1) { //coins[j] 代表索引为 j 的面值
        			if(dp[i] == -1 || dp[i] > dp[i - coins[j]] + 1) { //dp[i-coins[j]] 代表上个状态的最优解
        				dp[i] = dp[i-coins[j]] + 1;
        			}
        		}
        	}
        }
        return dp[amount];
    }
}
