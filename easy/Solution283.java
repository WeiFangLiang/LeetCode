package com.LeetCode.easy;

public class Solution283 {
	
	public void moveZeroes(int[] nums) {
        int j = 0;//记录下一个非0元素的存放位置
        for(int i = 0;i < nums.length;i++) {
        	if(nums[i] != 0) { //找到非零数
        		nums[j] = nums[i];//放到j位置上
        		if(i != j) {//如果不是一个位置的
        			nums[i] = 0;//那就和交换一个意思，i的值换到j上了，i需要置为0
        		}
        		j++;
        	}
        }
    }
	/**
	 * 思路：
    	遍历数组，无为0的元素移动数组前方，用index下标记录。
    	遍历结束，对index值后的元素统一设为0

	 * @param nums
	 */
	public void moveZeroes_2(int[] nums) {
		int index = 0;
		for(int num:nums){
			if(num!=0){
				nums[index++]=num;
			}
		}
		while(index<nums.length){
			nums[index++] = 0;
		}
    }
}
