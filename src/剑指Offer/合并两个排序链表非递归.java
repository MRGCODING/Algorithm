package 剑指Offer;

import Offer.pojo.ListNode;

public class 合并两个排序链表非递归 {
	public ListNode Merge(ListNode list1, ListNode list2) {
		if (list1 == null || list2 == null)
			return list1 != null ? list1 : list2;
		ListNode pre = null;
		ListNode next = null;
		ListNode head = list1.val < list2.val ? list1 : list2;
		ListNode cur1 = head == list1 ? list1 : list2;
		ListNode cur2 = head == list1 ? list2 : list1;
		while (cur1 != null && cur2 != null) {
			if (cur1.val <= cur2.val) {
				pre = cur1;
				cur1 = cur1.next;
			} else {
				next = cur2.next;
				pre.next = cur2;
				cur2.next = cur1;
				pre = cur2;
				cur2 = next;
			}
		}
		pre.next = cur1 == null ? cur2 : cur1;
		return head;
	}
}
