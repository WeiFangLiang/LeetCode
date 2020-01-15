package com.LeetCode.mid;

import java.util.Arrays;

public class Solution62 {
	//100%%   13%
	public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for(int i = 0;i < m;i++) dp[i][0] = 1;
        for(int j = 0;j < n;j++) dp[0][j] = 1;
        for(int i = 1;i < m;i++) {
        	for(int j = 1;j < n;j++) {
        		dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
        	}
        }
        return dp[m - 1][n - 1];
    }
	//优化空间
	public int uniquePaths2(int m, int n) {
        int[] cur = new int[n];
        Arrays.fill(cur,1);
        for (int i = 1; i < m;i++){
            for (int j = 1; j < n; j++){
                cur[j] += cur[j-1] ;
            }
        }
        return cur[n-1];
    }
}
