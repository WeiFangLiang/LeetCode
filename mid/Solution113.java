package com.LeetCode.mid;

import java.util.ArrayList;
import java.util.List;

/**
 * 路径总和II
 * 			DFS+回溯
 * @author Administrator
 *
 */
public class Solution113 {
	//94.70%		46.74%
	public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> ans = new ArrayList<>();
        
        helper(root, sum, ans, new ArrayList<>());
        
        return ans;
    }

	private void helper(TreeNode node, int sum, List<List<Integer>> ans, List<Integer> path) {
		if(node == null) {
			return ;
		}
		//将沿途节点加入path中
		sum -= node.val;
		path.add(node.val);
		
		//遍历到叶节点
		if(node.left == null && node.right == null) {
			//如果这是一条可行的路径，才复制path的结果到 ans
			if(sum == 0) {
				ans.add(new ArrayList<>(path));
			}
		}else { // 若不是叶子节点
			helper(node.left, sum, ans, path);
			helper(node.right, sum, ans, path);
		}
		//回溯
		path.remove(path.size() - 1);
	}
}
