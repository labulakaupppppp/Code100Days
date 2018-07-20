package satck_and_queue;

import java.util.Stack;

public class TwoStackToQueue {
	Stack<Integer> stack1;
	Stack<Integer> stack2;
	
	public TwoStackToQueue() {
		this.stack1= new Stack<>();
		this.stack2 = new Stack<>();
	}
	public void add(int data) {
		stack1.push(data);
	}
	public int poll() {
		int data;
		if(stack1.empty() && stack2.empty()) {
			throw new RuntimeException(" 队列为空 不可弹出");
		}
		if(!stack2.isEmpty()) {
			data=stack2.pop();
			return data;
		}else {
			while(!stack1.isEmpty()) {
				stack2.push(stack1.pop());
			}
			return stack2.pop();
		}
		
	}
	
	public int peek() {
		int data;
		if(stack1.empty() && stack2.empty()) {
			throw new RuntimeException(" 队列为空");
		}
		if(!stack2.isEmpty()) {
			data=stack2.peek();
			return data;
		}else {
			while(!stack1.isEmpty()) {
				stack2.push(stack1.pop());
			}
			return stack2.peek();
		}
		
	}
	public static void main(String[] args) {
		TwoStackToQueue que = new TwoStackToQueue();
		que.add(2);
		que.add(3);
		System.out.println(que.poll());//2
		que.add(0);
		System.out.println(que.poll());//3
		que.add(5);
		System.out.println(que.peek());//0
		que.add(7);
		que.add(9);
		System.out.println(que.peek());//0
	}

}
