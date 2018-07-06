package 剑指Offer;

import Offer.pojo.ListNode;

public class 合并两个排序链表递归 {
	public ListNode Merge(ListNode list1, ListNode list2) {
		ListNode pre = null;
		if (list1 == null)
			return list2;
		if (list2 == null)
			return list1;
		if (list1.val < list2.val) {
			pre = list1;
			pre.next = Merge(list1.next, list2);
		} else {
			pre = list2;
			pre.next = Merge(list1, list2.next);
		}
		return pre;
	}
}
