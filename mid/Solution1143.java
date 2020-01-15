package com.LeetCode.mid;

public class Solution1143 {
	//73%  100%
	public int longestCommonSubsequence(String text1, String text2) {
        if(text1 == null || text2 == null) return 0;
        int m = text1.length();
        int n = text2.length();
      //多申请一行一列，是因为dp[0][0]需要处理越界，所以改成dp[1][1]
        int[][] dp = new int[m + 1][n + 1];
        for(int i = 1;i <= m;i++) {
        	for(int j = 1;j <= n;j++) {
        		if(text1.charAt(i - 1) == text2.charAt(j - 1)) {
        			dp[i][j] = dp[i - 1][j - 1] + 1;
        		}else {
        			dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
        		}
        	}
        }
        return dp[m][n];
    }
}
