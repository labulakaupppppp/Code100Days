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

	public static ListNode noLoop(ListNode head1, ListNode head2) {
		ListNode cur1 = head1;
		ListNode cur2 = head2;
		int len = 0;
		while (cur1.next != null) {
			len++;
			cur1 = cur1.next;
		}
		while (cur2.next != null) {
			len--;
			cur2 = cur2.next;
		}
		if (cur1 != cur2)
			return null;

		cur1 = len >= 0 ? head1 : head2;
		cur2 = cur1 == head1 ? head2 : head1;
		len = Math.abs(len);
		while (len > 0) {
			len--;
			cur1 = cur1.next;
		}
		while (cur1 != cur2) {
			cur1 = cur1.next;
			cur2 = cur2.next;
		}
		return cur1;
	}

	public static ListNode allCircle(ListNode head1, ListNode loop1, ListNode head2, ListNode loop2) {
		ListNode cur1 = null;
		ListNode cur2 = null;
		if (loop1 == loop2) {
			// 相同位置入环，则只需看head到loop之间的节点在何处相交，就相当于两个无环链表找到相交节点问题。
			cur1 = head1;
			cur2 = head2;
			int len = 0;
			while (cur1 != loop1) {
				len++;
				cur1 = cur1.next;
			}
			while (cur2 != loop2) {
				len--;
				cur2 = cur2.next;
			}

			cur1 = len >= 0 ? head1 : head2;
			cur2 = cur1 == head1 ? head2 : head1;
			len = Math.abs(len);
			while (len > 0) {
				len--;
				cur1 = cur1.next;
			}
			while (cur1 != cur2) {
				cur1 = cur1.next;
				cur2 = cur2.next;
			}
			return cur1;

		}
		// 入环位置不相同则有两种情况：
		// 1. 两个带环链表无交点；2 分别从loop1 与loop2入环
		else {
			cur1 = loop1.next;
			while (cur1 != loop1) {
				if (cur1 == loop2)
					return loop2;
				cur1 = cur1.next;
			}
			return null;
		}
	}

	public static ListNode getCrossMain(ListNode head1, ListNode head2) {
		if (head1 == null || head2 == null)
			return null;
		ListNode loop1 = findFirstNode(head1);
		ListNode loop2 = findFirstNode(head2);
		if (loop1 == null && loop2 == null) {
			return noLoop(head1, head2);
		} else if (loop1 != null && loop2 != null) {
			return allCircle(head1, loop1, head2, loop2);
		} else {
			return null;
		}
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
		//l6.next = l4;
		
		//不带环
		 l6.next = null;
		ListNode head_1 = new ListNode(0);
		ListNode l1_1 = new ListNode(1);
		ListNode l2_1 = new ListNode(2);
		ListNode l3_1 = new ListNode(3);
		ListNode l4_1 = new ListNode(4);
		ListNode l5_1 = new ListNode(5);
		ListNode l6_1 = new ListNode(6);
		head_1.next = l1_1;
		l1_1.next = l2_1;
		l2_1.next = l3_1;
		l3_1.next = l4;
		ListNode ans = getCrossMain(head, head_1);
		if (ans == null) {
			System.out.println("null");
		} else {
			System.out.println(ans.val);
		}

	}
}
