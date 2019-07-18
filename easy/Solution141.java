package com.LeetCode.easy;
/**
 * 检测单链表是否有环，已经掌握。
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
}
