package code;

import java.util.LinkedList;
import java.util.Queue;
//2018 . 7 . 18
public class PrintTriangle {
	public static void printKK(int[][] nums, int row, int rows, int col, int cols) {
		for (int i = rows; i >= 0; i--) {
			int k = i;
			for (int j = 0; k <= rows; k++, j++) {
				System.out.print(nums[j][k] + ",");
			}
		}
		for (int i = 1; i <= rows; i++) {
			int k = i;
			for (int j = 0; k <= rows; k++, j++) {
				System.out.print(nums[k][j] + ",");
			}
		}
	}

	public static void print(int[][] nums) {
		int rows = nums.length;
		if (rows <= 0) {
			System.out.println("");
		} else {
			int cols = nums[0].length;
			printMian(nums, 0, rows - 1, 0, cols - 1);
			System.out.println("");
			printKK(nums, 0, rows - 1, 0, cols - 1);

		}
	}

	private static void printMian(int[][] nums, int row, int rows, int col, int cols) {
		// TODO Auto-generated method stub
		for (int i = 0; i < rows; i++) {
			for (int j = cols; j > i; j--) {
				System.out.print(nums[i][j] + ",");
			}
		}
		for (int i = 0; i <= rows; i++) {
			System.out.print(nums[i][i] + ",");
		}
		for (int k = 0; k <= rows; k++) {
			for (int i = k, j = col; i <= rows && i > j; i++, j++) {
				System.out.print(nums[i][j] + ",");
			}
		}
	}

	public static int[] printTreeWay(int[][] nums) {
		int rows = nums.length;
		if (rows <= 0)
			return null;
		int cols = nums[0].length;
		int[] ans = new int[rows * cols];
		int[][] visited = new int[rows][cols];
		rows--;
		cols--;
		System.out.println("rows:" + rows + "cols:" + cols);
		int i = 0;
		Queue<TreePoint> que = new LinkedList<TreePoint>();
		TreePoint point = new TreePoint();
		point.x = 0;
		point.y = cols;
		point.val = nums[0][cols];
		// System.out.println("point.x:"+point.x+"p.y:"+point.y);
		que.add(point);
		while (!que.isEmpty()) {
			TreePoint p = que.peek();
			que.remove();
			//System.out.println("p.x:" + p.x + "p.y:" + p.y);
			if (visited[p.x][p.y] == 0) {
				ans[i] = p.val;
				System.out.println("ans" + i + ":" + ans[i]);
				i++;
				visited[p.x][p.y] = 1;
				if (p.y >= 1 && p.x >= 0 && p.x <= rows &&p.y<=cols) {
					TreePoint p2 = new TreePoint();
					p2.x = p.x;
					p2.y = p.y - 1;
					p2.val = nums[p2.x][p2.y];
					que.add(p2);
					//visited[p2.x][p2.y] = 1;
				}
				System.out.println("~~~~~~~~~~~");
				System.out.println("p.x:" + p.x + "p.y:" + p.y);
				if (p.x + 1 <= rows && p.x >= 0 && p.y >= 0&& p.y<=cols) {
					TreePoint p3 = new TreePoint();
					p3.x = p.x + 1;
					p3.y = p.y;
					p3.val = nums[p3.x][p3.y];
					System.out.println("p3.x:" + p3.x + "p3.y:" + p3.y);
					que.add(p3);
					//visited[p3.x][p3.y] = 1;
				}
			}
		}
		return ans;
	}

	public static void main(String[] args) {
		int[][] nums = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
		print(nums);
		System.out.println("~~~~~~~");
		int[] ans = printTreeWay(nums);
		for (int i = 0; i < ans.length; i++) {
			System.out.println(ans[i]);
		}
		System.out.println(ans.toString());
	}
}
