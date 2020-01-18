package com.LeetCode.hard;
/**
 * 解数独（不会）
 * 		还是回溯+剪枝
 * @author WeiFangLiang
 *
 */
public class Solution37 {
	//leftUpArr[i] 表示 i 号 3*3网格的左上角格子的行与列
	String[] leftUpArr = new String[] {"00", "03", "06", "30", "33", "36", "60", "63", "66"};
	
	public void solveSudoku(char[][] board) {
		//先判断棋盘是否合法 
        if (board == null || board.length == 0) return ;
        solve(board);
    }
	public boolean solve(char[][] board) {
		for(int i = 0;i < board.length;i++) {
			for(int j = 0;j < board[0].length;j++) {//遍历整个board，寻找空位
				if(board[i][j] == '.') {//如果为空位
					for(char c = '1';c <= '9';c++) {//尝试填数
						if(isValid(board,i,j,c)) {//检查在(i, j) 位置上填 c 是否可行
							board[i][j] = c;//如果可行，就填上 c 
							//递归调用
							if(solve(board)) {//如果能解决
								return true;
							}else {
								board[i][j] = '.';//如果不能，就撤销 c 
							}
						}
					}
					//如果(i, j)位置上 1--9都不行，说明无解
					return false;
				}
			}
		}
		//整个棋盘遍历完了，说明可以解决
		return true;
	}
	private boolean isValid(char[][] board, int row, int col, char c) {
		for(int i = 0;i < 9;i++) {
			if(board[i][col] != '.' && board[i][col] == c) return false;//检查行
			if(board[row][i] != '.' && board[row][i] == c) return false;//检查列
			
		}
		int gridNum = (row / 3) * 3 + col / 3;//获取(row，col)所在的3*3九宫格的编号
		//如果该九宫格中，不能在(row, col)放 c
		if(!checkGrid(board, gridNum, row, col, c)) return false;;

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
	
	public static void main(String[] args) {
		char[][] board = {{'5','3','.','.','7','.','.','.','.'},
						  {'6','.','.','1','9','5','.','.','.'},
						  {'.','9','8','.','.','.','.','6','.'},
						  {'8','.','.','.','6','.','.','.','3'},
						  {'4','.','.','8','.','3','.','.','1'},
						  {'7','.','.','.','2','.','.','.','6'},
						  {'.','6','.','.','.','.','2','8','.'},
						  {'.','.','.','4','1','9','.','.','5'},
						  {'.','.','.','.','8','.','.','7','9'}
						  };
		Solution37 s = new Solution37();
		s.solve(board);
		for(int i = 0;i < board.length;i++) {
			System.out.println(String.valueOf(board[i]));
		}
	}
}
