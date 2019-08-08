package com.LeetCode.mid;

import java.util.List;

/**
 * 三角形最小路径和
 * @author WeiFangLiang
 *
 */
public class Solution120 {
	//自底向上的动态规划
	public int minimumTotal(List<List<Integer>> triangle) {
		int row = triangle.size();
        int[] dp = new int[row];
        for (int i = 0; i < row; i++) dp[i] = triangle.get(row - 1).get(i); //初始化triangle的最后一行数组
        for (int i = row - 2; i >= 0; i--)  //从倒数第二行数组开始
            for (int j = 0; j <= i; j++)
                dp[j] = Math.min(dp[j], dp[j + 1]) + triangle.get(i).get(j);
        return dp[0];

		/*
		 * 作者：powcai		
		 */
    }
}
