package com.LeetCode.mid;

public class Solution55 {
	//方法1    62%   95%
	public boolean canJump(int[] nums) {
		int max = 0; //保存目前为止的最远可达位置，初始化为0，因为0一定是可达的
        for (int i = 0; i < nums.length; i++) {
	        if (i > max) return false; //如果当前位置超出了最远可达位置，返回false
	        // i + nums[i] 表示从 i 位置能跳到的最远位置
            max = Math.max(max, nums[i] + i);//可达，则更新max
        }
        return true;
	}

	//方法2：从后往前贪心     100%   87%
	public boolean canJump2(int[] nums) {
		if(nums == null) return false;
		int endReachable = nums.length - 1;//该变量是能够到达数组尾部的 最小位置，初始为 nums.length - 1
		for(int i = nums.length - 1; i>= 0;i--) {//从后往前遍历
			//我们总是贪心的去记录能到达数组尾部的 更小的位置，这样到最后我们记录的就是能到达数组尾部的最小的位置
			if(i + nums[i] >= endReachable) endReachable = i;//只要从当前位置 i 能够到达数组尾部，就更新 i
		}
		return endReachable == 0;
	}
}
