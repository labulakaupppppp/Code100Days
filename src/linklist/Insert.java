package linklist;

import structure.ListNode;
import structure.Print;

public class Insert {
//向有序链表插入节点
	public static ListNode insert(ListNode head, ListNode node) {
		if (head == null)
			return node;
		ListNode newHead = head;
		if (head.val > node.val) {
			node.next = head;
			return node;
		}

		while (head.next != null) {
			if (head.val < node.val) {
				head = head.next;
			} else {
				node.next = head.next;
				head.next = node;
				break;
			}
		}

		if (head.next == null) {
			head.next = node;
		}
		return newHead;
	}

	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		ListNode l2 = new ListNode(2);
		ListNode l3 = new ListNode(3);
		ListNode l4 = new ListNode(4);
		head.next = l2;
		l2.next = l3;
		l3.next = l4;
		l4.next = null;

		ListNode node = new ListNode(4);
		node.next = null;
		Print.printListNode((insert(head, node)));
	}
}
