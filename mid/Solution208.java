package com.LeetCode.mid;
/**
 * 实现字典树（Trie、前缀树）
 * @author WeiFangLiang
 *
 */
public class Solution208 {
}

class Trie{
	private TrieNode root;
	
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