package jianzhiOffer;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import structure.TreeNode;

public class Serialize_BST {
	String Serialize1(TreeNode root) {
		if (root == null)
			return "";
		String ans = "";
		Queue<TreeNode> que = new LinkedList<>();
		que.add(root);
		while (!que.isEmpty()) {
			
			TreeNode node = que.poll();
			if (node != null) {
				ans += node.val;
				ans += " ";
				que.add(node.left);
				que.add(node.right);
			} else {
				ans += "* ";
			}

		}
		return ans;

	}
	String Serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        if(root == null){
            sb.append("* ");
            return sb.toString();
        }
        sb.append(root.val + " ");
        sb.append(Serialize(root.left));
        sb.append(Serialize(root.right));
        return sb.toString();
  }
  
	static int index = -1;

	TreeNode Deserialize(String str) {
		index++;
		if (str == null && str.length() == 0)
			return null;
		String[] ch = str.split(" ");
		//System.out.println(Arrays.toString(ch));
		TreeNode root = null;
		while (!ch[index].equals("*")) {
			root = new TreeNode(Integer.valueOf(ch[index]));
			root.left = Deserialize(str);
			root.right = Deserialize(str);
		}

		return root;

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
		String ans = s1.Serialize(root);
		System.out.println(ans);
		// 1 2 * **
		TreeNode node = new TreeNode(1);
		TreeNode node1 = new TreeNode(2);
		TreeNode node2 = null;

		node.left = node1;
		node.right = node2;
		node1.left = null;
		node1.right = null;
		
		System.out.println("!!!!!!!1");
		TreeNode nnn=s1.Deserialize("8 6 10 5 7 9 11");
		String ans1 = s1.Serialize1(nnn);
		System.out.println(ans1);
	}

}
