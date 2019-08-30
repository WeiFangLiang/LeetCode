package com.LeetCode.mid;
/**
 * 分隔链表
 * @author WeiFangLiang
 *
 */
public class Solution86 {
	// 99.87%  ，57.14%
	public ListNode partition(ListNode head, int x) {
		ListNode less_head = new ListNode(0);  //定义俩临时链表的头节点
		ListNode more_head = new ListNode(0);
		ListNode less_ptr = less_head;  // 定义俩指针指向这俩头节点，用于指针移动
		ListNode more_ptr = more_head;
		while(head != null) {
			if(head.val < x) {
				less_ptr.next = head;  // 小于目标值，插在 less_ptr后面
				less_ptr = head;  //less_ptr后移，保证指向该临时链表的末尾
			}else {
				more_ptr.next = head;
				more_ptr = head;
			}
			head = head.next;
		}
		less_ptr.next = more_head.next;
		more_ptr.next = null;
		return less_head.next;
    }
}
