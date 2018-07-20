package code;

import structure.ListNode;

public class MergeSort {
	public static ListNode merge_sort(ListNode head) {
		if(head==null || head.next==null) {
			return head;
		}
		ListNode pre=null;
		ListNode slow=head;
		ListNode fast = head;
		while(fast!=null && fast.next!=null) {
			pre=slow;
			slow=slow.next;
			fast=fast.next.next;
		}
		pre.next=null;
		ListNode l1=merge_sort(head);
		ListNode l2=merge_sort(slow);
		ListNode list=merge(l1,l2);
		return list;
	}

	private static ListNode merge(ListNode l1, ListNode l2) {
		// TODO Auto-generated method stub
		if(l1==null)return l2;
		if(l2==null) return l1;
		ListNode list=new ListNode(-1);
		ListNode head=list;
		while(l1!=null && l2!=null) {
			if(l1.val<=l2.val) {
				list.next=l1;
				l1=l1.next;
			}else {
				list.next=l2;
				l2=l2.next;
			}
			list=list.next;
		}
		if(l1!=null)list.next=l1;
		if(l2!=null)list.next=l2;
		return head.next;
	}
	public static void print_linkList(ListNode head) {
		ListNode list=head;
		while(list!=null) {
			System.out.print(list.val+" ");
			list=list.next;
		}
		System.out.println();
	}
	public static void main(String[] args) {
		ListNode head=new ListNode(2);
		ListNode l1= new ListNode(1);
		ListNode l2=new ListNode(5);
		ListNode l3 =new ListNode(0);
		ListNode l4=new ListNode(9);
		ListNode l5= new ListNode(3);
		head.next=l1;
		l1.next=l2;
		l2.next=l3;
		l3.next=l4;
		l4.next=l5;
		l5.next=null;
		merge_sort(head);
		print_linkList(head);
	}
}
