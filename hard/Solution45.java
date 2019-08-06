package com.LeetCode.hard;
/**
 * 跳跃游戏II
 * 		贪心：只在必须跳的时候跳
 * @author WeiFangLiang
 *
 */
public class Solution45 {
	public int jump(int[] nums) {
		if(nums.length < 2) return 0; //长度小于2，不跳跃
		int currentMaxIndex = nums[0];//当前可达到的最远位置，本质是nums[i]+i，最远位置 的nums的索引
		int preMaxMaxIndex = nums[0];//遍历各个位置过程中，可达到的最远位置,nums[i]+i
		int jumpMin = 1;
		for(int i = 0;i < nums.length;i++) {
			if(i > currentMaxIndex) {//若无法向前移动了，才跳跃
				jumpMin++;
				currentMaxIndex = preMaxMaxIndex;//更新当前可达到的最远位置
			}
			if(preMaxMaxIndex < nums[i] + i) {
				preMaxMaxIndex = nums[i] + i; //记录了0-i 之间的可达到的最远位置
			}
		}
		return jumpMin;
	}
}
