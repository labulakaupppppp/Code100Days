package written;

import java.util.Scanner;

public class Mi_001LinkList {
	//输出倒数第k个节点的值
	public static int list(ListNode head, int k) {
		ListNode slow = head;
		ListNode fast = head;
		for (int i = 0; i < k; i++) {
			fast = fast.m_pNext;
		}
		while (fast.m_pNext != null) {
			fast = fast.m_pNext;
			slow = slow.m_pNext;
		}
		System.out.println(slow.m_pNext.m_nKey);
		return slow.m_pNext.m_nKey;
	}

	public static void main(String[] args) {
		ListNode node1= new ListNode(1);
		ListNode node2=new ListNode(2);
		ListNode node3=new ListNode(3);
		ListNode node4 = new ListNode(4);
		ListNode node5 = new ListNode(5);
		ListNode node6 = new ListNode(6);
		ListNode node7 = new ListNode(7);
		node1.m_pNext=node2;
		node2.m_pNext=node3;
		node3.m_pNext=node4;
		node4.m_pNext=node5;
		node5.m_pNext=node6;
		node6.m_pNext=node7;
		node7.m_pNext=null;
		Scanner sc = new Scanner(System.in);
		int n=sc.nextInt();
//		ListNode  head= new ListNode(1);
//		while(sc.hasNext()) {
//			  ListNode node = new ListNode(sc.nextInt());
//			 node=node.m_pNext;
//		}
		list(node1,n);
	}
}
