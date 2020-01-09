package com.LeetCode.mid;

public class Solution200 {
	//92%  83%
	public int numIslands(char[][] grid) {
        int isLands = 0;
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == '1'){//如果这是陆地
                    dfs(grid, i, j);//就顺着这个陆地，把整个岛炸掉
                    isLands++;//炸一个岛，记一次数
                }
            }
        }
        return isLands;
    }
    private void dfs(char[][] grid, int i, int j){
    	//越界终止条件
        if(i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] == '0') return;
        grid[i][j] = '0';//炸掉这个陆地
        //以(i, j)为中心，四处漫延
        dfs(grid, i - 1, j);//上
        dfs(grid, i + 1, j);//下
        dfs(grid, i, j - 1);//左
        dfs(grid, i, j + 1);//右
    }
}
