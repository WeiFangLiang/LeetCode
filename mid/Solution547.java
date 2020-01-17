package com.LeetCode.mid;

public class Solution547 {
	//方法1：DFS
	public int findCircleNum2(int[][] M) {
		int[] visited = new int[M.length];// visited[i] 表示 i 这个人是否被访问过
		int count = 0;
		for(int i = 0;i < M.length;i++) {
			if(visited[i] == 0) {//i 未被访问过
				dfs(M, visited, i); //探索 i 的朋友圈
				count++;
			}
		}
		return count;
	}
	
	private void dfs(int[][] M, int[] visited, int i) {
		// j 代表其他所有人
		for(int j = 0;j < M.length;j++) {//遍历 i 与其他所有人(包括自己)的朋友关系
			if(M[i][j] == 1 && visited[j] == 0) {
				visited[j] = 1;
				dfs(M, visited, j);
			}
		}
	}
	//方法2：并查集
	public int findCircleNum(int[][] M) {
		UnionFind us = new UnionFind(M.length);
		for(int i = 0;i < M.length;i++) {
			for(int j = 0;j <M[0].length;j++) {
				if(M[i][j] == 1) us.union(i, j);//i,j是朋友，则合并
			}
		}
        return us.count;
    }
}
//创建并查集，作为模板记住即可
class UnionFind{
	int count = 0;//集合的个数
	//parent[i] 表示 i 号集合的代表元素，之后我们就用代表元素区分不同的集合
	int[] parent;
	
	public UnionFind(int n) {//对于 n 个数
		count = n;//每个数都是一个孤立的集合
		parent = new int[n];
		for(int i = 0;i < n;i++) {
			//并查集最常见的初始化的方式
			parent[i] = i;//初始化每个集合的代表元素
		}
	}
	
	public int find(int p) { //给定一个数 p(p 属于 0--n-1),查找它所属的集合的代表元素
		while(p != parent[p]) {
			parent[p] = parent[parent[p]];//p 的爷爷 覆盖 p 的爸爸
			p = parent[p];//指向 爸爸
		}
		return p;
	}
	
	public void union(int p, int q) {
		int rootP = find(p);//找出 p 所在集合的代表元素
		int rootQ = find(q);
		if(rootP == rootQ) return;//说明处于同一个集合
		parent[rootP] = rootQ;
		count--;
	} 
}
