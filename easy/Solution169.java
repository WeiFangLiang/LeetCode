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
	//方法2：摩尔投票法 
	/**
	 * 设置两个变量 candidate 和 count，candidate 用来保存数组中遍历到的某个数字，count 表示当前数字的出现次数，
	 * 一开始 candidate 保存为数组中的第一个数字，count 为 1
		遍历整个数组
	如果数字与之前 candidate 保存的数字相同，则 count 加 1
	如果数字与之前 candidate 保存的数字不同，则 count 减 1
	如果出现次数 count 变为 0 ，candidate 进行变化，保存为当前遍历的那个数字，并且同时把 count 重置为 1
	遍历完数组中的所有数字即可得到结果
	 * @param nums
	 * @return
	 */
	//100%       81%
	public static int majorityElement2(int[] nums) {
		int candidate = nums[0];
		int count = 1;//初始化这俩变量
		for(int i = 1;i < nums.length;i++) {//遍历数组
			if(count == 0) { //如果之前的抵消为0，则说明之前的candidate肯定不是最终结果，从当前位置重新开始计数
				candidate = nums[i];//重新初始化
				count = 1;
				continue;//这个nums[i]就算是处理完了，跳过这次循环
			}
			if(nums[i] == candidate) {
				count++;
			}else {
				count--;
			}
		}
		return candidate;
	}
	public static void main(String[] args) {
		int[] nums = {2,2,1,1,1,2,2};
		int res = majorityElement2(nums);
		System.out.println(res);
	}
}
