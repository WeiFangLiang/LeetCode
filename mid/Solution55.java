package com.LeetCode.mid;

import java.util.ArrayList;
import java.util.List;

/**
 * 跳跃游戏
 * 		贪心：根据当前元素最远可跳的位置，那么就有很多跳的选择，
 * 				  贪心的选择跳到 可以使下一次跳到最远位置的  位置
 * @author WeiFangLiang
 *
 */
public class Solution55 {
	public boolean canJump(int[] nums) {
		List<Integer> index = new ArrayList<>();//index是最远可跳至的位置，是个数组
		for(int i = 0;i < nums.length;i++) {
			index.add(i + nums[i]); //index存储了nums数组每个元素可以跳到的最远位置的nums的索引
		}
		int jump = 0;//代表当前所处位置
		int maxIndex = index.get(0);//maxIndex存储可以使下一次跳到最远位置的  位置
		while(jump < index.size() && jump <= maxIndex) {//直到jump跳到数组尾部或jump超越了当前可以跳的最远位置
			if(maxIndex < index.get(jump))  maxIndex = index.get(jump);//如果可以跳的更远，就更新maxIndex
			jump++;//扫描jump
		}
		if(jump == index.size()) return true; //jump到达数组尾，返回真 
		return false;
    }
}
