package com.LeetCode.hard;
/**
 * 解数独（不会）
 * 		还是回溯+剪枝
 * @author WeiFangLiang
 *
 */
public class Solution37 {
	public void solveSudoku(char[][] board) {
        if (board == null || board.length == 0) return ;
        solve(board);
    }
	public boolean solve(char[][] board) {
		for(int i = 0;i < board.length;i++) {
			for(int j = 0;j < board[0].length;j++) {
				if(board[i][j] == '.') {//如果为空
					for(char c = '1';c <= '9';c++) {//尝试填数
						if(isValid(board,i,j,c)) {
							board[i][j] = c;
							if(solve(board)) {
								return true;
							}else {
								board[i][j] = '.';
							}
						}
					}
					return false;
				}
			}
		}
		return true;
	}
	private boolean isValid(char[][] board,int row,int col,char c) {
		for(int i = 0;i < 9;i++) {
			if(board[i][col] != '.' && board[i][col] == c) return false;//检查行
			if(board[row][i] != '.' && board[row][i] == c) return false;//检查列
			if(board[3*(row/3) + i/3][3*(col/3) + i%3] != '.' || board[3*(row/3) + i/3][3*(col/3) + i%3] == c) return false; //检查3*3的九宫格
		}
		return true;
	}
}
