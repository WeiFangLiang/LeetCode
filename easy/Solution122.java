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
	public int maxProfit(int[] prices) {
        int maxprofit = 0;
        //遍历数组，只要当天的价格相对于昨天是上涨的，那就卖出，计算利润
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1])
                maxprofit += prices[i] - prices[i - 1];
        }
        return maxprofit;
    }
}
