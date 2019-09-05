package com.LeetCode.hard;
/**
 * 合并K个有序链表
 * @author WeiFangLiang
 *
 */
public class Solution23 {
	
	//这里为了用分治，所以把合并两个有序链表的代码粘在这
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
	// 评论区
	public ListNode mergeKLists(ListNode[] lists){
        if(lists.length == 0)
            return null;
        if(lists.length == 1)
            return lists[0];
        if(lists.length == 2){
           return mergeTwoLists(lists[0],lists[1]);
        }

        int mid = lists.length/2;
        ListNode[] l1 = new ListNode[mid];
        for(int i = 0; i < mid; i++){
            l1[i] = lists[i];
        }

        ListNode[] l2 = new ListNode[lists.length-mid];
        for(int i = mid,j=0; i < lists.length; i++,j++){
            l2[j] = lists[i];
        }

        return mergeTwoLists(mergeKLists(l1),mergeKLists(l2));

    }
}
