package com.LeetCode.easy;

public class Solution283 {
	
	public void moveZeroes(int[] nums) {
        int j = 0;//记录下一个非0元素的存放位置
        for(int i = 0;i < nums.length;i++) {
        	if(nums[i] != 0) { //找到非零数
        		nums[j] = nums[i];//放到j位置上
        		if(i != j) {//如果不是一个位置的
        			nums[i] = 0;//那就和交换一个意思
        		}
        		j++;
        	}
        }
    }
}
