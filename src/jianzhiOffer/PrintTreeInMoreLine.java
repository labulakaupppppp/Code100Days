package jianzhiOffer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

import structure.TreeNode;
//将一棵树按层 存入ArrayList 中 ， 层序遍历
public class PrintTreeInMoreLine {
	ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
		ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
		printCore(pRoot, 1, ans);

		return ans;

	}

	private void printCore(TreeNode pRoot, int depth, ArrayList<ArrayList<Integer>> ans) {
		if (pRoot == null)
			return;
		if (depth > ans.size()) {

			ans.add(new ArrayList<>());
		}
		ans.get(depth - 1).add(pRoot.val);
		printCore(pRoot.left, depth + 1, ans);
		printCore(pRoot.right, depth + 1, ans);
	}

	ArrayList<ArrayList<Integer>> Print2(TreeNode pRoot) {
		ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
		if (pRoot == null)
			return ans;
		Queue<TreeNode> que = new LinkedList<>();
		ArrayList<Integer> layer = new ArrayList<>();
		int start = 0;
		int end = 1;
		que.add(pRoot);
		while (!que.isEmpty()) {
			TreeNode node = que.remove();
			layer.add(node.val);
			start++;
			if (node.left != null) {
				que.add(node.left);
			}
			if (node.right != null) {
				que.add(node.right);
			}
			if (start == end) {
				end = que.size();
				start = 0;
				ans.add(layer);
				layer = new ArrayList<Integer>();
			}

		}
		return ans;
	}

	public static void main(String[] args) {
		PrintTreeInMoreLine c = new PrintTreeInMoreLine();
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
		ArrayList<ArrayList<Integer>> ans1 = c.Print(pRoot);
		System.out.println(ans1.toString());
		System.out.println("~~~~~~~~~~~`");
		ArrayList<ArrayList<Integer>> ans = c.Print2(pRoot);
		System.out.println(ans.toString());
	}
}
