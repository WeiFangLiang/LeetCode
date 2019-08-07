package com.LeetCode.easy;

import java.util.HashMap;
import java.util.HashSet;

/**
 * 单词规律
 * 		别人的解法
 * @author WeiFangLiang
 *
 */
public class Solution290 {
	public boolean wordPattern(String pattern, String str) {
		if (pattern == null || str == null || str.length() == 0) return false; //先判空，严谨！
        String[] strings = str.split(" ");
        if (pattern.length() != strings.length) return false;
        HashMap<String, Character> map = new HashMap<>();
        HashSet<Character> sets = new HashSet<>();
        for (int i = 'a'; i < 'z' + 1; i++) {
            sets.add((char) i);
        }
        for (int i = 0; i < pattern.length(); i++) {
            if ( !map.containsKey(strings[i]) && sets.contains(pattern.charAt(i))){//若map中没有该单词且 set中有对应的pattern字符
                map.put(strings[i],pattern.charAt(i));//把单词和对应的pattern字符加入map
                sets.remove(pattern.charAt(i));//该字符用过了，移除
            }else {
                if (map.get(strings[i]) == null || !map.get(strings[i]).equals(pattern.charAt(i))) { //若value 与pattern字符不对应
                    return false;
                }
            }
        }
        return true;
	}
}
