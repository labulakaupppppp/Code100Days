package linklist;

import java.util.Stack;

import structure.ListNode;

public class PalindromeLinkList {
	public static boolean isPalindrome1(ListNode head) {
		if (head == null || head.next == null)
			return true;
		Stack<ListNode> stack = new Stack<>();
		ListNode cur = head;
		ListNode fast = head;
		ListNode slow = head;
		// fast指定链表尾部。slow指向中间位置（后半部分的第一个节点）。
		while (fast.next != null && fast.next.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		// 将后半部分放入栈中
		while (slow != null) {
			stack.push(slow);
			slow = slow.next;
		}
		// 判断 链表左半部分 跟栈中 顶到底是否相同
		while (!stack.isEmpty()) {
			if (cur.val != stack.pop().val) {
				return false;
			} else {
				cur = cur.next;
			}
		}
		return true;
	}
	public static boolean isPalindrome2(ListNode head) {
		if (head == null || head.next == null)
			return true;
		//通过反转链表判断左右部分 是否相同，最后在将链表还原
		ListNode slow=head;
		ListNode fast=head;
		while(fast.next!=null && fast.next.next!=null) {
			slow=slow.next;
			fast=fast.next.next;
		}
		//翻转右半部分链表
		ListNode next=null;
		ListNode cur=slow.next;
		ListNode pre=null;
		while(cur!=null) {
			next=cur.next;
			cur.next=pre;
			pre=cur;
			cur=next;
		}
		ListNode lefthead=head;
		ListNode righthead=pre;
		boolean ans=true;
		while(lefthead!=null && righthead !=null) {
			if(lefthead.val!=righthead.val) {
				ans=false;
				break;
				
			}
			lefthead=lefthead.next;
			righthead=righthead.next;
			
		}
		ListNode p=null;
		while(pre!=null) {
			ListNode n=pre.next;
			pre.next=p;
			p=pre;
			pre=n;
		}
		return ans;
		
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
		System.out.println(isPalindrome2(head));
		ListNode head1 = new ListNode(1);
		ListNode l12 = new ListNode(2);
		ListNode l11 = new ListNode(3);
		ListNode l13 = new ListNode(2);
		ListNode l14 = new ListNode(1);
		head1.next = l12;
		l12.next = l11;
		l11.next = l13;
		l13.next = l14;
		l14.next = null;
		System.out.println(isPalindrome2(head1));

	}
}
