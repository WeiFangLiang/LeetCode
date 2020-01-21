package com.LeetCode.hard;

public class Solution72 {

	public int minDistance(String word1, String word2) {
		int m = word1.length();
		int n = word2.length();
		if(m * n == 0) return n + m;
		int[][] dp = new int[m + 1][n + 1];
		//初始化dp
		for(int i = 0;i <= m;i++) dp[i][0] = i;//初始化第一列
		for(int j = 0;j <= n;j++) dp[0][j] = j;//初始化第一行
		for(int i = 1;i <= m;i++) {
			for(int j = 1;j <= n;j++) {
				if(word1.charAt(i - 1) == word2.charAt(j - 1)) {
					dp[i][j] = dp[i - 1][j - 1];
				}else {
					int mid = Math.min(dp[i - 1][j - 1], dp[i - 1][j]);
					int min = Math.min(mid, dp[i][j - 1]);
					dp[i][j] = 1 + min;
				}
			}
		}
		return dp[m][n];
    }
}
