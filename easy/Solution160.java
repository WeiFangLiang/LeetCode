package com.LeetCode.easy;

import java.util.HashSet;
import java.util.Set;

/**
 * 相交链表
 * @author WeiFangLiang
 *
 */
public class Solution160 {
	
	//自己想的，思路简单粗暴， 9%，15%
	public ListNode getIntersectionNode1(ListNode headA, ListNode headB) {
        Set<ListNode> set = new HashSet<>();
        ListNode p = headA;
        while(p != null) {
        	set.add(p);
        	p = p.next;
        }  // 把A链表的节点地址全加到 set中
        ListNode q = headB;
        while(q != null) {  //遍历B链表
        	if(set.contains(q)) {
        		return q;
        	}else {
        		q = q.next;
        	}
        }
        return null;
    }
	
	/**
	 * 在交点之前肯定是无交点的，交点之后就是一条链，
	 * 所以按照尾部对齐，从头开始，在同一起跑线同步对比
	 * @param headA
	 * @param headB
	 * @return
	 */
	// 96.53% ，5.56%
	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
		int lenA = 0, lenB = 0;
		ListNode p = headA, q = headB;
		while(p != null) {
			lenA++;
			p = p.next;
		}
		while(q != null) {
			lenB++;
			q = q.next;
		}
		p = headA;
		q = headB;
		int n = lenB - lenA;
		if(n > 0) {
			for(int i = 0;i < n;i++) {
				q = q.next;
			}
		}else {
			for(int i = 0;i < -n;i++) {
				p = p.next;
			}
		}
		while(p != null && q != null) {
			if(p == q) {
				return p;
			}else {
				p = p.next;
				q = q.next;
			}
		}
		return null;
	}
}
