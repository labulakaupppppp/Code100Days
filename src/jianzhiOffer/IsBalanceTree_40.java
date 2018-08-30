package jianzhiOffer;

import structure.TreeNode;

public class IsBalanceTree_40 {
	/**
	 * 输入一棵二叉树，判断该二叉树是否是平衡二叉树
	 */
	public boolean IsBalanced_Solution(TreeNode root) {
		//分别求出每个节点的左右子树的高度。计算差值 小于1 即为平衡树 否则为非平衡树。
		if (root == null)
			return true;
		if (root.left == null && root.right == null)
			return true;
		int left = TreeDepth(root.left);
		int right = TreeDepth(root.right);
		int diff = left > right ? left - right : right - left;
		if (diff > 1)
			return false;
		return IsBalanced_Solution(root.left) && IsBalanced_Solution(root.right);
	}

	public static int TreeDepth(TreeNode root) {
		if (root == null)
			return 0;
		if (root.left == null && root.right == null)
			return 1;
		int left = TreeDepth(root.left);
		int right = TreeDepth(root.right);
		return Math.max(left, right) + 1;
	}
	/**
	 * 上面的方法 每个节点需要遍历很多次，下面进行减枝
	 */
	public static boolean is_balance(TreeNode root) {
		if(root==null)
			return true;
		int ans = getDepth(root);
		if(ans==-1)return false;
		return true;
	}

	private static int getDepth(TreeNode root) {
		// TODO Auto-generated method stub
		if(root==null)return 0;
		int left=getDepth(root.left);
		if(left==-1)return -1;
		int right=getDepth(root.right);
		if(right==-1)return -1;
		int diff=Math.abs(left-right);
		if(diff<=1)
			return 1+Math.max(left, right);
		return -1;
	}
}
