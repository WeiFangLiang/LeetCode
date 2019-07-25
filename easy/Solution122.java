package com.LeetCode.easy;
/**
 * 买卖股票的最佳时机
 * 		1、DFS
 * 		2、贪心算法
 * 		3、动态规划
 * @author WeiFangLiang
 *
 */
public class Solution122 {
	//贪心算法
	public static int maxProfit(int[] prices) {
		int ru = 0;
		int chu = 0;
		int count = 0;
        for(int i = 1;i < prices.length;i++) {
        	if(prices[i] > prices[i-1]) {
        		ru = i-1;
        		chu = i;
        		count = count + (prices[chu] - prices[ru]); 
        	}
        }
        return count;
    }
	public static void main(String[] args) {
		int[] prices = {1,2,3,4,5};
		int count = maxProfit(prices);
		System.out.println(count);
	}
}
