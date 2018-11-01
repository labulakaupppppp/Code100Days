package jianzhiOffer;

import structure.ListNode;
import structure.Print;

public class DeleteDuplication {
	public static ListNode deleteDuplication(ListNode pHead) {
		if (pHead == null || pHead.next == null)
			return pHead;
		ListNode node = new ListNode(-1);
		ListNode first = pHead;
		node.next = first;
		ListNode pre = node;
		while (first!=null && first.next != null) {
			if (first.val == first.next.val) {
				int temp=first.val;
				while (first != null && first.val ==temp) {
					first = first.next;
				}
				pre.next = first;
			} else {
				pre = first;
				first = first.next;
			}
		}

		return node.next;

	}

	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		ListNode l2 = new ListNode(2);
		ListNode l31 = new ListNode(3);
		ListNode l32 = new ListNode(3);
		ListNode l33 = new ListNode(3);
		ListNode l4 = new ListNode(4);
		head.next = l2;
		l2.next = l31;
		l31.next = l32;
		l32.next = l33;
		l33.next = l4;
		l4.next = null;
		Print.printListNode(deleteDuplication(head));
	}
}
