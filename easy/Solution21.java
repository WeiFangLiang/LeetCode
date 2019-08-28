package com.LeetCode.easy;


public class Solution21 {
	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		if (l1 == null) return l2;
		if (l2 == null) return l1;
		ListNode p = l1;
		ListNode q = l2;
		ListNode head = null;
		if(p.val < q.val) {
			head = p;
			p = p.next;
		}else {
			head = q;
			q = q.next;
		}
		ListNode r = head;
		while(p != null && q != null) {
			if(p.val < q.val) {
				r.next = p;
				p = p.next;
			}else {
				r.next = q;
				q = q.next;
			}
			r = r.next;
		}
		if(p != null) {
			r.next = p;
		}else {
			r.next = q;
		}
		return head;
    }
}
