package written;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Microstrategy {
	private static int isPresent(Node root, int val) {
		/*判断一个val是否存在于二叉搜索树里
		 * For your reference class Node { Node left, right; int data; Node(int newData)
		 * { left = right = null; data = newData; } }
		 */
		if (root == null)
			return 0;
		if (root.data == val)
			return 1;
		int leftTree = 0;
		int rightTree = 0;
		if (root.data > val) {
			if (root.left != null)
				leftTree = isPresent(root.left, val);
		}
		if (leftTree == 1)
			return 1;
		if (root.data < val) {
			if (root.right != null)
				rightTree = isPresent(root.right, val);
		}
		if (rightTree == 1)
			return 1;
		return 0;

	}

	static String electionWinner(String[] votes) {
/**
 * 投票，票数多者胜出
 * 票数相同的，按照字母表顺序，输出后者 a b 平票 输出b
 */
		HashMap<String, Integer> map = new HashMap<>();
		for (int i = 0; i < votes.length; i++) {
			if (map.containsKey(votes[i])) {
				int temp = map.get(votes[i]);
				temp++;
				map.put(votes[i], temp);
			} else {
				map.put(votes[i], 1);
			}
		}
		String winner = null;
		Integer max = Integer.MIN_VALUE;
		for (Map.Entry<String, Integer> entry : map.entrySet()) {
			if (entry.getValue() > max) {
				max = entry.getValue();
				winner = entry.getKey();
			} else if (entry.getValue().equals(max)) {
				if (entry.getKey().compareToIgnoreCase(winner) > 0) {
					winner = entry.getKey();
					max = entry.getValue();
				}
			}

		}
		return winner;
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		int n = scanner.nextInt();
		String[] names = new String[n];
		for (int i = 0; i < n; i++) {
			names[i] = scanner.next();
		}
		System.out.println(electionWinner(names));
	}
}
