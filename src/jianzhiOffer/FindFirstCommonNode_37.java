package jianzhiOffer;

import structure.ListNode;

public class FindFirstCommonNode_37 {
	public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
		if(pHead1==null ||pHead2==null)
			return null;
		ListNode temp1 = pHead1;
		int count = 0;
		while (temp1 != null) {
			temp1 = temp1.next;
			count++;
		}
		ListNode temp2 = pHead2;
		int len2 = 0;
		while (temp2 != null) {
			temp2 = temp2.next;
			count--;
		}
		ListNode long_list=pHead1;
		ListNode short_list =pHead2;
		if(count<0) {
			long_list=pHead2;
			short_list=pHead1;
			count=Math.abs(count);		
			}
		while(count>0) {
			long_list=long_list.next;
			count--;
		}
		while(long_list!=null && short_list!=null) {
			if(long_list==short_list)
				return long_list;
			long_list=long_list.next;
			short_list=short_list.next;
		}
		return null;
	}
}
