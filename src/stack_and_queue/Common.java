package stack_and_queue;

import java.util.Stack;

public class Common {
	public static void print(Stack<Integer> stack) {
		while (!stack.isEmpty()) {
			System.out.print(stack.pop() + " ");
		}
	}
}
