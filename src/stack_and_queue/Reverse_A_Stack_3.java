package stack_and_queue;

import java.util.Stack;

public class Reverse_A_Stack_3 {
	public static int getAndRemoveLastElement(Stack<Integer> stack) {
		//每执行一次该函数，last为栈底元素，栈变为除去栈底元素剩余的元素。
		//如 第一次执行前 栈顶到底为：5，4，3，2，1 执行后：last=1 栈为：5，4，3，2
		int result = stack.pop();
		if (stack.isEmpty()) {
			return result;
		} else {
			int last = getAndRemoveLastElement(stack);
			System.out.println("last"+last);
			System.out.println("result"+result);
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
		stack.push(5);
		stack.push(1);
		stack.push(2);
		stack.push(3);
		stack.push(7);
		reverse(stack);
		print(stack);
		System.out.println("~~~~~~~~~~``");
		Integer res =30 / 60 ;
        System.out.println(res);
	}
}
