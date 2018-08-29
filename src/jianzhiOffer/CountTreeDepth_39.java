package jianzhiOffer;

import java.util.LinkedList;
import java.util.Queue;

import structure.TreeNode;

/**
 * 输入一棵二叉树，求该树的深度。从根结点到叶结点依次经过的结点（含根、叶结点）形成树的一条路径，最长路径的长度为树的深度。
 * 
 * @author miaoyumiao_i
 *
 */

public class CountTreeDepth_39 {
	public static int TreeDepth(TreeNode root) {
		if (root == null)
			return 0;
		if (root.left == null && root.right == null)
			return 1;
		int left = TreeDepth(root.left);
		int right = TreeDepth(root.right);

		// return Math.max(left, right)+1;
		return left >= right ? left + 1 : right + 1;
	}
	public static int TreeDepth2(TreeNode root) {
		//层序遍历的方式统计深度
		if(root==null) return 0;
		int count=0;
		int nextcount=1;
		int depth =0;
		Queue<TreeNode> que = new LinkedList<>();
		que.add(root);
		while(que.size()!=0) {
			TreeNode node =que.poll();
			count++;
			if(node.left!=null) {
				que.add(node.left);
			}
			if(node.right!=null) {
				que.add(node.right);
			}
			if(count==nextcount) {
				depth++;
				nextcount=que.size();
				count=0;
			}
			
		}
		return depth;
	}
	public static void main(String[] args) {
		TreeNode root = new TreeNode(0);
		TreeNode node1 = new TreeNode(1);
		TreeNode node2 = new TreeNode(2);
		TreeNode node3 = new TreeNode(3);
		TreeNode node4 = new TreeNode(4);
		TreeNode node5 = new TreeNode(5);
		root.left = node1;
		root.right = node2;
		node1.left = node3;
		node1.right = node4;
		node2.left = node5;
		node2.right = null;
		node3.left = null;
		node3.right = null;
		node4.left = null;
		node4.right = null;
		node5.left = null;
		node5.right = null;
		System.out.println(TreeDepth2(root));

	}
}
