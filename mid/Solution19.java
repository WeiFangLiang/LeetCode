package com.LeetCode.mid;
/**
 * 删除链表倒数第N个结点
 * 		小结：
 * 				先用 if，处理掉少数情况，省时间还不容易出 bug
 * @author WeiFangLiang
 *
 */
public class Solution19 {
	//2ms
	public ListNode removeNthFromEnd(ListNode head, int n) {
	        //1-->2-->3-->4-->5-->6-->7  n=5     ===>     1-->2-->4-->5-->6-->7  
		int size = 1;
		ListNode count = head;
		while(count.next != null) {  //先统计链表长度
			count = count.next;
			size++;
		}
		if(n == size) {    //防的就是删除头结点的情况
			head = head.next;
			return head;
		}
		ListNode now = head;   //定义两个结点，一前一后
		ListNode nextNode = head;
		for(int i = 0;i < n;i++) {
			nextNode = nextNode.next;
		}
		while(nextNode.next != null) {  //循环结束时，now指向目标节点的前驱结点
			now = now.next;
			nextNode = nextNode.next;
		}
		now.next = now.next.next;
		return head;
	}
	// 王铮大神版  1ms  99.8%，86%
	public ListNode removeNthFromEnd2(ListNode head, int n) {
        ListNode fast = head;
		 int i = 1;
		 while(fast != null && i < n) {
			 fast = fast.next;
			 ++i;
		 }
		 if (fast == null) return head;
		 ListNode slow = head;
		 ListNode pre = null;
		 while(fast.next != null) {
			 fast = fast.next;
			 pre = slow;
			 slow = slow.next;
		 }
		 if(pre == null) {
			 head = head.next;
		 }else {
			 pre.next = pre.next.next;
		 }
		 return head;
    }
}
