package jianzhiOffer;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import structure.TreeNode;

public class Serialize_BST {
	String Serialize1(TreeNode root) {
		if (root == null)
			return "";
		String ans = "{";
		Queue<TreeNode> que = new LinkedList<>();
		que.add(root);
		while (!que.isEmpty()) {
			TreeNode node = que.poll();
			if (node != null) {
				ans += node.val;
				ans += ",";
				que.add(node.left);
				que.add(node.right);
			} else {
				ans += "#,";
			}
		}
		return ans + "}";
	}

	String Serialize(TreeNode root) {
		StringBuilder sb = new StringBuilder();
		if (root == null) {
			sb.append("#,");
			return sb.toString();
		}
		sb.append(root.val + ",");
		sb.append(Serialize(root.left));
		sb.append(Serialize(root.right));
		return sb.toString();
	}

	 int index = -1;
	 TreeNode Deserialize1(String str) {
	        index++;
	        //int len = str.length();
	        //if(index >= len){
	        //    return null;
	       // }
	        String[] strr = str.split(",");
	        TreeNode node = null;
	        if(!strr[index].equals("#")){
	            node = new TreeNode(Integer.valueOf(strr[index]));
	            node.left = Deserialize1(str);
	            node.right = Deserialize1(str);
	        }
	        return node;
	  }
	
	   //正确
	    String Serialize2(TreeNode root) {
	        StringBuilder sb = new StringBuilder();
	        if(root == null){
	            sb.append("#,");
	            return sb.toString();
	        }
	        sb.append(root.val + ",");
	        sb.append(Serialize2(root.left));
	        sb.append(Serialize2(root.right));
	        return sb.toString();
	  }
	    TreeNode Deserialize2(String str) {
	        index++;
	        String[] strr = str.split(",");
	        System.out.println(Arrays.toString(strr));
	        TreeNode node = null;
	        if(index==strr.length) return null;
	        if(!strr[index].equals("#")){
	            node = new TreeNode(Integer.valueOf(strr[index]));
	            node.left = Deserialize2(str);
	            node.right = Deserialize2(str);
	        }
	        return node;
	  }
	public static void main(String[] args) {
		Serialize_BST s1 = new Serialize_BST();
		TreeNode root = new TreeNode(1);
		TreeNode root1 = null;
		TreeNode root2 = new TreeNode(3);
		root.left = root1;
		root.right = root2;
		root2.left = null;
		root2.right = null;
		 String ans = s1.Serialize2(root);
		System.out.println(ans);
		// 1 2 * **
		TreeNode node = new TreeNode(1);
		TreeNode node1 = new TreeNode(2);
		TreeNode node2 = null;

		node.left = node1;
		node.right = node2;
		node1.left = null;
		node1.right = null;

		System.out.println("!!!!!!!");
		TreeNode nnn = s1.Deserialize2("8,6,10,5,7,9,11");
		String ans1 = s1.Serialize2(nnn);
		System.out.println(ans1);
	}

}
