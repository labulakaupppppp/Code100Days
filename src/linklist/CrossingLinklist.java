package linklist;

import structure.ListNode;

public class CrossingLinklist {
	/**
	 * @since 2018-7-31 1.判断链表是否有环 2.有环返回进入环的第一个节点 3.无环 返回null
	 */
	public static ListNode findFirstNode(ListNode head) {
		if (head == null)
			return null;
		if (head.next == head)
			return head;
		ListNode slow = head;
		ListNode fast = head;
		ListNode meet = null;
		while (fast != null) {
			if (fast.next != null && fast.next.next != null) {
				fast = fast.next.next;
				slow = slow.next;
				if (fast == slow) {
					meet = slow;
					break;
				}
			} else {
				return null;
			}
		}
		fast = head;
		while (fast != slow) {
			fast = fast.next;
			slow = slow.next;
		}
		return slow;
	}

	public static ListNode findFirstNode1(ListNode head) {
		if (head == null)
			return null;
		if (head.next == head)
			return head;
		ListNode slow = head;
		ListNode fast = head;
		ListNode meet = null;
		while (fast != null) {
			if (fast.next != null) {
				fast = fast.next;
				if (fast.next != null) {
					fast = fast.next;
					slow = slow.next;
					if (fast == slow) {
						meet = slow;
						break;
					}
				} else {
					return null;
				}
			} else {
				return null;
			}
		}
		fast = head;
		while (fast != slow) {
			fast = fast.next;
			slow = slow.next;
		}
		return slow;
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
		//l6.next = l2;
		l6.next=null;
		ListNode ans = findFirstNode(head);
		if (ans == null) {
			System.out.println("null");
		} else {
			System.out.println(ans.val);
		}

	}
}
