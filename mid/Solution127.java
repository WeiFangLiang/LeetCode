package com.LeetCode.mid;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution127 {
	
	public int ladderLength(String beginWord, String endWord, List<String> wordList_) {//将形参换个名
        Set<String> wordList = new HashSet<>(wordList_);//把字典换成哈希表，提高查询效率
        if(!wordList.contains(endWord)) return 0;
        
        Set<String> beginSet = new HashSet<String>();
        Set<String> endSet = new HashSet<String>();
        
        int len = 1;
        HashSet<String> visited = new HashSet<>();
        
        beginSet.add(beginWord);//起点集合
        endSet.add(endWord);//终点集合
        
        //双向BFS 
        while(!beginSet.isEmpty() && !endSet.isEmpty()) {
        	//我们优先扩展小的Set
        	if(beginSet.size() > endSet.size()) {//互换
        		Set<String> set = beginSet;
        		beginSet = endSet;
        		endSet = set;
        	}
        	Set<String> tmp = new HashSet<String>();//可以理解为BFS扩展的下一层
        	for(String word : beginSet) {//遍历起点集合中的单词
        		char[] cs = word.toCharArray();
        		for(int i = 0;i < cs.length;i++) {//对单词的每一位字符，进行 a--z 的替换
        			for(char c = 'a';c <= 'z';c++) {
        				char old = cs[i];//保存该单词 i 索引上的旧字符
        				cs[i] = c;//替换
        				String target = String.valueOf(cs);//得到新单词
        				if(endSet.contains(target)) {//找到了，这一句表明从中间会和了
        					return len + 1;
        				}
        				//字典中有这个新单词且没被访问过
        				if(!visited.contains(target) && wordList.contains(target)) {
        					tmp.add(target);
        					visited.add(target);
        				}
        				cs[i] = old;//还原 i 索引上的字符，进行下一次新字符的替换
        			}
        		}
        	}
        	//起点集合遍历完，指向下一层
        	beginSet = tmp;
        	len++;
        }
        //若出现一方集合为空，说明不存在可行的转换序列
        return 0;
    }
}
