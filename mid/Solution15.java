package com.LeetCode.mid;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 三数之和(这道题我不会做)
 * 		原因：
 * 			1、没审清题，没注意到不能含有重复的，而且没想过还得先给数组排序
 * 			2、解题太巧妙，确实想不到
 * 		ps: 斩获新的方法     Arrays.asList(v1,v2,v3)  参数最好是引用类型，返回一个[v1,v2,v3] 的数组List
 * @author WeiFangLiang
 *
 */
public class Solution15 {
	public static List<List<Integer>> threeSum(int[] nums) {
		int size = nums.length;
        if(size < 3) {
        	return null;
        }
       // nums = [-1, 0, 1, 2, -1, -4]， [ [-1, 0, 1],   [-1, -1, 2] ]
        List<List<Integer>> list = new LinkedList<>(); // list是外面的数组，数组元素是符合结果的 小数组
        int i = 0;
        for(;i < size-2;i++) {
        	int j = i + 1;
        	for(;j < size-1;j++) {
        		int k =  j + 1; 
        		for(;k < size;k++) {
        			if((nums[i] + nums[j] + nums[k]) == 0) {
        				List<Integer> list0 = new ArrayList<>(3);
        				list0.add(nums[i]);
        				list0.add(nums[j]);
        				list0.add(nums[k]);
        				list.add(list0);
        			}
        		}
        	}
        }
        return list;
    }
	public static void main(String[] args) {
		int[] nums = {-7,-10,-1,3,0,-7,-9,-1,10,8,-6,4,14,-8,9,-15,0,-4,-5,9,11,3,
				-5,-8,2,-6,-14,7,-14,10,5,-6,7,11,4,-7,11,11,7,7,-4,-14,-12,-13,-14,4,
				-13,1,-15,-2,-12,11,-14,-2,10,3,-1,11,-5,1,-2,7,2,-10,-5,-8,-10,14,10,13,
				-2,-9,6,-7,-7,7,12,-5,-14,4,0,-11,-8,2,-6,-13,12,0,5,-15,8,-12,-1,-4,-15,
				2,-5,-9,-7,12,11,6,10,-6,14,-12,9,3,-10,10,-8,-2,6,-9,7,7,-7,4,-8,5,-4,8,0,3,11,0,-10,-9};
		List<List<Integer>> result = threeSum(nums);
		
	}
}
