package jianzhiOffer;

import structure.ListNode;

public class EntryNodeOfLoop_55 {
	/**
	 * 给一个链表，若其中包含环，请找出该链表的环的入口结点，否则，输出null。
	 * 
	 * @param pHead
	 * @return
	 */
	public static ListNode entryNodeOfLoop(ListNode pHead) {
		if (pHead == null || pHead.next == null) {
			return null;
		}
		if (pHead.next == pHead)
			return pHead;
		ListNode slow = pHead;
		ListNode fast = pHead;
		ListNode meet = slow;
		while (fast != null) {
			if (fast == null || fast.next == null)
				return null;
			if (fast.next != null && fast.next.next != null) {
				slow = slow.next;
				fast = fast.next.next;
				if (fast == slow) {
					meet = slow;
					break;
				}
			} else
				return null;
		}
		fast = pHead;
		while (fast != meet) {
			fast = fast.next;
			meet = meet.next;
		}
		return fast;

	}

	public static void main(String[] args) {
		ListNode head = new ListNode(0);
		ListNode l1 = new ListNode(1);
		ListNode l2 = new ListNode(2);
		ListNode l3 = new ListNode(3);
		ListNode l4 = new ListNode(4);
		ListNode l5 = new ListNode(5);
		ListNode l6 = new ListNode(6);
		head.next = l1;
		l1.next = l2;
		l2.next = l3;
		l3.next = l4;
		l4.next = l5;
		l5.next = l6;
		// 带环链表
		l6.next = l4;
		System.out.println(entryNodeOfLoop(head).val);

	}
}
