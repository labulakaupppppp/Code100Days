package structure;

import java.util.Queue;
import java.util.Stack;

public class Print {
	public static void printListNode(ListNode head) {
		ListNode cur = head;
		while (cur != null) {
			System.out.print(cur.val + " ");
			cur = cur.next;
		}
	}

	public static void printTreeNode(TreeNode root) {
		TreeNode cur = root;
		System.out.print("From left to right:");
		while (cur.right != null) {

			System.out.print(cur.val + " ");
			cur = cur.right;
		}
		TreeNode end=cur;
		System.out.print(cur.val);
		System.out.println();
		System.out.print("From left to right:");
		while (end != null) {
			System.out.print(end.val + " ");
			end = end.left;
		}
	}

	public static void printStack(Stack<Integer> stack) {
		Stack<Integer> sta = stack;
		while (!sta.isEmpty()) {
			System.out.print(sta.pop() + " ");
		}
	}

	public static void printQueue(Queue<TreeNode> queue) {
		Queue<TreeNode> queue1 = queue;
		while (!queue1.isEmpty()) {
			System.out.print(queue1.poll().val + " ");
		}
	}
}