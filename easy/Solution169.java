package com.LeetCode.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * 求众数
 * 		本题解法众多，多看评论
 * @author WeiFangLiang
 *
 */
public class Solution169 {
	//第一想法：HashMap（是最优解，不会实现）
	public int majorityElement(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            if(!map.containsKey(nums[i])){
                map.put(nums[i], 1);   
            }else{
                map.put(nums[i], map.get(nums[i]) + 1);
            }
            if(map.get(nums[i]) > nums.length / 2){
                    return nums[i];
            }
        }
        return -1;
    }
}
