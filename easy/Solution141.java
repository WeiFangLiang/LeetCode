package com.LeetCode.easy;

import java.util.HashSet;
import java.util.Set;

/**
 * 检测单链表是否有环，已经掌握。
 * 		小结：
 * 			除了快慢指针之外，还有两种不太好的方法
 * 			1、硬算。遍历链表，设置时间阈值，如果超过1s还没结束，就是有环。
 * 			2、利用集合。遍历链表，将结点值存到Map或Set中，之后每次进行判断，若重复，则有环。
 * @author WeiFangLiang
 *
 */
public class Solution141 {
	public boolean hasCycle(ListNode head) {
	        if(head == null) {
	        	return false;
	        }
	        ListNode fast = head.next;
	        ListNode slow = head;
	        while(fast != null && fast.next != null) {
	        	fast = fast.next.next;
	        	slow = slow.next;
	        	if(fast == slow) {
	        		return true;
	        	}
	        }
	        return false;
	 }
	//借助Set  12%   95%
	public boolean hasCycle2(ListNode head) {
		Set<ListNode> set = new HashSet<>();
		if(head == null) {
			return false;
		}
		ListNode cur = head;//记录当前遍历的节点
		while(cur.next != null) {
			if(set.contains(cur)) {//如果set中有了，说明之前遍历过
				return true;//那肯定就是有环
			}else {//若set中没有，则加入set中
				set.add(cur);
			}
			cur = cur.next;
		}
		return false;
	}
}
