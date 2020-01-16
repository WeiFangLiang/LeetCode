package com.LeetCode.mid;

import java.util.List;

/**
 * 三角形最小路径和
 * @author WeiFangLiang
 *
 */
public class Solution120 {
	//自底向上的动态规划   一维dp (最优解)	84.3%  83.8%
	public int minimumTotal(List<List<Integer>> triangle) {
		int row = triangle.size();//triangle有几行，单行最多就有几个元素
        int[] dp = new int[row];
        for (int i = 0; i < row; i++) dp[i] = triangle.get(row - 1).get(i); //初始化triangle的最后一行数组
        for (int i = row - 2; i >= 0; i--)  //从倒数第二行数组开始
            for (int j = 0; j < i + 1; j++)
            	//在执行重写操作之前，dp[j]其实就是dp[i+1][j]
                dp[j] = Math.min(dp[j], dp[j + 1]) + triangle.get(i).get(j);
        return dp[0];
    }
	//暴力递归
	public int minimumTotal2(List<List<Integer>> triangle) {
		if(triangle == null || triangle.size() == 0) return 0;
		return helper(triangle, 0, 0);
	}
	private int helper(List<List<Integer>> triangle, int level, int index) {
		if(level == triangle.size() - 1) return triangle.get(level).get(index);
		int left = helper(triangle, level + 1,index);
		int right = helper(triangle, level + 1,index + 1);
		return triangle.get(level).get(index) + Math.min(left, right);
	}
	//自底向上：二维dp	84%   93%
	public int minimumTotal3(List<List<Integer>> triangle) {
		if(triangle == null || triangle.size() == 0) return 0;
		int lastRowSize = triangle.get(triangle.size() - 1).size();
		int row = triangle.size();//行数
		int[][] dp = new int[row][lastRowSize];//最大行，最大列
		//初始化dp，最后一行的dp值就是triangle最后一行的值
		for(int i = 0;i < lastRowSize;i++) {
			dp[dp.length - 1][i] = triangle.get(row - 1).get(i);
		}
		for(int i = dp.length - 2; i >= 0; i--) {//从倒数第二行往上递推
			for(int j = 0;j < i + 1;j++) {//第 i 行有 i + 1个元素
				dp[i][j] = Math.min(dp[i + 1][j], dp[i + 1][j + 1]) + triangle.get(i).get(j);
			}
		}
		return dp[0][0];
	}
}
