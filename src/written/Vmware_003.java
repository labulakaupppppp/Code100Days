package written;

import java.util.Scanner;

public class Vmware_003 {
	static int ans, w;
	static int[] a = new int[20];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int w = sc.nextInt();

		for (int i = 0; i < n; i++) {
			a[i] = sc.nextInt();
		}
		ans = n - 1;
		int state = 0;
		if (n == 0) {
			System.out.println(0);
			return;
		}
		dfs(n, state, 0, 1);
		System.out.println(ans);

	}

	private static void dfs(int n, int state, int c, int q) {
		if (state == (1 << n) - 1) {
			ans = Math.min(ans, q);
			return;
		}
		for (int i = 0; i < n; i++) {
			if (((1 << i) & state) == 0) {
				if (c + a[i] <= w) {
					dfs(n, state | (1 << i), c + a[i], q);
				} else {
					dfs(n, state | (1 << i), a[i], q + 1);
				}
			}
		}

	}
}
