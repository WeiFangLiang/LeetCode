package com.LeetCode.mid;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * 子集
 * 		windliang和liweiwei1419的解法挺好
 * @author WeiFangLiang
 *
 */
public class Solution78 {
	//解法三、回溯法
	public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>(); //存放最终结果
        generate(nums, 0, new ArrayList<Integer>(), result); //回溯求解，从0号元素考虑 放与不放
        return result;
	}

	private static void generate(int[] nums, int start, ArrayList<Integer> item, List<List<Integer>> result) {
		result.add(new ArrayList<>(item)); //把子集复制一份加入结果集
		for(int i = start;i < nums.length;i++) { //遍历数组
			item.add(nums[i]); //将这个元素  放入  子集
			generate(nums, i+1, item, result); //接着回溯后续情况
			item.remove(item.size()-1);  // 将这个元素  不放入  子集，考虑下个元素的回溯
		}
	}
	
	public static void main(String[] args) {
		int[] nums = {1,2,3};
		List<List<Integer>> result = subsets(nums);
		Iterator<List<Integer>> it = result.iterator();
		while(it.hasNext()) {
			System.out.println(it.next().toString());
		}
	}
}
