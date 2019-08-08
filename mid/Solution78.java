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
		List<List<Integer>> ans = new ArrayList<>();
	    getAns(nums, 0, new ArrayList<>(), ans);
	    return ans;
	}

	private static void getAns(int[] nums, int start, ArrayList<Integer> temp, List<List<Integer>> ans) { 
	    ans.add(new ArrayList<>(temp));
	    for (int i = start; i < nums.length; i++) {
	        temp.add(nums[i]);
	        getAns(nums, i + 1, temp, ans);
	        temp.remove(temp.size() - 1);
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
