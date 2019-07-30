package com.LeetCode.hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * N皇后问题（不会）  52题自己做
 * 		剪枝，优化回溯算法
 * @author WeiFangLiang
 *
 */
public class Solution51 {
	public static List<String[]> solveNQueens(int n) {
        List<String[]> res = new ArrayList<>();  //最终的结果集
        helper(0,new boolean[n],new boolean[2*n],new boolean[2*n],new String[n],res);
        return res;
    }
	/**
	 * 
	 * @param r 层数，从0算起
	 * @param cols 表示列的数组，皇后所在列记为true
	 * @param d1 代表撇的数组
	 * @param d2 代表捺的数组
	 * @param board  一个board代表一种解法
	 * @param res 结果集
	 */
	private static void helper(int r,boolean[] cols,boolean[] d1,boolean[] d2,String[] board,List<String[]> res) {
		if (r == board.length) {//如果到了第n层，从0算起
			res.add(board.clone());//就把上一层求的board加入结果集
		}else {
			for (int c = 0;c < board.length;c++) {
				int id1 = r - c + board.length; //皇后所在的捺
				int id2 = 2 * board.length - r - c - 1; //皇后所在的撇
				if (!cols[c] && !d1[id1] && !d2[id2]) {
					char[]  row = new char[board.length];
					Arrays.fill(row, '.'); 
					row[c] = 'Q';
					board[r] = new String(row);
					cols[c] = true; //皇后所在列置为true，表示不能在该列放其他皇后
					d1[id1] = true;//皇后所在的捺置为true，同上
					d2[id2] = true;//皇后所在的撇置为true，同上
					helper(r+1,cols,d1,d2,board,res);
					cols[c] = false;
					d1[id1] = false;
					d2[id2] = false;
				}
			}
		}		
	}
	public static void main(String[] args) {
		List<String[]> res = solveNQueens(4);  //测试四皇后
		Iterator<String[]> it = res.iterator();
		while(it.hasNext()){
			for(String ms : it.next()) {				
				System.out.println(ms);
			}
			System.out.println("-----------------------");
		}
	}
}
