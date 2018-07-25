package binary_search_tree;

import java.util.Stack;

import structure.TreeNode;

public class PrintTree_1 {
	public static void main(String[] args) {
		TreeNode head = new TreeNode(1);
		TreeNode h1 = new TreeNode(2);
		TreeNode h2 = new TreeNode(3);
		TreeNode h3 = new TreeNode(4);
		TreeNode h4 = new TreeNode(5);
		head.left = h1;
		head.right = h2;
		h1.left = h3;
		h1.right = h4;
		h2.left = null;
		h2.right = null;
		h3.left = null;
		h3.right = null;
		h4.left = null;
		h4.right = null;
		System.out.println("递归的先序遍历");
		preOrderRecur(head);
		System.out.println();
		System.out.println("非递归的先序遍历");
		preOrderUnRecur(head);
		System.out.println("递归的中序遍历");
		inOrderRecur(head);
		System.out.println();
		System.out.println("非递归的中序遍历");
		inOrderUnRecur(head);
		System.out.println("递归的后序遍历");
		posOrderRecur(head);
		System.out.println();
		System.out.println("非递归的后序遍历");
		posOrderUnRecur(head);
		System.out.println();
	}

	private static void posOrderUnRecur(TreeNode head) {
		Stack<TreeNode> stack1 = new Stack<TreeNode>();
		Stack<TreeNode> stack2 = new Stack<TreeNode>();
		TreeNode cur= head;
		stack1.push(cur);
		while(!stack1.isEmpty()){
			TreeNode temp=stack1.pop();
			stack2.push(temp);
			if(temp.left!=null)
				stack1.push(temp.left);
			if(temp.right!=null){
				stack1.push(temp.right);
			}
		}
		while(!stack2.isEmpty()){
			System.out.print(stack2.pop().val+" ");
		}

	}

	private static void inOrderUnRecur(TreeNode head) {
		if (head != null) {
			Stack<TreeNode> stack = new Stack<>();
			TreeNode cur = head;
			while (!stack.isEmpty() || cur != null) {
				if (cur != null) {
					stack.push(cur);
					cur = cur.left;
				} else {
					cur = stack.pop();
					System.out.print(cur.val + " ");
					cur = cur.right;
				}
			}
		}
		System.out.println();
	}

	private static void posOrderRecur(TreeNode head) {
		if (head == null)
			return;
		if (head.left != null)
			posOrderRecur(head.left);
		if (head.right != null)
			posOrderRecur(head.right);
		System.out.print(head.val + " ");
	}

	public static void preOrderRecur(TreeNode head) {
		// 递归先序遍历二叉树
		if (head == null) {
			return;
		}
		System.out.print(head.val + " ");
		if (head.left != null) {
			preOrderRecur(head.left);
		}
		if (head.right != null) {
			preOrderRecur(head.right);
		}
	}

	private static void preOrderUnRecur(TreeNode head) {
		Stack<TreeNode> stack = new Stack<>();
		// 1.將head入栈
		stack.add(head);
		while (!stack.isEmpty()) {
			// 栈不为空 先打印栈顶结点的val 在进行出栈操作。
			TreeNode temp = stack.peek();
			System.out.print(temp.val + " ");
			stack.pop();
			if (temp.right != null) {
				stack.push(temp.right);
			}
			if (temp.left != null) {
				stack.push(temp.left);
			}
		}
		System.out.println();
	}

	private static void inOrderRecur(TreeNode head) {
		// 递归的中序遍历
		if (head == null)
			return;
		if (head.left != null) {
			inOrderRecur(head.left);
		}
		System.out.print(head.val + " ");
		if (head.right != null) {
			inOrderRecur(head.right);
		}
	}
}
