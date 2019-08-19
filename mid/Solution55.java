package com.LeetCode.mid;

/**
 * 跳跃游戏
 * 		贪心：根据当前元素最远可跳的位置，那么就有很多跳的选择，
 * 				  贪心的选择跳到 可以使下一次跳到最远位置的  位置
 * @author WeiFangLiang
 *
 */
public class Solution55 {
	public boolean canJump(int[] nums) {
		int[] index = new int[nums.length]; //index是最远可跳至的位置，是个数组
        for(int i = 0;i < nums.length;i++) {
        	index[i] = i + nums[i];  //index存储了nums数组每个元素可以跳到的最远位置的nums的索引
        }
        int jump = 0;//代表当前所处位置
        int maxIndex = index[0];//maxIndex存储可以使下一次跳到最远位置的  位置
		 /**
         * jump <= maxIndex 防止的是
         * nums = [3,2,1,0,4]      index = [3,3,3,3,8] 
         * 前四个位置最多到3号位置
         * maxIndex = 3
         * jump = 4 位置时，因为jump > maxIndex，走到了无法到达的位置，循环结束
         */
		while(jump < index.length && jump <= maxIndex) {//直到jump跳到数组尾部或jump超越了当前可以跳的最远位置
			if(maxIndex < index[jump])  maxIndex = index[jump];//如果可以跳的更远，就更新maxIndex
			jump++;//扫描jump
		}
		return jump == index.length;  //jump =  index.length 号元素，说明 index.length-1 即数组末尾元素是可达的
    }
}
