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
		Map<String, ArrayList<String>> res = new HashMap<>();
		List<List<String>> result = new ArrayList<>();
		for(String s : strs) {  //遍历字符串数组，排序该字符串，若是异位词，则处理之后会落到同一个key中
			char[] cs = s.toCharArray();
			Arrays.sort(cs);
			String key = String.valueOf(cs); //s---cs---key都是指的同一个字符串
			if(!res.containsKey(key)) {
				ArrayList<String> tmp = new ArrayList<String>();
				tmp.add(s);//将原字符串加入，不要加key，因为key是该字符串处理完的版本
				res.put(key, tmp);
			}else{
				ArrayList<String> list = res.get(key);
				list.add(s);
				res.put(key, list);
			}
		}
		Set<String> keySet = res.keySet();
		for(String key : keySet) {
			result.add(res.get(key));
		}
		return result;
	}
}
