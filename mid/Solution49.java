package com.LeetCode.mid;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Solution49 {
	//89%   99%
	public List<List<String>> groupAnagrams(String[] strs) {
		if(strs.length == 0) return new ArrayList<>();
		//每一组字母异位词都具有相同的key，value就是该组异位词
		Map<String, ArrayList<String>> map = new HashMap<>();
		List<List<String>> result = new ArrayList<>();
		for(String s : strs) {  //遍历字符串数组，排序该字符串，若是异位词，则处理之后会落到同一个key中
			char[] cs = s.toCharArray();
			Arrays.sort(cs);
			String key = String.valueOf(cs); //s---cs---key都是指的同一个字符串
			if(!map.containsKey(key)) {
				ArrayList<String> tmp = new ArrayList<String>();
				tmp.add(s);//将原字符串加入，不要加key，因为key是该字符串处理完的版本
				map.put(key, tmp);
			}else{
				ArrayList<String> list = map.get(key);
				list.add(s);
				map.put(key, list);
			}
		}
		Set<String> keySet = map.keySet();
		for(String key : keySet) {
			result.add(map.get(key));
		}
		return result;
	}
	/**
	 * count[26 ] 数组，代表不同的26个字母，数组元素代表对应字母出现的次数，
	 * 主要思想是每个异位词字符串对应的count数组应该是一样的，再将该count遍历为String作为key
	 * value就是该key对应的一组异位词
	 * 和上面方法的不同：
	 * 	上面的是，异位词排序后应该落到同一个key中
	 * @param strs
	 * @return
	 */
	//19%   82%  
	public List<List<String>> groupAnagrams1(String[] strs) {
		if(strs.length == 0) return new ArrayList<>();
		Map<String, ArrayList<String>> map = new HashMap<>();
		List<List<String>> result = new ArrayList<>();
		int[] count = new int[26];
		for(String s : strs) {
			Arrays.fill(count, 0);//count数组需要重复使用，所以每次需要先赋值0
			for(char c : s.toCharArray()) {
				count[c - 'a']++;
			}
			StringBuilder sb = new StringBuilder();
			for(int i = 0;i < 26;i++) {//遍历count数组
				//#11#1   #1#11
				sb.append("#");//加这么一个间隔符，是防止 (a...a,b)11 1和 (a,b...b)1 11这样的非异位词产生相同的count
				sb.append(count[i]);
			}
			//异位词具有相同的key
			String key = sb.toString();//处理过程：s-->sb-->key 
			if(!map.containsKey(key)) {
				ArrayList<String> tmp = new ArrayList<String>();
				tmp.add(s);//将原字符串加入，不要加key，因为key是该字符串处理完的版本
				map.put(key, tmp);
			}else{
				ArrayList<String> list = map.get(key);
				list.add(s);
				map.put(key, list);
			}
		}
		Set<String> keySet = map.keySet();
		for(String key : keySet) {
			result.add(map.get(key));
		}
		return result;
	}
}
