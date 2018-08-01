package linklist;

import java.util.LinkedList;
import java.util.Queue;

import structure.Print;
import structure.TreeNode;

public class ChangeBSTtoBinaryLinklist {
	public static TreeNode convert1(TreeNode pRootOfTree) {
		if (pRootOfTree == null) {
			return null;
		}
		Queue<TreeNode> queue = new LinkedList<>();
		inorderQueue(pRootOfTree, queue);
		//Print.printQueue(queue);
		TreeNode head = queue.poll();
		TreeNode pre = head;
		pre.left = null;
		TreeNode cur = null;
		while (!queue.isEmpty()) {
			cur = queue.poll();
			pre.right = cur;
			cur.left = pre;
			pre = cur;
		}
		pre.right = null;
		return head;
	}

	private static void inorderQueue(TreeNode root, Queue<TreeNode> queue) {
		if (root == null)
			return;
		inorderQueue(root.left, queue);
		queue.offer(root);
		inorderQueue(root.right, queue);

	}
//方法二 递归：
	public static TreeNode convert2(TreeNode root) {
		if(root==null)
			return null;
		if(root.left==null&&root.right==null)
            return root;
		TreeNode end=process(root);
		TreeNode head=end.right;
		end.right=null;
		return head;
	}
	//将最后一个节点指向头结点
	private static TreeNode process(TreeNode root) {
		// TODO Auto-generated method stub
		if(root==null) {
			return null;
		}
		TreeNode leftEnd = process(root.left);
		TreeNode rightEnd = process(root.right);
		TreeNode leftStart = leftEnd!=null?leftEnd.right:null;
		TreeNode rightStart = rightEnd!=null?rightEnd.right:null;
		if(leftEnd!=null && rightEnd!=null) {
			leftEnd.right=root;
			root.left=leftEnd;
			root.right=rightStart;
			rightStart.left=root;
			rightEnd.right=leftStart;
			return rightEnd;
		}else if(leftEnd!=null) {
			leftEnd.right=root;
			root.left=leftEnd;
			root.right=leftStart;
			return root;
		}else if(rightEnd!=null) {
			root.right=rightStart;
			rightStart.left=root;
			rightEnd.right=root;
			return rightEnd;
		}else {
			root.right=root;
			return root;
		}
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(6);
		TreeNode r4 = new TreeNode(4);
		TreeNode r2 = new TreeNode(2);
		TreeNode r5 = new TreeNode(5);
		TreeNode r1 = new TreeNode(1);
		TreeNode r3 = new TreeNode(3);
		TreeNode r7 = new TreeNode(7);
		TreeNode r9 = new TreeNode(9);
		TreeNode r8 = new TreeNode(8);
		root.left = r4;
		root.right = r7;
		r4.left = r2;
		r4.right = r5;
		r2.left = r1;
		r2.right = r3;
		r7.right = r9;
		r9.left = r8;
		r5.left = null;
		r5.right = null;
		r1.left = null;
		r1.right = null;
		r3.left = null;
		r3.right = null;
		r7.left = null;
		r9.right = null;
		r8.left = null;
		r8.right = null;
		TreeNode ans = convert1(root);
		Print.printTreeNode(ans);System.out.println();
		System.out.println("!!!!!!!!!!");
		
		TreeNode root_1 = new TreeNode(10);
		TreeNode r6_1 = new TreeNode(6);
		TreeNode r14_1 = new TreeNode(14);
		TreeNode r4_1 = new TreeNode(4);
		TreeNode r8_1 = new TreeNode(8);
		TreeNode r12_1= new TreeNode(12);
		TreeNode r16_1 = new TreeNode(16);
		root_1.left=r6_1;
		root_1.right=r14_1;
		r6_1.left=r4_1;
		r6_1.right=r8_1;
		r14_1.left=r12_1;
		r14_1.right=r16_1;
		r4_1.left=null;
		r4_1.right=null;
		r8_1.left=null;
		r8_1.right=null;
		r12_1.left=null;
		r12_1.right=null;
		r16_1.left=null;
		r16_1.right=null;
		TreeNode ans1 = convert2(root_1);
		Print.printTreeNode(ans1);
	}

}
