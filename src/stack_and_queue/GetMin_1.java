package stack_and_queue;

import java.util.Stack;

public class GetMin_1 {
	Stack<Integer> stackData ;
	Stack<Integer> minStack ;
	public GetMin_1() {
		this.stackData =new Stack<>();
		this. minStack = new Stack<>();
	}
	
	public void push(int newData) {
		if(stackData.isEmpty()) {
			minStack.push(newData);
		}else {
			if(newData<=minStack.peek()) {
				minStack.push(newData);
			}
		}
		stackData.push(newData);
	}
	public int pop() {
		if(stackData.isEmpty()) {
			System.out.println();
			try {
				throw new Exception("栈为空，出栈失败");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		int data=stackData.pop();
		if(data==minStack.peek()) {
			minStack.pop();
		}
		return data;
	}
	public int getMin() {
		if(minStack.isEmpty()) {
			System.out.println();
			try {
				throw new Exception("栈为空，出栈失败");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return minStack.peek();
	}
	public static void main(String[] args) {
		GetMin_1 m= new GetMin_1();
		m.push(1);
		m.push(7);
		m.push(0);
		m.push(8);
		System.out.println(m.pop());
		System.out.println(m.getMin());
		System.out.println(m.pop());
		System.out.println(m.getMin());
		System.out.println(m.pop());
		System.out.println(m.getMin());
		
	}
}
