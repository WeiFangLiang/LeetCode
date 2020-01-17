package com.LeetCode.hard;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class Solution212 {
	
	public List<String> findWords(char[][] board, String[] words) {
		Trie trie = new Trie();
		for(String word : words) {//构建Trie树
			trie.insert(word);
		}
		//使用set存储最终结果，去重
		Set<String> result = new HashSet<>();
		int row = board.length;
		int col = board[0].length;
		boolean[][] visited = new boolean[row][col];//表示board中的每个字符是否访问过
		//遍历 board 
		for(int i = 0;i < row;i++) {
			for(int j = 0;j < col;j++) {
				//以当前字符进行dfs
				dfs(board, i, j, trie.root, visited, "", result);
			}
		}
		return new ArrayList<String>(result);
    }

	private void dfs(char[][] board, int i, int j, TrieNode cur, boolean[][] visited, String tmp, Set<String> result) {
		//边界处理
		if(i < 0 || j < 0 || i >= board.length || j >= board[0].length || visited[i][j]) return ;
		cur = cur.children[board[i][j] - 'a'];
		if(cur == null) return;//当前字符和字典树不匹配
		//当前字符和字典树匹配的话
		tmp = tmp + cur.val;//记录当前节点的值
		//匹配到单词了
		if(cur.isWord) result.add(tmp);
		visited[i][j] = true;//标记为 访问
		//从当前字符向四周回溯
		dfs(board, i - 1, j, cur, visited, tmp, result);//向上
		dfs(board, i + 1, j, cur, visited, tmp, result);//向下
		dfs(board, i, j - 1, cur, visited, tmp, result);//向左
		dfs(board, i, j + 1, cur, visited, tmp, result);//向右
		//同一个单元格内的字母在一个单词中不允许被重复使用(所以限制的是同一次dfs过程中不能重复使用)
		visited[i][j] = false;//最后要回退，因为下一个单词可以使用到上一个单词中的的字符
	}
}

//以下208题的答案
class Trie{
	TrieNode root;
	
	public Trie() {
		root = new TrieNode('/');//存储无意义字符
	}
	
	public void insert(String word) {
		TrieNode p = root;//游走指针 p
		for(int i = 0;i < word.length();i++) {
			char c = word.charAt(i);
			if(p.children[c-'a'] == null) {
				p.children[c-'a'] = new TrieNode(c);
			}
			p = p.children[c-'a'];
		}
		p.isWord = true;
	}
	
	public boolean search(String word) {
		TrieNode p = root;
		for(int i = 0;i < word.length();i++) {
			char c = word.charAt(i);
			if(p.children[c-'a'] == null) return false;
			p = p.children[c-'a'];
		}
		return p.isWord;
	}
	
	public boolean startsWith(String prefix) {
		TrieNode p = root;
		for(int i = 0;i < prefix.length();i++) {
			char c = prefix.charAt(i);
			if(p.children[c-'a'] == null) return false;
			p = p.children[c-'a'];
		}
		return true;
	}
}
//节点类
class TrieNode{
	public char val;
	public boolean isWord;
	public TrieNode[] children = new TrieNode[26];
	
	public TrieNode() {
		
	}
	public TrieNode(char c) {
		val = c;
	}
}