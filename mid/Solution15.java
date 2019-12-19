package com.LeetCode.mid;

import java.util.ArrayList;
import java.util.Arrays;
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
	//1、暴力三重循环     最长的一个用例5800毫秒，超时
	public List<List<Integer>> threeSum1(int[] nums) {
		Arrays.sort(nums);
		List<List<Integer>> result = new ArrayList<>();
		for(int i = 0;i < nums.length;i++) {
			int target = -nums[i];
			for(int j = i + 1;j < nums.length;j++) {
				for(int k = j + 1;k < nums.length;k++) {
					if(target == nums[j] + nums[k]) {
						ArrayList<Integer> tmp = new ArrayList<>();
						tmp.add(nums[i]);
						tmp.add(nums[j]);
						tmp.add(nums[k]);
						if(!result.contains(tmp)) {	//这样的去重可以说很无脑了						
							result.add(tmp);
						}
					}
				}
			}
		}
		return result;
    }
	//2、hash表
	
	//3、左右指针    固定nums[i]   左右指针向中间逼近
	public List<List<Integer>> threeSum2(int[] nums) {
		Arrays.sort(nums);
		List<List<Integer>> result = new ArrayList<>();
		int len = nums.length;
		if(nums == null || len < 3) {
			return result;
		}
		for(int i = 0;i < nums.length;i++) {
			if(nums[i] > 0) {
				break;
			}
			if(i > 0 && nums[i] == nums[i - 1]) {//和前面的target一样，说明已经算过了
				continue;
			}
			int target = -nums[i];
			for(int l = i + 1, r = nums.length - 1;l < r; ) {//l：左指针    r：右指针
				if(target == nums[l] + nums[r]) {//符合和为0
					ArrayList<Integer> tmp = new ArrayList<>();
					tmp.add(nums[i]);
					tmp.add(nums[l]);
					tmp.add(nums[r]);
					result.add(tmp);
					while(l < r && nums[l] == nums[l + 1]) {//如果和为0，考虑去重
						l++;//只要左指针与下一个元素相等，就一直右移动左指针
					}
					while(l < r && nums[r] == nums[r - 1]) {
						r--;//只要右指针与上一个元素相等，就一直左移动右指针
					}
					l++;
					r--;
				}else if(target < nums[l] + nums[r]) {//左右指针和太大，左移动右指针，指向更小的数
					r--;
				}else {
					l++;
				}
			}
		}
		return result;
	}
}
