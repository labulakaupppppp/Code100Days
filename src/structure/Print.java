package structure;

import java.util.Stack;

public class Print {
	public static void printListNode(ListNode head) {
		ListNode cur = head;
		while (cur != null) {
			System.out.print(cur.val+" ");
			cur = cur.next;
		}
	}
	
	public static void printStack(Stack<Integer> stack) {
		Stack<Integer> sta = stack;
		while (!sta.isEmpty()) {
			System.out.print(sta.pop() + " ");
		}
	}
}