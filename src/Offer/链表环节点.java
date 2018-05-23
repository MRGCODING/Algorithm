package Offer;

import Offer.pojo.ListNode;

public class 链表环节点 {
	public ListNode EntryNodeOfLoop(ListNode pHead) {
		// 判断环的存在
		if (pHead == null)
			return null;
		ListNode low = pHead.next;
		if (low == null)
			return null;
		ListNode fast = low.next;
		if (fast == null)
			return null;
		while (low != null && fast != null) {
			low = low.next;
			fast = fast.next.next;
			if (low == fast)
				break;
		}
		// 环的大小
		int count = 1;
		ListNode temp = low;
		low = low.next;
		while (low != temp) {
			count++;
			low = low.next;
		}
		// 环的入口节点
		low = pHead;
		fast = pHead;
		for (int i = 0; i < count; i++)
			fast = fast.next;
		while (low != fast) {
			low = low.next;
			fast = fast.next;
		}
		return low;
	}
}
