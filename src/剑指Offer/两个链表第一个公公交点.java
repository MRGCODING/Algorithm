package 剑指Offer;

import Offer.pojo.ListNode;

public class 两个链表第一个公公交点 {
	/*
	 * public class ListNode { int val; ListNode next = null;
	 * 
	 * ListNode(int val) { this.val = val; } }
	 */
	public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
		// 先遍历找出来长度
		int l1 = 0, l2 = 0;
		ListNode p1 = pHead1, p2 = pHead2;
		while (p1 != null) {
			l1++;
			p1 = p1.next;
		}
		while (p2 != null) {
			l2++;
			p2 = p2.next;
		}
		if (l1 < l2) {
			int len1 = l2 - l1;
			while (len1-- != 0) {
				pHead2 = pHead2.next;
			}
		} else {
			int len2 = l1 - l2;
			while (len2-- != 0) {
				pHead1 = pHead1.next;
			}
		}
		while (pHead1 != pHead2) {
			pHead1 = pHead1.next;
			pHead2 = pHead2.next;
		}
		// 长的先走差值
		return pHead2;
	}
}
