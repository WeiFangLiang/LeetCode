package com.LeetCode.easy;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Solution136 {
	//26%  87%
	public static int singleNumber(int[] nums) {
		Map<Integer,Boolean> map = new HashMap<>();
        for(int i = 0;i < nums.length;i++) {
        	if(!map.containsKey(nums[i])) {
        		map.put(nums[i], true);
        	}else {
        		map.put(nums[i], false);
        	}
        }
        Set<Integer> keySet = map.keySet();
        for(Integer i : keySet) {
        	if(map.get(i) == true) {
        		return i;
        	}
        }
        return -1;
    }
	
	//牧马啦大佬   异或解法
	//99.88%	96.81%
	
	/**
        异或运算有以下几个特点：
         一个数和 0 做 XOR 运算等于本身：a⊕0 = a
         一个数和其本身做 XOR 运算等于 0：a⊕a = 0
   XOR 运算满足交换律和结合律：a⊕b⊕a = (a⊕a)⊕b = 0⊕b = b
       （就和消消乐一样，重复的都消掉了）
	 */
	public static int singleNumber2(int[] nums) {
		int ans = nums[0];
		if (nums.length > 1) {
		   for (int i = 1; i < nums.length; i++) {
		      ans = ans ^ nums[i];
		   }
		}
		return ans;
	}
	
	public static void main(String[] args) {
		int[] nums = {4,1,2,1,2};
		int res = singleNumber(nums);
		System.out.println(res);
	}
}
