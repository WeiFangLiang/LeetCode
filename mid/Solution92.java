package com.LeetCode.mid;
/**
 * 反转链表II：
 * 		这是老师的解法，需要写出自己的解法才行
 * @author WeiFangLiang
 *
 */
public class Solution92 {
	//74% ，60%
	public ListNode reverseBetween(ListNode head, int m, int n) {
		 int change_len = n - m + 1; //计算需要逆置的节点个数
		 ListNode pre_head = null; //指向第一个逆置节点的前驱节点
		 ListNode result = head; //最终转换后的链表头结点，非特殊情况即为head
		 while(head != null && --m != 0) {
			 pre_head = head;
			 head = head.next;  // 此时 head 值指向逆置区间的首节点
		 }
		 ListNode tail = head; //指向逆置后的逆置区间的尾节点
		 ListNode new_head = null;  //指向逆置后的逆置区间的首节点
		 while(head != null && change_len != 0) {
			 ListNode next = head.next;
			 head.next = new_head;
			 new_head = head;
			 head = next;
			 change_len--;
		 }  // 此时 head 指向逆置段的后一个节点
		 tail.next = head; //逆置结束，连接逆置区间的链表尾与逆置段的后一个节点
		 if(pre_head != null) { //说明 m > 1
			 pre_head.next = new_head;  //将逆置后的逆置区间的首节点的前驱节点与首结点连接
		 }else {
			 result = new_head; //说明 最开始的while没执行，m == 1 , 则结果链表的头结点就是逆置区间的首节点
		 }
		 return result;
   }
	
	 // 74%，69% 自己想的
	 public static ListNode reverseBetween2(ListNode head, int m, int n) {
		 if(head == null) return head;
		 ListNode slow = head;
		 ListNode pre = null; //逆置区间的前一个节点
		 for(int i = 1;i < m;i++) {
			 pre = slow;
			 slow = slow.next;
		 }//slow指向逆置区间的首节点
		 ListNode fast = slow;
		 ListNode end = slow;
		 for(int i = 0;i < n-m;i++) {
			 fast = fast.next;
		 } // fast指向逆置区间的尾节点
		 ListNode next = fast.next; //逆置区间的下一个节点
		 ListNode pre_ni = null;
		 while(slow != next) {
			 ListNode next_ni = slow.next;
			 slow.next = pre_ni;
			 pre_ni = slow;
			 slow = next_ni;
		 }
		 if(pre == null) {
			 end.next = next;
			 return fast;
		 }else {
			 pre.next = fast;
			 end.next = next;
			 return head;
		 }
	 }
	 
	 public static void main(String[] args) {
		ListNode node5 = new ListNode(5);
		ListNode node4 = new ListNode(4);
		ListNode node3 = new ListNode(3);
		ListNode node2 = new ListNode(2);
		ListNode node1 = new ListNode(1);
		node4.next = node5;
		node3.next = node4;
		node2.next = node3;
		node1.next = node2;
		ListNode head = reverseBetween2(node1, 2, 4);
		while(head != null) {
			System.out.print(head.val + " ");
			head = head.next;
		}
	}
}
