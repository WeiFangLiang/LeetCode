package com.LeetCode.easy;
/**
 * 删除排序数组中的重复项
 * 		小结:
 * 				1、要求时间复杂度O(1)，那就不能利用其他数据结构了
 * 				还是官方的解答言简意赅！！
 * @author WeiFangLiang
 *
 */
public class Solution26 {
	public static int removeDuplicates(int[] nums) {
        //[0,0,1,1,1,2,2,3,3,4] ---> [0,1,2,3,4]  返回数组长度
		int i = 0;
		int index = 0;
		int j = 1;
		int n = nums.length;
		if(n < 2) {   //先用 if 处理 少数情况
			return n;
		}
		for(;j < n;j++) {
			while(nums[i] == nums[j]) {
				j++;
				if(j >= n) {  
					return index + 1;  
				}
			}
			index++;
			nums[index] = nums[j];
			i = j;
		}
		return index+1;
	}
	public static void main(String[] args) {
		int[] nums = {1,1,2};
		int newLen = removeDuplicates(nums);
		for(int i = 0;i < newLen;i++) {
			System.out.print(nums[i] + " ");
		}
	}
}
