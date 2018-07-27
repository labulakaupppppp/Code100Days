package stack_and_queue;

import java.util.Stack;
import stack_and_queue.*;

public class SortStackByStack_5 {

	public static void sort_by_stack(Stack<Integer> stack) {
		Stack<Integer> temp = new Stack<>();
		while (!stack.isEmpty()) {
			int cur = stack.pop();
			while (!temp.isEmpty() && temp.peek() >= cur) {
				stack.push(temp.pop());
			}
			temp.push(cur);
		}
		while (!temp.isEmpty()) {
			stack.push(temp.pop());
		}

	}

	public static void main(String[] args) {
		Stack<Integer> stack = new Stack<>();
		stack.push(5);
		stack.push(2);
		stack.push(3);
		sort_by_stack(stack);
		Common com = new Common();

		com.print(stack);
	}
}
