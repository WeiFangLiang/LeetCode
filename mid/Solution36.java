package com.LeetCode.mid;

public class Solution36 {
	
	//leftUpArr[i] 表示 i 号 3*3网格的左上角格子的行与列
	String[] leftUpArr = new String[] {"00", "03", "06", "30", "33", "36", "60", "63", "66"};

	public boolean isValidSudoku(char[][] board) {
		if(board == null || board.length == 0) return false;
		for(int i = 0;i < board.length;i++) {
			for(int j = 0;j < board[0].length;j++) {
				if(board[i][j] != '.') {
					if(!isValid(board, i, j)) return false;
				}
			}
		}
		return true;
    }

	private boolean isValid(char[][] board, int row, int col) {
		for(int i = 0;i < 9;i++) {
			if(i == row) continue;
			//检查col列
			if(board[i][col] == board[row][col]) return false;
		}
		for(int j = 0;j < 9;j++) {
			if(j == col) continue;
			//检查row行
			if(board[row][j] == board[row][col]) return false;
			
		}
		int gridNum = (row / 3) * 3 + col / 3;//获取(row，col)所在的3*3九宫格的编号
		//如果该九宫格中，不能在放 board[row][col]这个值
		if(!checkGrid(board, gridNum, row, col, board[row][col])) return false;
		
		return true;
	}
	
	private boolean checkGrid(char[][] board, int gridNum,int row,int col, char c) {
		String leftUp = leftUpArr[gridNum];//该3*3九宫格的左上角
		int leftUpRow = Integer.valueOf(leftUp.charAt(0)+"");//左上角的行
		int leftUpCol = Integer.valueOf(leftUp.charAt(1)+"");//列
		for(int i = leftUpRow;i < leftUpRow + 3;i++) {//遍历这个3*3的九宫格
			for(int j = leftUpCol;j < leftUpCol + 3;j++) {				
				if(i == row && j == col) {//如果遍历到(row, col)这个位置就跳过
					continue;
				}else if(board[i][j] != '.' && board[i][j] == c) return false;
			}
		}
		return true;
	}
}
