package com.LeetCode.mid;
/**
 * 摆动序列
 * 		贪心算法：选择局部单调序列最后的元素，使得后面摇摆的可能最大化
 * @author WeiFangLiang
 *
 */
public class Solution376 {
	public int wiggleMaxLength(int[] nums) {
		//官方
		//[1,7,4,9,2,5]   6
        if(nums.length < 2) return nums.length;
        int prediff = nums[1] - nums[0]; //指示当前数字的序列是上升还是下降，暂定表示第一个数的状态
        int count = prediff != 0 ? 2 : 1;  //count作为结果序列的长度，prediff != 0则count至少为2，=0则count至少为1
        for(int i = 2;i < nums.length;i++) {
        	int diff = nums[i] - nums[i-1];
        	if((diff > 0 && prediff <= 0) || (diff < 0 && prediff >= 0)) {
        		count++; 
        		prediff = diff;
        	}
        }
        return count;
    }
}
