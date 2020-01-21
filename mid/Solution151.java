package com.LeetCode.mid;

import java.util.Arrays;
import java.util.Collections;

public class Solution151 {
	
	public String reverseWords(String s) {
		String[] words = s.trim().split(" +");//可匹配多个空格
		Collections.reverse(Arrays.asList(words));//words数组转为List，借用库函数
		return String.join(" ", words);//将集合中的元素 之间 添加 空格，并将集合转为字符串
    }
}
