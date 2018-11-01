package jianzhiOffer;

import structure.TreeNode;

/**
 * 请实现一个函数，用来判断一颗二叉树是不是对称的。注意，如果一个二叉树同此二叉树的镜像是同样的，定义其为对称的。
 * 
 * @author miaoyumiao_i
 *
 */
public class IsSymmetrical {
	boolean isSymmetrical(TreeNode pRoot) {
		if(pRoot==null) return true;
		return isSymmetricalCore(pRoot.left,pRoot.right);			

	}

	private boolean isSymmetricalCore(TreeNode left, TreeNode right) {
		// TODO Auto-generated method stub
		if(left==null && right==null)
			return true;
		if(left==null || right ==null)
			return false;
		if(left.val!=right.val)
			return false;
		return isSymmetricalCore(left.left,right.right)&& isSymmetricalCore(left.right,right.left);
	}
}
