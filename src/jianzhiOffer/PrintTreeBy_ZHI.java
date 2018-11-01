package jianzhiOffer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

import structure.TreeNode;

public class PrintTreeBy_ZHI {
	// 之字形打印二叉树
	public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
		ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
		if (pRoot == null)
			return ans;
		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(pRoot);
		boolean flag = false;
		while (!queue.isEmpty()) {
			ArrayList<Integer> tmp = new ArrayList<>();
			int size = queue.size();
			while (size > 0) {
				size--;
				TreeNode node = queue.poll();
				if (node != null) {
					tmp.add(node.val);
					queue.add(node.left);
					queue.add(node.right);
				}
			}
			if (flag) {
				Collections.reverse(tmp);
			}
			//每完成一层 flag翻转 并且tmp数组也翻转
			flag = !flag;
			if (tmp.size()!=0) {
				ans.add(tmp);

			}
		}
		return ans;
	}
	public static void main(String[] args) {
		TreeNode pRoot = new TreeNode(1);
		TreeNode pRoot2 = new TreeNode(2);
		TreeNode pRoot3 = new TreeNode(3);
		TreeNode pRoot4 = new TreeNode(4);
		TreeNode pRoot5 = new TreeNode(5);
		TreeNode pRoot6 = new TreeNode(6);
		TreeNode pRoot7 = new TreeNode(7);
		pRoot.left = pRoot2;
		pRoot.right = pRoot3;
		pRoot2.left = pRoot4;
		pRoot2.right = pRoot5;
		pRoot3.left = pRoot6;
		pRoot3.right = pRoot7;
		pRoot4.left = null;
		pRoot4.right = null;
		pRoot5.left = null;
		pRoot5.right = null;
		pRoot6.left = null;
		pRoot6.right = null;
		pRoot7.left = null;
		pRoot7.right = null;
		PrintTreeBy_ZHI cc = new PrintTreeBy_ZHI();
		cc.Print(pRoot);
		System.out.println(cc.Print(pRoot).toString());
		//[[1], [3, 2], [4, 5, 6, 7]]
	}

}
