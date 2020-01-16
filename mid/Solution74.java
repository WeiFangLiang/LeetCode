package com.LeetCode.mid;

public class Solution74 {
	//37.5%  60.7%
	public boolean searchMatrix(int[][] matrix, int target) {
		if(matrix == null ||matrix.length == 0) return false;
		int m = matrix.length;
		int n = matrix[0].length;
		int[] arr = new int[m * n];
		int index = 0;
		for(int i = 0;i < m;i++) {
			for(int j = 0;j < n;j++) {
				arr[index++] = matrix[i][j];
			}
		}
		int low = 0;
		int high = arr.length - 1;
		while(low <= high) {
			int mid = low + (high - low) / 2;
			if(target == arr[mid]) {
				return true;
			} else if(arr[mid] > target) {
				high = mid - 1;
			} else {
				low = mid + 1;
			}
		}
		return false;
    }
	
	public boolean searchMatrix2(int[][] matrix, int target) {
		if(matrix == null ||matrix.length == 0) return false;
		int m = matrix.length;
		int n = matrix[0].length;
		int start = 0;//首行
		int end = m - 1;//末行
		while(start < end){
            int mid = (start + end + 1) / 2;//+1的妙处在于若中间值有两个，则取较大的那个
            if(matrix[mid][0] == target){
                return true;
            }else if(matrix[mid][0] > target){
                end = mid - 1;//如果该行首元素大于 target，则target一定在前面的行
            }else {
                start = mid;//如果该行首元素小于 target，则target可能位于该行，所以不能 mid + 1
            }
        }//循环结束时，start = end，也就是目标值所在行
		//对该行使用典型的二分
		int row = start;//记录目标值所在行
		start = 0;//重新初始化
		end = n - 1;
		while(start <= end) {
			int mid = start + (end - start) / 2;
			if(target == matrix[row][mid]) {
				return true;
			} else if(matrix[row][mid] > target) {
				end = mid - 1;
			} else {
				start = mid + 1;
			}
		}
		return false;
	}
}
