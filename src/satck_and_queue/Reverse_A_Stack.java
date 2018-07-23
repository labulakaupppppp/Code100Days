package satck_and_queue;

import java.util.Stack;

public class Reverse_A_Stack {
	public static int getAndRemoveLastElement(Stack<Integer> stack) {
		int result = stack.pop();
		if (stack.isEmpty()) {
			return result;
		} else {
			int last = getAndRemoveLastElement(stack);
			stack.push(result);
			return last;
		}
	}

	public static void reverse(Stack<Integer> stack) {
		if (stack.isEmpty())
			return;
		int i = getAndRemoveLastElement(stack);
		reverse(stack);
		stack.push(i);
	}

	public static void print(Stack<Integer> stack) {
		while (!stack.isEmpty()) {
			System.out.print(stack.pop() + " ");
		}
	}

	public static void main(String[] args) {
		Stack<Integer> stack = new Stack<>();
		stack.push(1);
		stack.push(2);
		stack.push(3);
		reverse(stack);
		print(stack);
	}
}
