package com.LeetCode.easy;

import java.util.HashMap;

public class Solution387 {
	
	public int firstUniqChar(String s) {
        if(s == null || s.length() == 0) return -1;
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i = 0;i < s.length();i++) {
        	if(map.containsKey(s.charAt(i))) {
        		Integer count = map.get(s.charAt(i));
        		map.put(s.charAt(i), count + 1);
        	}else {
        		map.put(s.charAt(i), 1);
        	}
        }
        for(int i = 0;i < s.length();i++) {
        	if(map.get(s.charAt(i)) == 1) return i;
        }
        return -1;
    }
	
	public int firstUniqChar2(String s) {
        int counter[] = new int[26];
        
        for(int i = 0; i < s.length(); i++) counter[s.charAt(i) - 'a']++;
        	
        for(int i = 0; i < s.length(); i++){
            if(counter[s.charAt(i) - 'a'] == 1) return i;
        }
        return -1;
    }
}
