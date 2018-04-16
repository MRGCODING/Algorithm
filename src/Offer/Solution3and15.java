package Offer;

import java.util.ArrayList;

import Offer.pojo.ListNode;

public class Solution3and15 {
	public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
		ListNode head = listNode;
		ListNode pre = null;
		ListNode next = null;
		ArrayList<Integer> res = new  ArrayList<Integer>();
		while (head != null) {
			ListNode temp = head.next;
			head.next = pre;
			pre = head;
			head = temp;
			res.add(0,head.val);
		}
		return res;
	}
}